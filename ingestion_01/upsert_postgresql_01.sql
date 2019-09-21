INSERT INTO :db_schema.:db_weather_table_01
SELECT _timestamp,
       longitude,
       latitude,
       ST_SETSRID(ST_POINT(longitude, latitude), 4326) AS geom,
       u_current,
       v_current,
       water_temperature,
       air_temperature
FROM :db_schema.:db_weather_table_temp_01
        ON CONFLICT ON CONSTRAINT weather_info_01_pkey
  DO
        UPDATE
       SET
       --    geom=ST_SETSRID(ST_POINT(EXCLUDED.longitude, EXCLUDED.latitude), 4326),
           u_wind=EXCLUDED.u_wind,
           v_wind=EXCLUDED.v_wind,
           u_current=EXCLUDED.u_current,
           v_current=EXCLUDED.v_current,
           water_temperature=EXCLUDED.water_temperature,
           air_temperature=EXCLUDED.air_temperature;
