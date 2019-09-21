#!/bin/bash
source /home/hhiweather/shell_script/util/read_properties.sh
source $UTIL/log_it.sh
source $UTIL/log_table_control.sh
source $UTIL/send_mail_log.sh

TARGET_FILENAME=$1
FILE_ROW_CNT=$2

log_it_kudu_01 "Step 2 : [KUDU][0.1][START] Kudu-Impala Load Data 작업 시작(Load Data ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01})"

kuduLoadDataResult=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_temp=${DB_WEATHER_TABLE_TEMP_01} --var=ingestion_zone_kudu=${INGESTION_ZONE_KUDU} --config_file=${CONFIG_KUDU_01} --query_file=${LOAD_DATA_KUDU_01}`

if [ $? -eq 0 ]; then
     log_it_kudu_01 "Step 2 : [KUDU][0.1][SUCCESS] Kudu-Impala Load Data 작업 완료(Load Data ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP_01})"
     tempRecordCnt=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_temp=${DB_WEATHER_TABLE_TEMP_01} --config_file=${CONFIG_KUDU} --query_file=${TEMPRECORDCNT_KUDU_01}`
     log_it_kudu_01 "file_count: ${FILE_ROW_CNT}"
     log_it_kudu_01 "record_count: ${tempRecordCnt}"
     log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`
     if [ "${FILE_ROW_CNT}" = "${tempRecordCnt}" ]; then
        title="Step 2 : [KUDU][0.1][SUCCESS] File Row 수와 레코드 수 검증 : 일치"
        log_it_kudu_01 "${title}"
        log_table_update_kudu_01 "Step2" "${TARGET_FILENAME}" "${title}" "${tempRecordCnt}" " " " "
        echo TARGET_FILENAME=$TARGET_FILENAME
	send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU_01}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
        exit 0;
     else
        title="Step 2 : [KUDU][0.1][FAIL] File Row 수와 레코드 수 검증 : 불일치"
        log_it_kudu_01 "${title}"
        log_table_update_kudu_01 "Step2" "${TARGET_FILENAME}" "${title}" "" "${tempRecordCnt}" "N"
        send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU_01}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
         exit 1;
     fi
else
     title="Step 2 : [KUDU][0.1][FAIL] Kudu-Impala Load Data 작업 실패  ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP}"
     log_it_kudu_01 "${title} ${kuduLoadDataResult}"
     log_table_update_kudu_01 "Step2" "${TARGET_FILENAME}" "${title}" "null" "${kuduLoadDataResult}" "N"
     send_mail  "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU_01}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 1;
fi

