#!/bin/bash
source /home/hhiweather/shell_script/util/read_properties.sh
source $UTIL/send_mail_log.sh

TODAY=`date  +%Y%m%d`

tableSizeSQL="SELECT table_schema, TABLE_NAME, pg_size_pretty(total_bytes) AS total
                     , pg_size_pretty(index_bytes) AS INDEX
                     , pg_size_pretty(toast_bytes) AS toast
                     , pg_size_pretty(table_bytes) AS TABLE
                FROM (
                      SELECT *, total_bytes-index_bytes-COALESCE(toast_bytes,0) AS table_bytes 
                        FROM (
                              SELECT c.oid,nspname AS table_schema, relname AS TABLE_NAME
                                     , c.reltuples AS row_estimate
                                     , pg_total_relation_size(c.oid) AS total_bytes
                                     , pg_indexes_size(c.oid) AS index_bytes
                                     , pg_total_relation_size(reltoastrelid) AS toast_bytes
                                FROM pg_class c
                                LEFT JOIN pg_namespace n 
                                  ON n.oid = c.relnamespace
                               WHERE relkind = 'r'
	                         AND nspname='${DB_SCHEMA}'
	                         AND relname like '${DB_WEATHER_TABLE}_20%'
                             ) a
                      ) a;"

psqlResult=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -A -F"," -c "${tableSizeSQL}" > "${HOME}/log/postgresql_table_size_${TODAY}.csv"`
sleep 5
send_mail "[MONITORING]PostgreSQL Weather Table Size" "${HOME}/log/postgresql_table_size_$TODAY.csv" "[MONITORING]PostgreSQL Weather Table Size" "${SYS_ADMIN}"

#####################################################0.1 GRID######################################################
tableSizeSQL_01="SELECT table_schema, TABLE_NAME, pg_size_pretty(total_bytes) AS total
                     , pg_size_pretty(index_bytes) AS INDEX
                     , pg_size_pretty(toast_bytes) AS toast
                     , pg_size_pretty(table_bytes) AS TABLE
                FROM (
                      SELECT *, total_bytes-index_bytes-COALESCE(toast_bytes,0) AS table_bytes
                        FROM (
                              SELECT c.oid,nspname AS table_schema, relname AS TABLE_NAME
                                     , c.reltuples AS row_estimate
                                     , pg_total_relation_size(c.oid) AS total_bytes
                                     , pg_indexes_size(c.oid) AS index_bytes
                                     , pg_total_relation_size(reltoastrelid) AS toast_bytes
                                FROM pg_class c
                                LEFT JOIN pg_namespace n
                                  ON n.oid = c.relnamespace
                               WHERE relkind = 'r'
                                 AND nspname='${DB_SCHEMA}'
                                 AND relname like '${DB_WEATHER_TABLE_01}_2%'
                             ) a
                      ) a;"

psqlResult_01=`psql -h ${DB_HOST} -p ${DB_PORT} -U ${DB_USER} -d ${DB_NAME} -t -A -F"," -c "${tableSizeSQL_01}" > "${HOME}/log/postgresql_table_01_size_${TODAY}.csv"`
sleep 5
send_mail "[MONITORING]PostgreSQL Weather Table_01 Size" "${HOME}/log/postgresql_table_01_size_$TODAY.csv" "[MONITORING]PostgreSQL Weather Table_01 Size" "${SYS_ADMIN}"
