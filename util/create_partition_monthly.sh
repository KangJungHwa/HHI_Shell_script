source /home/hhiweather/shell_script/util/read_properties.sh

maxPartitionSQL="SELECT MAX(relname) FROM pg_class a LEFT OUTER JOIN pg_namespace b ON a.relnamespace = b.oid
WHERE a.relkind = 'r' AND b.nspname = '${DB_SCHEMA}' AND a.relname LIKE '${DB_WEATHER_TABLE}_2%'";

maxPartition=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${maxPartitionSQL}"`;
maxPartition=`echo $maxPartition | xargs`;
maxPartitionDate=`echo "${maxPartition}" | awk -F_ '{print $3$4}'`'01'
#maxPartitionDate=YYYYMM01
nextPartitionYear=$(date -d "$maxPartitionDate +1 months" +'%Y')
nextPartitionMonth=$(date -d "$maxPartitionDate +1 months" +'%m')
nextPartitionDate=$(date -d "$maxPartitionDate +1 months" +'%Y%m')

echo "maxPartition: $maxPartition"
echo "maxPartitionDate: $maxPartitionDate"
echo "nextPartitionDate: $nextPartitionDate"

# 매달 1일마다 실행
##########################PostgreSQL################################
partition1=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "CREATE TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE}_${nextPartitionYear}_${nextPartitionMonth}_1 PARTITION OF ${DB_SCHEMA}.${DB_WEATHER_TABLE} FOR VALUES FROM ('${nextPartitionDate}0100') TO ('${nextPartitionDate}1024') TABLESPACE ${DB_WEATHER_TABLE}"`;
partition2=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "CREATE TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE}_${nextPartitionYear}_${nextPartitionMonth}_2 PARTITION OF ${DB_SCHEMA}.${DB_WEATHER_TABLE} FOR VALUES FROM ('${nextPartitionDate}1100') TO ('${nextPartitionDate}2024') TABLESPACE ${DB_WEATHER_TABLE}"`;
partition3=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "CREATE TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE}_${nextPartitionYear}_${nextPartitionMonth}_3 PARTITION OF ${DB_SCHEMA}.${DB_WEATHER_TABLE} FOR VALUES FROM ('${nextPartitionDate}2100') TO ('${nextPartitionDate}3124') TABLESPACE ${DB_WEATHER_TABLE}"`;

##########################Kudu#######################################
##########################10일 주기 Partition########################
partition_kudu1=`impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "ALTER TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU} ADD RANGE PARTITION '${nextPartitionDate}0100' <= VALUES < '${nextPartitionDate}1024'"`
partition_kudu2=`impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "ALTER TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU} ADD RANGE PARTITION '${nextPartitionDate}1100' <= VALUES < '${nextPartitionDate}2024'"`
partition_kudu3=`impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "ALTER TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU} ADD RANGE PARTITION '${nextPartitionDate}2100' <= VALUES < '${nextPartitionDate}3124'"`

##########################Kudu#######################################
##########################5일 주기 Partition#########################
for partition_start in {01..26..05}
do
        echo "${nextPartitionDate}${partition_start}"
	let partition_end=`expr ${partition_start} + 04`
	if [ ${partition_end} -eq 5 ]; then
	partition_end='0'${partition_end}
	fi
	if [ ${partition_end} -eq 30 ]; then
        partition_end=`expr ${partition_end} + 01`
        fi
	#echo "Partition_start: ${nextPartitionDate}${partition_start}, Partition_end: ${nextPartitionDate}${partition_end}"
        #impala-shell -u hhiweather -k --config_file=${CONFIG_KUDU} --query "ALTER TABLE ${DB_SCHEMA}.${DB_WEATHER_TABLE_KUDU} ADD RANGE PARTITION '${nextPartitionDate}${partition_start}00' <= VALUES < '${nextPartitionDate}${partition_end}24'"
done
