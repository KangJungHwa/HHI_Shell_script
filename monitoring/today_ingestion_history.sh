#!/bin/bash
source /home/hhiweather/shell_script/util/read_properties.sh
source $UTIL/send_mail_log.sh

TODAY=`date  +%Y-%m-%d`

logsql="select 'PG' orderkey ,a.* from weather_job_log a where etl_start_date>'${TODAY}'
union all
select 'KUDU' orderkey ,a.* from weather_job_log_kudu a where etl_start_date>'${TODAY}'
order by orderkey,etl_start_date;"

psqlResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -A -F"," -c "${logsql}" > "${HOME}/log/etl_log_${TODAY}.csv"`
sleep 10
send_mail "[MONITORING] 기상정보 적재 현황" "${HOME}/log/etl_log_${TODAY}.csv" "[MONITORING]기상정보 적재 현황" "${SYS_ADMIN}"


