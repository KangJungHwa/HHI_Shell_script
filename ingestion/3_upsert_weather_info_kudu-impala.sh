#!/bin/bash
source ${HOME}/shell_script/util/read_properties.sh
source $UTIL/log_it.sh
source $UTIL/log_table_control.sh
source $UTIL/send_mail_log.sh

TARGET_FILENAME=$1
#TARGET_FILENAME="20181117_12"

log_it_kudu "Step 3 : [KUDU][0.5][START] Kudu Upsert 작업 시작"

Upsert_Kudu_Impala=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_kudu=${DB_WEATHER_TABLE_KUDU} --var=db_weather_table_temp=${DB_WEATHER_TABLE_TEMP} --config_file=${CONFIG_KUDU} --query_file=${UPSERT_KUDU}`
log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S.%N`

if [ $? -eq 0 ]; then
     title="Step 3 : [KUDU][0.5][SUCCESS] Kudu Upsert 작업 완료"
     log_it_kudu "${title}"
     log_table_update_kudu  "Step3" "${TARGET_FILENAME}" "${title}" "Y" " "
     hdfs dfs -rm -skipTrash  ${INGESTION_ZONE_KUDU}"/"${TARGET_FILENAME}".csv"
     send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 0;
else
     title="Step 3 : [KUDU][0.5][FAIL] Kudu Upsert 작업 실패"
     log_it_kudu "${title} ${Upsert_Kudu_Impala}"
     log_table_update_kudu "Step3" "${TARGET_FILENAME}" "${title}" "N" "$Upsert_Kudu_Impala"
     send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 1;
fi
