#!/bin/bash
source /home/hhiweather/shell_script/util/read_properties.sh

VacuumFullSQL="VACUUM FULL ANALYZE ${DB_SCHEMA}.${DB_WEATHER_TABLE}"
VacuumFullSQL_01="VACUUM FULL ANALYZE ${DB_SCHEMA}.${DB_WEATHER_TABLE_01}"

psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${VacuumFullSQL}"
##########################################0.1 GRID#######################################
#psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -c "${VacuumFullSQL_01}"

