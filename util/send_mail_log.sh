#!/bin/bash
mail_sender="noreply@weather.hhi.co.kr"

function send_mail() {
   mail_msg=$1
   target_log=$2
   title=$3
   mail_receiver=$4
   echo "${mail_msg}" | mail -s "${title}"  -a "${target_log}" -r "${mail_sender}" "${mail_receiver}"
}

