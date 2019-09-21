#!/bin/bash
#export UTIL=/home/hhiweather/shell_script/util
source $UTIL/log_it.sh

#작업 결과 내역 weather_job_log 테이블에 Insert
function log_table_insert () {
  logInsertSQL="INSERT INTO ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG}(filename,jobstatus,file_row_cnt,table_cnt,success_yn,err_msg,etl_start_date,etl_end_date) "
  logInsertSQL=$logInsertSQL" VALUES('$1','$2',$3, $4, '$5',substr('$6',1,200),'$7',null)";
  echo "logInsertSQL : "$logInsertSQL
  insertLogResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${logInsertSQL}"`
  if [ $? -eq 0 ]; then
     log_it "Step 1 : [SUCCESS] 결과 테이블 ${DB_WEATHER_TABLE_LOG} Insert 완료"
  else
     log_it "Step 1 : [FAIL] 결과 테이블 ${DB_WEATHER_TABLE_LOG} Insert 실패 ${insertLogResult}"
     exit 1;
  fi
}

function log_table_insert_kudu () {
  logInsertSQL="INSERT INTO ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU}(filename,jobstatus,file_row_cnt,table_cnt,success_yn,err_msg,etl_start_date,etl_end_date) "
  logInsertSQL=$logInsertSQL" VALUES('$1','$2',$3, $4, '$5',substr('$6',1,200),'$7',null)";
  echo "logInsertSQL : "$logInsertSQL
  insertLogResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${logInsertSQL}"`
  if [ $? -eq 0 ]; then
     log_it_kudu "Step 1 : [SUCCESS] 결과 테이블 ${DB_WEATHER_TABLE_LOG_KUDU} Insert 완료"
  else
     log_it_kudu "Step 1 : [FAIL] 결과 테이블 ${DB_WEATHER_TABLE_LOG_KUDU} Insert 실패 ${insertLogResult}"
     exit 1;
  fi
}

###############################################0.1 GRID######################################################
function log_table_insert_01 () {
  logInsertSQL="INSERT INTO ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_01}(filename,jobstatus,file_row_cnt,table_cnt,success_yn,err_msg,etl_start_date,etl_end_date) "
  logInsertSQL=$logInsertSQL" VALUES('$1','$2',$3, $4, '$5',substr('$6',1,200),'$7',null)";
  echo "logInsertSQL : "$logInsertSQL
  insertLogResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${logInsertSQL}"`
  if [ $? -eq 0 ]; then
     log_it_01 "Step 1 : [SUCCESS] 결과 테이블 ${DB_WEATHER_TABLE_LOG_01} Insert 완료"
  else
     log_it_01 "Step 1 : [FAIL] 결과 테이블 ${DB_WEATHER_TABLE_LOG_01} Insert 실패 ${insertLogResult}"
     exit 1;
  fi
}

function log_table_insert_kudu_01 () {
  logInsertSQL="INSERT INTO ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU_01}(filename,jobstatus,file_row_cnt,table_cnt,success_yn,err_msg,etl_start_date,etl_end_date) "
  logInsertSQL=$logInsertSQL" VALUES('$1','$2',$3, $4, '$5',substr('$6',1,200),'$7',null)";
  echo "logInsertSQL : "$logInsertSQL
  insertLogResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${logInsertSQL}"`
  if [ $? -eq 0 ]; then
     log_it_kudu_01 "Step 1 : [SUCCESS] 결과 테이블 ${DB_WEATHER_TABLE_LOG_KUDU_01} Insert 완료"
  else
     log_it_kudu_01 "Step 1 : [FAIL] 결과 테이블 ${DB_WEATHER_TABLE_LOG_KUDU_01} Insert 실패 ${insertLogResult}"
     exit 1;
  fi
}


#작업 결과 내역 weather_job_log 테이블에 update
function log_table_update () {
   if [ $1 = "Step2" ]; then
    logUpdateSQL="UPDATE ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG} "
    logUpdateSQL=$logUpdateSQL" SET jobstatus='$3', table_cnt=$4, err_msg=substr('$5',1,200), success_yn='$6' "
    logUpdateSQL=$logUpdateSQL" WHERE filename='$2' AND row_id=(SELECT MAX(row_id) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG} WHERE filename='$2') ";
   else
    logUpdateSQL="UPDATE ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG} "
    logUpdateSQL=$logUpdateSQL" SET jobstatus='$3', success_yn='$4', err_msg=substr('$5',1,200), etl_end_date=now() "
    logUpdateSQL=$logUpdateSQL" WHERE filename='$2' AND row_id=(SELECT MAX(row_id) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG} WHERE filename='$2') ";
   fi
    echo "logUpdateSQL"${logUpdateSQL}
    updateLogResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${logUpdateSQL}"`
        if [ $? -eq 0 ]; then
           log_it "Step 2 : [SUCCESS] 결과 테이블(${DB_WEATHER_TABLE_LOG}) Update 완료"
        else
           log_it "Step 2 : [FAIL] 결과 테이블(${DB_WEATHER_TABLE_LOG})Update $updateLogResult"
           exit;
        fi
}

function log_table_update_kudu () {
   if [ $1 = "Step2" ]; then
    logUpdateSQL="UPDATE ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU} "
    logUpdateSQL=$logUpdateSQL" SET jobstatus='$3', table_cnt=$4, err_msg=substr('$5',1,200), success_yn='$6' "
    logUpdateSQL=$logUpdateSQL" WHERE filename='$2' AND row_id=(SELECT MAX(row_id) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU} WHERE filename='$2') ";
   else
    logUpdateSQL="UPDATE ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU} "
    logUpdateSQL=$logUpdateSQL" SET jobstatus='$3', success_yn='$4', err_msg=substr('$5',1,200), etl_end_date=now() "
    logUpdateSQL=$logUpdateSQL" WHERE filename='$2' AND row_id=(SELECT MAX(row_id) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU} WHERE filename='$2') ";
   fi
    echo "logUpdateSQL"${logUpdateSQL}
    updateLogResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${logUpdateSQL}"`
        if [ $? -eq 0 ]; then
           log_it_kudu "Step 2 : [SUCCESS] 결과 테이블(${DB_WEATHER_TABLE_LOG_KUDU}) Update 완료"
        else
           log_it_kudu "Step 2 : [FAIL] 결과 테이블(${DB_WEATHER_TABLE_LOG_KUDU})Update $updateLogResult"
           exit;
        fi
}

###############################################0.1 GRID######################################################


function log_table_update_01 () {
   if [ $1 = "Step2" ]; then
    logUpdateSQL="UPDATE ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_01} "
    logUpdateSQL=$logUpdateSQL" SET jobstatus='$3', table_cnt=$4, err_msg=substr('$5',1,200), success_yn='$6' "
    logUpdateSQL=$logUpdateSQL" WHERE filename='$2' AND row_id=(SELECT MAX(row_id) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_01} WHERE filename='$2') ";
   else
    logUpdateSQL="UPDATE ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG} "
    logUpdateSQL=$logUpdateSQL" SET jobstatus='$3', success_yn='$4', err_msg=substr('$5',1,200), etl_end_date=now() "
    logUpdateSQL=$logUpdateSQL" WHERE filename='$2' AND row_id=(SELECT MAX(row_id) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_01} WHERE filename='$2') ";
   fi
    echo "logUpdateSQL"${logUpdateSQL}
    updateLogResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${logUpdateSQL}"`
        if [ $? -eq 0 ]; then
           log_it_01 "Step 2 : [SUCCESS] 결과 테이블(${DB_WEATHER_TABLE_LOG_01}) Update 완료"
        else
           log_it_01 "Step 2 : [FAIL] 결과 테이블(${DB_WEATHER_TABLE_LOG_01})Update $updateLogResult"
           exit;
        fi
}

function log_table_update_kudu_01 () {
   if [ $1 = "Step2" ]; then
    logUpdateSQL="UPDATE ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU_01} "
    logUpdateSQL=$logUpdateSQL" SET jobstatus='$3', table_cnt=$4, err_msg=substr('$5',1,200), success_yn='$6' "
    logUpdateSQL=$logUpdateSQL" WHERE filename='$2' AND row_id=(SELECT MAX(row_id) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU_01} WHERE filename='$2') ";
   else
    logUpdateSQL="UPDATE ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU} "
    logUpdateSQL=$logUpdateSQL" SET jobstatus='$3', success_yn='$4', err_msg=substr('$5',1,200), etl_end_date=now() "
    logUpdateSQL=$logUpdateSQL" WHERE filename='$2' AND row_id=(SELECT MAX(row_id) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG_KUDU_01} WHERE filename='$2') ";
   fi
    echo "logUpdateSQL"${logUpdateSQL}
    updateLogResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${logUpdateSQL}"`
        if [ $? -eq 0 ]; then
           log_it_kudu_01 "Step 2 : [SUCCESS] 결과 테이블(${DB_WEATHER_TABLE_LOG_KUDU_01}) Update 완료"
        else
           log_it_kudu_01 "Step 2 : [FAIL] 결과 테이블(${DB_WEATHER_TABLE_LOG_KUDU_01})Update $updateLogResult"
           exit;
        fi
}
