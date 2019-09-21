#!/bin/bash
source /home/hhiweather/shell_script/util/read_properties.sh
source $UTIL/log_it.sh
source $UTIL/log_table_control.sh
source $UTIL/send_mail_log.sh

TARGET_FILENAME=$1
#TARGET_FILENAME="20181130_06"

log_it "Step 3 : [PostgreSQL][0.5][START] Postgresql Upsert 작업 시작"

psqlResult=`psql -v db_schema=${DB_SCHEMA} -v db_weather_table=${DB_WEATHER_TABLE} -v db_weather_table_temp=${DB_WEATHER_TABLE_TEMP} -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -f "${UPSERT_POSTGRESQL}"`
log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`

if [ $? -eq 0 ]; then
     title="Step 3 : [PostgreSQL][0.5][SUCCESS] Postgresql Upsert 작업 완료"
     log_it "${title}"
     log_table_update  "Step3" "${TARGET_FILENAME}" "${title}" "Y" " "
     hdfs dfs -rm -skipTrash  ${INGESTION_ZONE}"/"${TARGET_FILENAME}".csv"
     send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 0;
else
     title="Step 3 : [PostgreSQL][0.5][FAIL] Postgresql Upsert 작업 실패"
     log_it "${title} ${psqlResult}"
     log_table_update "Step3" "${TARGET_FILENAME}" "${title}" "N" "$psqlResult"
     send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 1;
fi
