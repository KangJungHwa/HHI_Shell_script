#!/bin/bash
export UTIL=/home/hhiweather/shell_script/util
 
propertiesFile="$UTIL/weather.properties"
if [ -f "$propertiesFile" ]
then
  echo "$propertiesFile found."
  while IFS='=' read -r key value
  do
    key=$(echo $key)
    eval ${key}=\${value}
  done < "$propertiesFile"
else
  echo "$propertiesFile not found."
fi
