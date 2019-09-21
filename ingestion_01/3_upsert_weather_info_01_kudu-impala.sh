#!/bin/bash
source ${HOME}/shell_script/util/read_properties.sh
source $UTIL/log_it.sh
source $UTIL/log_table_control.sh
source $UTIL/send_mail_log.sh

TARGET_FILENAME=$1
#TARGET_FILENAME="20181117_12_01"

log_it_kudu_01 "Step 3 : [KUDU][0.1][START] Kudu Upsert 작업 시작"

Upsert_Kudu_Impala=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_kudu=${DB_WEATHER_TABLE_KUDU_01} --var=db_weather_table_temp=${DB_WEATHER_TABLE_TEMP_01} --config_file=${CONFIG_KUDU_01} --query_file=${UPSERT_KUDU_01}`
log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`

if [ $? -eq 0 ]; then
     title="Step 3 : [KUDU][0.1][SUCCESS] Kudu Upsert 작업 완료"
     log_it_kudu_01 "${title}"
     log_table_update_kudu_01  "Step3" "${TARGET_FILENAME}" "${title}" "Y" " "
     hdfs dfs -rm -skipTrash  ${INGESTION_ZONE_KUDU}"/"${TARGET_FILENAME}'_01'".csv"
     send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU_01}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 0;
else
     title="Step 3 : [KUDU][0.1][FAIL] Kudu Upsert 작업 실패"
     log_it_kudu_01 "${title} ${Upsert_Kudu_Impala}"
     log_table_update_kudu_01 "Step3" "${TARGET_FILENAME}" "${title}" "N" "$Upsert_Kudu_Impala"
     send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU_01}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 1;
fi
