#!/bin/bash
TODAY=`date --date 'now' +%Y%m%d` 
LOG_FILE=OozieDataIngestion_PostgreSQL_"$TODAY".txt
LOG_FILE_01=OozieDataIngestion_PostgreSQL_01_"$TODAY".txt
LOG_FILE_KUDU=OozieDataIngestion_KUDU_"$TODAY".txt
LOG_FILE_KUDU_01=OozieDataIngestion_KUDU_01_"$TODAY".txt

function log_it() {
    echo "$@"
    echo "[$(date +"%Y/%m/%d %T")]: $@" >> $HOME/log/$LOG_FILE
}

function log_it_kudu() {
    echo "$@"
    echo "[$(date +"%Y/%m/%d %T")]: $@" >> $HOME/log/$LOG_FILE_KUDU
}

##########################################0.1 GRID############################################
function log_it_01() {
    echo "$@"
    echo "[$(date +"%Y/%m/%d %T")]: $@" >> $HOME/log/$LOG_FILE_01
}

function log_it_kudu_01() {
    echo "$@"
    echo "[$(date +"%Y/%m/%d %T")]: $@" >> $HOME/log/$LOG_FILE_KUDU_01
}
