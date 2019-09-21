INSERT INTO :db_schema.:db_weather_table
SELECT _timestamp,
       longitude,
       latitude,
       ST_SETSRID(ST_POINT(longitude, latitude), 4326) AS geom,
       u_wind,
       v_wind,
       wave_height,
       wave_direction,
       wave_period,
       swell_height,
       swell_direction,
       swell_period,
       ice_cover,
       u_current,
       v_current,
       water_temperature,
       pressure,
       air_temperature
FROM :db_schema.:db_weather_table_temp
        ON CONFLICT ON CONSTRAINT weather_info_pkey
  DO
        UPDATE
       SET
       --    geom=ST_SETSRID(ST_POINT(EXCLUDED.longitude, EXCLUDED.latitude), 4326),
           u_wind=EXCLUDED.u_wind,
           v_wind=EXCLUDED.v_wind,
           wave_height=EXCLUDED.wave_height,
           wave_direction=EXCLUDED.wave_direction,
           wave_period=EXCLUDED.wave_period,
           swell_height=EXCLUDED.swell_height,
           swell_direction=EXCLUDED.swell_direction,
           swell_period=EXCLUDED.swell_period,
           ice_cover=EXCLUDED.ice_cover,
           u_current=EXCLUDED.u_current,
           v_current=EXCLUDED.v_current,
           water_temperature=EXCLUDED.water_temperature,
           pressure=EXCLUDED.pressure,
           air_temperature=EXCLUDED.air_temperature;
