#!/bin/bash
source ${HOME}/shell_script/util/read_properties.sh
source $UTIL/send_mail_log.sh

TODAY=`date +%Y-%m-%d`
DAY_AGO=`date -d '1 day ago' +%Y-%m-%d`
TODAY_LOG=`date +%Y%m%d`

QUERY="SELECT+total_kudu_on_disk_size_across_kudu_replicas/1024/1024/1024+WHERE+category%3dKUDU_TABLE+and+serviceName%3D%22kudu2%22&contentType=text%2Fcsv&from=${DAY_AGO}T02%3A16%3A28.716Z&to=${TODAY}T02%3A16%3A28.716Z&desiredRollup=DAILY&mustUseDesiredRollup=true"

curl -s -u hhiweather:Bigdata1! http://un.hhi.co.kr:7180/api/v6/timeseries?query="${QUERY}" > ${HOME}/log/kudu_table_size_before_convert_${TODAY_LOG}.csv
cat ${HOME}/log/kudu_table_size_before_convert_${TODAY_LOG}.csv | awk -F "," '/^"/{print $1","$3","substr($4,0,index($4,".")-1)substr($4,index($4,"."),index($4,".")+2)" GB"}' > ${HOME}/log/kudu_table_size_monitoring_${TODAY_LOG}.csv
sleep 10
send_mail "[MONITORING] Kudu Table Size 모니터링" "${HOME}/log/kudu_table_size_monitoring_${TODAY_LOG}.csv" "[MONITORING] Kudu Table Size 모니터링" "${SYS_ADMIN}"
