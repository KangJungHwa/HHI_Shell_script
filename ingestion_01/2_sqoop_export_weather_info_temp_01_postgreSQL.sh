#!/bin/bash
source ${HOME}/shell_script/util/read_properties.sh
source $UTIL/log_it_01.sh
source $UTIL/log_table_control.sh
source $UTIL/send_mail_log.sh

TARGET_FILENAME=$1
FILE_ROW_CNT=$2
SQOOP_TARGET_FILENAME=${TARGET_FILENAME}'_01'".csv"
#TARGET_FILENAME="20181129_18"
#FILE_ROW_CNT=1502280
#SQOOP_TARGET_FILENAME=${TARGET_FILENAME}".csv"

log_it_01 "Step 2 : [PostgreSQL][0.1][START] Sqoop Eval 작업 시작(Truncate PostgreSQL Table ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01})"

#PostgreSQL 임시 Weather 테이블 Truncate
sqoop eval -Dhadoop.security.credential.provider.path=jceks://hdfs/user/hhiweather/pg_password.jceks --connect ${DB_CON} --username ${DB_USER} --password-alias ${PG_ALIAS} --query "TRUNCATE TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01}" >> ${HOME}/log/${LOG_FILE_01} 2>&1
log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`
if [ $? -eq 0 ]; then
     log_it_01 "Step 2 : [PostgreSQL][0.1][SUCCESS] Sqoop Eval 작업 완료(Truncate PostgreSQL Table ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01}"
else
     title="Step 2 : [PostgreSQL][0.1][FAIL] Sqoop Eval 작업 실패 Truncate PostgreSQL Table ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01}"
     log_it_01 "${title} "
     log_table_update_01 "Step2" "${TARGET_FILENAME}" "${title}" "null" " " "N"
     send_mail  "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_01}" "[Ooize Workflow] ${title}" "${ETL_RECEIVER}"
     exit 1;
fi

log_it_01 "Step 2 : [0.1][START] Sqoop Export 작업 시작(HDFS to PostgreSQL Table ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01})"

#Sqoop Export(HDFS to PostgreSQL 임시 Weather 테이블)
sqoop export -Dhadoop.security.credential.provider.path=jceks://hdfs/user/hhiweather/pg_password.jceks --connect ${DB_CON} --username ${DB_USER} --password-alias ${PG_ALIAS} --table ${DB_WEATHER_TABLE_TEMP_01} --export-dir ${INGESTION_ZONE}/${SQOOP_TARGET_FILENAME} --num-mappers 16 --fields-terminated-by ',' --lines-terminated-by '\n' -- --schema ${DB_SCHEMA} >> ${HOME}/log/${LOG_FILE_01} 2>&1

if [ $? -eq 0 ]; then
     log_it_01 "Step 2 : [PostgreSQL][0.1][SUCCESS] Sqoop Export 작업 완료(HDFS to PostgreSQL Table ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01})"
     tempRecordCntSQL="SELECT COUNT(1) as cnt FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01}";
     recordCnt=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${tempRecordCntSQL}" `
     recordCnt=`echo $recordCnt | xargs`
     log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`
     if [ "${FILE_ROW_CNT}" = "${recordCnt}" ]; then
        title="Step 2 : [PostgreSQL][0.1][SUCCESS] File Row 수와 레코드 수 검증 : 일치"
        log_it_01 "${title}"
        log_table_update_01 "Step2" "${TARGET_FILENAME}" "${title}" "${recordCnt}" " " " "
        echo TARGET_FILENAME=$TARGET_FILENAME
	send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_01}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
        exit 0;
     else
        title="Step 2 : [PostgreSQL][0.1][FAIL] File Row 수와 레코드 수 검증 : 불일치"
        log_it_01 "record_count:${recordCnt} ${title} "
        log_table_update_01 "Step2" "${TARGET_FILENAME}" "${title}" "" "${recordCnt}" "N"
        send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_01}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
         exit 1;
     fi
else
     title="Step 2 : [PostgreSQL][0.1][FAIL] Sqoop Export 작업 실패  ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01}"
     log_it_01 "${title} ${sqoopResult}"
     log_table_update_01 "Step2" "${TARGET_FILENAME}" "${title}" "null" " " "N"
     send_mail  "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_01}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 1;
fi

