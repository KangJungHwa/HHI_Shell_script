#!/bin/bash
source ${HOME}/shell_script/util/read_properties.sh
source $UTIL/send_mail_log.sh

TODAY=`date  +%Y%m%d`

curl "http://mn01.hhi.co.kr:50070/dfshealth.jsp" >> ${HOME}/log/hdfs_report_$TODAY.html

send_mail "[MONITORING] HDFS Summary Repory" "${HOME}/log/hdfs_report_$TODAY.html" "HDFS Summary Report" ${SYS_ADMIN}

