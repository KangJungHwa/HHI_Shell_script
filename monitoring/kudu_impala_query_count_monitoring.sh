#!/bin/bash
source ${HOME}/shell_script/util/read_properties.sh
source $UTIL/send_mail_log.sh

TODAY=`date  +%Y-%m-%d`
MONTH_AGO=`date -d '1month ago' +%Y-%m-%d`
TODAY_LOG=`date  +%Y%m%d`

#QUERY="SELECT+counter_delta(queries_ingested_rate)%2C+counter_delta(impala_query_memory_spilled_rate)+WHERE+serviceName%3D%22impala%22+AND+CATEGORY%3DIMPALA_POOL_USER&contentType=text%2Fcsv&from=${MONTH_AGO}T02%3A16%3A28.716Z&to=${TODAY}T02%3A16%3A28.716Z&desiredRollup=WEEKLY&mustUseDesiredRollup=true"
QUERY="SELECT+counter_delta(queries_ingested_rate)+WHERE+serviceName%3D%22impala%22+AND+CATEGORY%3DIMPALA_POOL_USER&contentType=text%2Fcsv&from=${MONTH_AGO}T02%3A16%3A28.716Z&to=${TODAY}T02%3A16%3A28.716Z&desiredRollup=WEEKLY&mustUseDesiredRollup=true"

curl -s -u hhiweather:Bigdata1! http://un.hhi.co.kr:7180/api/v9/timeseries?query="${QUERY}" > ${HOME}/log/kudu_impala_query_count_by_user_${TODAY_LOG}.csv
sleep 10
send_mail "[MONITORING]사용자별 Impala Query Count 모니터링" "${HOME}/log/kudu_impala_query_count_by_user_${TODAY_LOG}.csv" "[MONITORING]사용자별 Impala Query Count 모니터링" "$SYS_ADMIN"
