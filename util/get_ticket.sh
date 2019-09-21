#!/bin/bash
src_dir="$(dirname "$0")" 
source $src_dir/log_it.sh

kerberos_ticket= `kinit -kt /opt/cloudera/security/keytab/hhiweather.keytab hhiweather@AD.HHI.CO.KR`
  if [ $? -eq 1 ]; then
     log_it $kerberos_ticket
     log_it "Step 1 : User:hhiweather의 Kerberos Ticket 발급 실패"
     exit 1;
  else
     log_it $kerberos_ticket
     log_it "Step 1 : User:hhiweather의 Kerberos Ticket 발급 성공"
  fi

