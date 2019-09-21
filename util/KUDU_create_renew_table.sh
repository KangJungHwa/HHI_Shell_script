source /home/hhiweather/shell_script/util/read_properties.sh
source $UTIL/log_it.sh

#########################################################################
#1. 데이터 이관 테이블 생성
#########################################################################
title="----------------1. 데이터 이관 테이블 생성------------------------"
RENEW_TABLE_CREATE=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_kudu_renew=${DB_WEATHER_TABLE_KUDU_RENEW} --config_file=${CONFIG_KUDU} --query_file=${RENEW_TABLE_CREATE}`
log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title}"
sleep 5;

#########################################################################
#2. 이관 테이블 Partition 추가(PostgreSQL Partition 과 동일)
#########################################################################
title="---2. 이관 테이블 Partition 추가(PostgreSQL Partition 과 동일)----"

log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title}"
maxPartitionSQL="SELECT MAX(relname) FROM pg_class a LEFT OUTER JOIN pg_namespace b ON a.relnamespace = b.oid
WHERE a.relkind = 'r' AND b.nspname = '${DB_SCHEMA}' AND a.relname LIKE '${DB_WEATHER_TABLE}_2%'";

maxPartition=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${maxPartitionSQL}"`;
maxPartition=`echo $maxPartition | xargs`;
maxPartitionDate=`echo "${maxPartition}" | awk -F_ '{print $3$4}'`'01'
nextPartitionDate=$(date -d "$maxPartitionDate +1 months" +'%Y%m')

echo "maxPartition: $maxPartition"
echo "maxPartitionDate: $maxPartitionDate"
echo "nextPartitionDate: $nextPartitionDate"

##########################Kudu#######################################
##########################10일 주기 Partition########################
for i in {1..1000}
do
        kuduMaxPartition=`impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "SHOW RANGE PARTITIONS ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU_RENEW}" | awk '{print $1}' | sed 's/"//g'| tail -n 1 | cut -b1-6`
        kuduMaxPartitionDate=${kuduMaxPartition}'01'
        echo "kuduMaxPartitionDate: ${kuduMaxPartitionDate}"
        kuduNextPartitionDate=$(date -d "$kuduMaxPartitionDate +1 months" +'%Y%m%d')
        kuduNextPartitionStart=$(date -d "$kuduMaxPartitionDate +1 months" +'%Y%m')
        echo "kuduNextPartitionDate: ${kuduNextPartitionDate}"
        echo "kuduNextPartitionStart: ${kuduNextPartitionStart}"
        echo "maxPartitionDate: ${maxPartitionDate}"
        if [ ${kuduNextPartitionDate} -gt ${maxPartitionDate} ]; then
                break;
        else
		partition_kudu1=`impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "ALTER TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU_RENEW} ADD RANGE PARTITION '${kuduNextPartitionStart}0100' <= VALUES < '${kuduNextPartitionStart}1024'"`
		partition_kudu2=`impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "ALTER TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU_RENEW} ADD RANGE PARTITION '${kuduNextPartitionStart}1100' <= VALUES < '${kuduNextPartitionStart}2024'"`
		partition_kudu3=`impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "ALTER TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU_RENEW} ADD RANGE PARTITION '${kuduNextPartitionStart}2100' <= VALUES < '${kuduNextPartitionStart}3124'"`
        fi
done
log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title} 완료"
##########################Kudu#######################################
##########################5일 주기 Partition########################
#for i in {1..1000}
#do
#	kuduMaxPartition=`impala-shell -i dn01 --delimited --query "show range partitions ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU}" | awk '{print $1}' | sed 's/"//g'| tail -n 1 | cut -b1-6`
#	kuduMaxPartitionDate=${kuduMaxPartition}'01'
#	echo "kuduMaxPartitionDate: ${kuduMaxPartitionDate}"
#	kuduNextPartitionDate=$(date -d "$kuduMaxPartitionDate +1 months" +'%Y%m%d')
#	kuduNextPartitionStart=$(date -d "$kuduMaxPartitionDate +1 months" +'%Y%m')
#	echo "kuduNextPartitionDate: ${kuduNextPartitionDate}"
#	echo "kuduNextPartitionStart: ${kuduNextPartitionStart}"
#	echo "maxPartitionDate: ${maxPartitionDate}"
#	if [ ${kuduNextPartitionDate} -eq ${maxPartitionDate} ]; then
#		break;
#	else
#		for day_start in {01..26..05}
#		do
#			let day_end=`expr ${day_start} + 04`
#			if [ ${day_end} -eq 5 ]; then
#				day_end='0'${day_end}
#			fi
#			if [ ${day_end} -eq 30 ]; then
#        			day_end=`expr ${day_end} + 01`
#        		fi
#			#echo "KUDU Next Partition Start: ${kuduNextPartitionStart}${day_start}, KUDU Next Partition End: ${kuduNextPartitionStart}${day_end}"
#        		#impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "ALTER TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU}_test_part ADD RANGE PARTITION '${kuduNextPartitionStart}${day_start}00' <= VALUES < '${kuduNextPartitionStart}${day_end}24'"
#		done
#	fi
#done
#log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title}"

#########################################################################
#3. Old Table -> Renew Table Data Insert
#########################################################################
title="---------3. Old Table -> Renew Table Data Insert-----------------"
log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title_start}"
RENEW_TABLE_INSERT_DATA=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_kudu_renew=${DB_WEATHER_TABLE_KUDU_RENEW} --var=db_weather_table_kudu=${DB_WEATHER_TABLE_KUDU} --config_file=${CONFIG_KUDU} --query_file=${RENEW_TABLE_INSERT_DATA}`
if [ $? -eq 1 ]; then
	log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title} 실패"
	exit 1;
fi
log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title_end} 완료"

#########################################################################
#4. 이전 테이블 삭제
#########################################################################
title="----------------4. 이전 테이블 삭제-------------------------------"
sleep 5;
RENEW_DROP_OLD_TABLE=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_kudu=${DB_WEATHER_TABLE_KUDU} --config_file=${CONFIG_KUDU} --query_file=${RENEW_DROP_OLD_TABLE}`
if [ $? -eq 1 ]; then
	log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title} 실패"
	exit 1;
fi
log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title} 완료"

#########################################################################
#5. 데이터 이관 테이블 명칭 변경
echo "----------------5. 데이터 이관 테이블 명칭 변경------------------"
#########################################################################
title="----------------5. 데이터 이관 테이블 명칭 변경------------------"
sleep 5;
RENEW_TABLE_RENAME=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_kudu_renew=${DB_WEATHER_TABLE_KUDU_RENEW} --var=db_weather_table_kudu=${DB_WEATHER_TABLE_KUDU} --config_file=${CONFIG_KUDU} --query_file=${RENEW_TABLE_RENAME}`
if [ $? -eq 1 ]; then
	log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title} 실패"
        exit 1;
fi
log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title} 완료"

#########################################################################
#6. 이관 테이블 Kudu.table_name meta 변경
#########################################################################
title="----------------6. 이관 테이블 Kudu.table_name meta 변경----------"
sleep 5;
RENEW_TABLE_CHANGE_KUDUMETA=`impala-shell -u hhiweather -k --var=db_schema=${DB_SCHEMA} --var=db_weather_table_kudu=${DB_WEATHER_TABLE_KUDU} --config_file=${CONFIG_KUDU} --query_file=${RENEW_TABLE_CHANGE_KUDUMETA}`
if [ $? -eq 1 ]; then
	log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title} 실패"
        exit 1;
fi
log_it_kudu "[`date -d 'now' +%Y-%m-%dT%H:%M:%S`]" "${title} 완료"
