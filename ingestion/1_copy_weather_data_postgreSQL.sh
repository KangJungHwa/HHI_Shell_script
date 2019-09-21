#!/bin/bash
source ${HOME}/shell_script/util/read_properties.sh
source $UTIL/log_it.sh
source $UTIL/log_table_control.sh
source $UTIL/send_mail_log.sh

#데이터 적재 작업 최근 완료 날짜 출력
maxFilenameSQL="SELECT MAX(filename) FROM ${DB_SCHEMA}.${DB_WEATHER_TABLE_LOG} WHERE success_yn ='Y'";
maxFilename=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${maxFilenameSQL}"`
maxFilename=`echo $maxFilename | xargs`
log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`

if [ ${#maxFilename} -eq 11 ]; then
   log_it "Step 1 : [PostgreSQL][0.5][SUCCESS] 데이터 적재 작업 최근 완료 날짜 출력 완료($maxFilename)"
else
   title="Step 1 : [PostgreSQL][0.5][FAIL] 데이터 적재 작업 최근 완료 날짜 출력 실패 ($maxFilename)"
   log_it "${title} ${maxFilename}"
   log_table_insert "${nextFilename}" "${title}" "null" "null" "N" "${maxFilename}" "${log_time}"
   send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
   exit 1;
fi

maxFile_time_str=`echo "${maxFilename}" | awk -F_ '{print $2}'`
maxFile_date_str=`echo "${maxFilename}" | awk -F_ '{print $1}'`
echo "maxFile_date_str : "${maxFile_date_str}
nextDay=$(date -d "$maxFile_date_str +1 days" +'%Y%m%d')

nextFilename=""
echo "nextDay" $nextDay

if [ "$maxFile_time_str" = "00" ]; then
    nextFilename=${maxFile_date_str}"_06"
elif [ "$maxFile_time_str" = "06" ]; then
    nextFilename=${maxFile_date_str}"_12"
elif [ "$maxFile_time_str" = "12" ]; then
    nextFilename=${maxFile_date_str}"_18"
elif [ "$maxFile_time_str" = "18" ]; then
    nextFilename=${nextDay}"_00"
fi
echo "nextFilename"$nextFilename

#(HDFS) Landingzone 기상 데이터 유무 확인
log_it "Step 1 : ${LANGDING_ZONE} 0.5 GRID 기상 데이터 유무 확인"
target=`hdfs dfs -ls ${LANDING_ZONE} | grep ${nextFilename} | awk '{print $8}' | sed 's/_tmp_//g'`
hdfs dfs -test -e ${target}
if [ $? -eq 0 ]; then
     title="Step 1 : [PostgreSQL][0.5][SUCCESS] (HDFS)Landingzone 기상 데이터 파일(${nextFilename}) 있음"
     log_it "${title}"
else
     for i in {1..20}; 
     do
	log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`
     	hdfs dfs -test -e ${target}
     	if [ $? -eq 0 ]; then
     	   	title="Step 1 : [PostgreSQL][0.5][SUCCESS] (HDFS)Landingzone 기상 데이터 파일(${nextFilename}) 있음"
     	   	log_it "${log_time}" "${title}"
     	   	break;
     	else
		title="Step 1 : [PostgreSQL][0.5][FAIL] (HDFS)Landingzone 기상 데이터 파일(${nextFilename}) 없음 - ${i}/20번째(15분 주기 파일 탐색)"
                log_it "${log_time}" "${title}"
	   	if [ ${i} -eq 20 ]; then
        		title="Step 1 : [PostgreSQL][0.5][FAIL] (HDFS)Landingzone 기상 데이터 파일(${nextFilename}) 없음"
	        	log_table_insert "${nextFilename}" "${title}" "null" "null" "N" "${target}" "${log_time}"
	        	send_mail "[${log_time}] ${title}" "${HOME}/log/${LOG_FILE}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
	        	exit 1;
	  	fi
	     	sleep 840;#sleep 60 -> 1분
	   fi
     done
fi

#(HDFS) LANDINGZONE -----> (HDFS)ETLdata
log_it "Step 1 : ${target} -----> ${INGESTION_ZONE} 복사 시작"
cpResult=`hdfs dfs -cp -f ${target} ${INGESTION_ZONE}"/"`
log_time=`date -d 'now' +%Y-%m-%dT%H:%M:%S`
if [ $? -eq 0 ]; then
     title="Step 1 : [PostgreSQL][0.5][SUCCESS] (HDFS)Landingzone -----> ETLdata 복사 완료"
     log_it "${title}"
     file_row_cnt=`hdfs dfs -cat  /HHI/project/hhiweather/ETLdata/$nextFilename.csv | wc -l`
     log_table_insert "${nextFilename}" "${title}" "${file_row_cnt}" "null" " " " " "${log_time}"
     echo TARGET_FILENAME=${nextFilename};
     echo FILE_ROW_CNT=${file_row_cnt};
     send_mail "[${log_time}] ${title} ${file_row_cnt}" "${HOME}/log/${LOG_FILE}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 0;
else
     title="Step 1 : [PostgreSQL][0.5][FAIL] (HDFS)Landingzone -----> ETLdata 복사 실패"
     log_it "${title} ${cpResult}"
     log_table_insert "${nextFilename}" "${title}" "null" "null" "N" "${cpResult}" "${log_time}"
     send_mail "[${log_time}] ${title} ${file_row_cnt}" "${HOME}/log/${LOG_FILE}" "[Oozie Workflow] ${title}" "${ETL_RECEIVER}"
     exit 1;
fi
