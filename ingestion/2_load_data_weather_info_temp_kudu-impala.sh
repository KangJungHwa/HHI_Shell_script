#!/bin/bash
source /home/hhiweather/shell_script/util/read_properties.sh
source $UTIL/log_it.sh
source $UTIL/log_table_control.sh
source $UTIL/send_mail_log.sh

TARGET_FILENAME=$1
FILE_ROW_CNT=$2

log_it_kudu "Step 2 : [KUDU][0.5][START] Kudu-Impala Load Data 작업 시작(Load Data ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP})"

kuduLoadDataResult=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_temp=${DB_WEATHER_TABLE_TEMP} --var=ingestion_zone_kudu=${INGESTION_ZONE_KUDU} --config_file=${CONFIG_KUDU} --query_file=${LOAD_DATA_KUDU}`
sleep 5;

if [ $? -eq 0 ]; then
     log_it_kudu "Step 2 : [KUDU][0.5][SUCCESS] Kudu-Impala Load Data 작업 완료(Load Data ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP})"
     tempRecordCnt=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_temp=${DB_WEATHER_TABLE_TEMP} --config_file=${CONFIG_KUDU} --query_file=${TEMPRECORDCNT_KUDU}`
     log_it_kudu "file_count: ${FILE_ROW_CNT}"
     log_it_kudu "record_count: ${tempRecordCnt}"
     log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`
     if [ "${FILE_ROW_CNT}" = "${tempRecordCnt}" ]; then
        title="Step 2 : [KUDU][0.5][SUCCESS] File Row 수와 레코드 수 검증 : 일치"
        log_it_kudu "${title}"
        log_table_update_kudu "Step2" "${TARGET_FILENAME}" "${title}" "${tempRecordCnt}" " " " "
        echo TARGET_FILENAME=$TARGET_FILENAME
	send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
        exit 0;
     else
        title="Step 2 : [KUDU][0.5][FAIL] File Row 수와 레코드 수 검증 : 불일치"
        log_it_kudu "${title}"
        log_table_update_kudu "Step2" "${TARGET_FILENAME}" "${title}" "" "${tempRecordCnt}" "N"
        send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
        exit 1;
     fi
else
     title="Step 2 : [KUDU][[0.5][FAIL] Kudu-Impala Load Data 작업 실패  ${DB_SCHEMA}.${DB_WEATHER_TABLE_TEMP}"
     log_it_kudu "${title} ${kuduLoadDataResult}"
     log_table_update_kudu "Step2" "${TARGET_FILENAME}" "${title}" "null" "${kuduLoadDataResult}" "N"
     send_mail  "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE_KUDU}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 1;
fi

