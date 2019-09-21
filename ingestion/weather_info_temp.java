// ORM class for table 'weather_info_temp'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu Jan 10 14:36:59 KST 2019
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class weather_info_temp extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("_timestamp", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        __timestamp = (String)value;
      }
    });
    setters.put("longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        longitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        latitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("u_wind_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        u_wind_direction = (java.math.BigDecimal)value;
      }
    });
    setters.put("v_wind_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        v_wind_direction = (java.math.BigDecimal)value;
      }
    });
    setters.put("wind_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        wind_direction = (java.math.BigDecimal)value;
      }
    });
    setters.put("wind_speed", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        wind_speed = (java.math.BigDecimal)value;
      }
    });
    setters.put("wave_height", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        wave_height = (java.math.BigDecimal)value;
      }
    });
    setters.put("wave_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        wave_direction = (java.math.BigDecimal)value;
      }
    });
    setters.put("wave_period", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        wave_period = (java.math.BigDecimal)value;
      }
    });
    setters.put("swell_height", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        swell_height = (java.math.BigDecimal)value;
      }
    });
    setters.put("swell_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        swell_direction = (java.math.BigDecimal)value;
      }
    });
    setters.put("swell_period", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        swell_period = (java.math.BigDecimal)value;
      }
    });
    setters.put("ice_cover", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ice_cover = (java.math.BigDecimal)value;
      }
    });
    setters.put("u_stream_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        u_stream_direction = (java.math.BigDecimal)value;
      }
    });
    setters.put("v_stream_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        v_stream_direction = (java.math.BigDecimal)value;
      }
    });
    setters.put("stream_direction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        stream_direction = (java.math.BigDecimal)value;
      }
    });
    setters.put("stream_speed", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        stream_speed = (java.math.BigDecimal)value;
      }
    });
    setters.put("water_temperature", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        water_temperature = (java.math.BigDecimal)value;
      }
    });
    setters.put("pressure", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        pressure = (java.math.BigDecimal)value;
      }
    });
    setters.put("air_temperature", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        air_temperature = (java.math.BigDecimal)value;
      }
    });
  }
  public weather_info_temp() {
    init0();
  }
  private String __timestamp;
  public String get___timestamp() {
    return __timestamp;
  }
  public void set___timestamp(String __timestamp) {
    this.__timestamp = __timestamp;
  }
  public weather_info_temp with___timestamp(String __timestamp) {
    this.__timestamp = __timestamp;
    return this;
  }
  private java.math.BigDecimal longitude;
  public java.math.BigDecimal get_longitude() {
    return longitude;
  }
  public void set_longitude(java.math.BigDecimal longitude) {
    this.longitude = longitude;
  }
  public weather_info_temp with_longitude(java.math.BigDecimal longitude) {
    this.longitude = longitude;
    return this;
  }
  private java.math.BigDecimal latitude;
  public java.math.BigDecimal get_latitude() {
    return latitude;
  }
  public void set_latitude(java.math.BigDecimal latitude) {
    this.latitude = latitude;
  }
  public weather_info_temp with_latitude(java.math.BigDecimal latitude) {
    this.latitude = latitude;
    return this;
  }
  private java.math.BigDecimal u_wind_direction;
  public java.math.BigDecimal get_u_wind_direction() {
    return u_wind_direction;
  }
  public void set_u_wind_direction(java.math.BigDecimal u_wind_direction) {
    this.u_wind_direction = u_wind_direction;
  }
  public weather_info_temp with_u_wind_direction(java.math.BigDecimal u_wind_direction) {
    this.u_wind_direction = u_wind_direction;
    return this;
  }
  private java.math.BigDecimal v_wind_direction;
  public java.math.BigDecimal get_v_wind_direction() {
    return v_wind_direction;
  }
  public void set_v_wind_direction(java.math.BigDecimal v_wind_direction) {
    this.v_wind_direction = v_wind_direction;
  }
  public weather_info_temp with_v_wind_direction(java.math.BigDecimal v_wind_direction) {
    this.v_wind_direction = v_wind_direction;
    return this;
  }
  private java.math.BigDecimal wind_direction;
  public java.math.BigDecimal get_wind_direction() {
    return wind_direction;
  }
  public void set_wind_direction(java.math.BigDecimal wind_direction) {
    this.wind_direction = wind_direction;
  }
  public weather_info_temp with_wind_direction(java.math.BigDecimal wind_direction) {
    this.wind_direction = wind_direction;
    return this;
  }
  private java.math.BigDecimal wind_speed;
  public java.math.BigDecimal get_wind_speed() {
    return wind_speed;
  }
  public void set_wind_speed(java.math.BigDecimal wind_speed) {
    this.wind_speed = wind_speed;
  }
  public weather_info_temp with_wind_speed(java.math.BigDecimal wind_speed) {
    this.wind_speed = wind_speed;
    return this;
  }
  private java.math.BigDecimal wave_height;
  public java.math.BigDecimal get_wave_height() {
    return wave_height;
  }
  public void set_wave_height(java.math.BigDecimal wave_height) {
    this.wave_height = wave_height;
  }
  public weather_info_temp with_wave_height(java.math.BigDecimal wave_height) {
    this.wave_height = wave_height;
    return this;
  }
  private java.math.BigDecimal wave_direction;
  public java.math.BigDecimal get_wave_direction() {
    return wave_direction;
  }
  public void set_wave_direction(java.math.BigDecimal wave_direction) {
    this.wave_direction = wave_direction;
  }
  public weather_info_temp with_wave_direction(java.math.BigDecimal wave_direction) {
    this.wave_direction = wave_direction;
    return this;
  }
  private java.math.BigDecimal wave_period;
  public java.math.BigDecimal get_wave_period() {
    return wave_period;
  }
  public void set_wave_period(java.math.BigDecimal wave_period) {
    this.wave_period = wave_period;
  }
  public weather_info_temp with_wave_period(java.math.BigDecimal wave_period) {
    this.wave_period = wave_period;
    return this;
  }
  private java.math.BigDecimal swell_height;
  public java.math.BigDecimal get_swell_height() {
    return swell_height;
  }
  public void set_swell_height(java.math.BigDecimal swell_height) {
    this.swell_height = swell_height;
  }
  public weather_info_temp with_swell_height(java.math.BigDecimal swell_height) {
    this.swell_height = swell_height;
    return this;
  }
  private java.math.BigDecimal swell_direction;
  public java.math.BigDecimal get_swell_direction() {
    return swell_direction;
  }
  public void set_swell_direction(java.math.BigDecimal swell_direction) {
    this.swell_direction = swell_direction;
  }
  public weather_info_temp with_swell_direction(java.math.BigDecimal swell_direction) {
    this.swell_direction = swell_direction;
    return this;
  }
  private java.math.BigDecimal swell_period;
  public java.math.BigDecimal get_swell_period() {
    return swell_period;
  }
  public void set_swell_period(java.math.BigDecimal swell_period) {
    this.swell_period = swell_period;
  }
  public weather_info_temp with_swell_period(java.math.BigDecimal swell_period) {
    this.swell_period = swell_period;
    return this;
  }
  private java.math.BigDecimal ice_cover;
  public java.math.BigDecimal get_ice_cover() {
    return ice_cover;
  }
  public void set_ice_cover(java.math.BigDecimal ice_cover) {
    this.ice_cover = ice_cover;
  }
  public weather_info_temp with_ice_cover(java.math.BigDecimal ice_cover) {
    this.ice_cover = ice_cover;
    return this;
  }
  private java.math.BigDecimal u_stream_direction;
  public java.math.BigDecimal get_u_stream_direction() {
    return u_stream_direction;
  }
  public void set_u_stream_direction(java.math.BigDecimal u_stream_direction) {
    this.u_stream_direction = u_stream_direction;
  }
  public weather_info_temp with_u_stream_direction(java.math.BigDecimal u_stream_direction) {
    this.u_stream_direction = u_stream_direction;
    return this;
  }
  private java.math.BigDecimal v_stream_direction;
  public java.math.BigDecimal get_v_stream_direction() {
    return v_stream_direction;
  }
  public void set_v_stream_direction(java.math.BigDecimal v_stream_direction) {
    this.v_stream_direction = v_stream_direction;
  }
  public weather_info_temp with_v_stream_direction(java.math.BigDecimal v_stream_direction) {
    this.v_stream_direction = v_stream_direction;
    return this;
  }
  private java.math.BigDecimal stream_direction;
  public java.math.BigDecimal get_stream_direction() {
    return stream_direction;
  }
  public void set_stream_direction(java.math.BigDecimal stream_direction) {
    this.stream_direction = stream_direction;
  }
  public weather_info_temp with_stream_direction(java.math.BigDecimal stream_direction) {
    this.stream_direction = stream_direction;
    return this;
  }
  private java.math.BigDecimal stream_speed;
  public java.math.BigDecimal get_stream_speed() {
    return stream_speed;
  }
  public void set_stream_speed(java.math.BigDecimal stream_speed) {
    this.stream_speed = stream_speed;
  }
  public weather_info_temp with_stream_speed(java.math.BigDecimal stream_speed) {
    this.stream_speed = stream_speed;
    return this;
  }
  private java.math.BigDecimal water_temperature;
  public java.math.BigDecimal get_water_temperature() {
    return water_temperature;
  }
  public void set_water_temperature(java.math.BigDecimal water_temperature) {
    this.water_temperature = water_temperature;
  }
  public weather_info_temp with_water_temperature(java.math.BigDecimal water_temperature) {
    this.water_temperature = water_temperature;
    return this;
  }
  private java.math.BigDecimal pressure;
  public java.math.BigDecimal get_pressure() {
    return pressure;
  }
  public void set_pressure(java.math.BigDecimal pressure) {
    this.pressure = pressure;
  }
  public weather_info_temp with_pressure(java.math.BigDecimal pressure) {
    this.pressure = pressure;
    return this;
  }
  private java.math.BigDecimal air_temperature;
  public java.math.BigDecimal get_air_temperature() {
    return air_temperature;
  }
  public void set_air_temperature(java.math.BigDecimal air_temperature) {
    this.air_temperature = air_temperature;
  }
  public weather_info_temp with_air_temperature(java.math.BigDecimal air_temperature) {
    this.air_temperature = air_temperature;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof weather_info_temp)) {
      return false;
    }
    weather_info_temp that = (weather_info_temp) o;
    boolean equal = true;
    equal = equal && (this.__timestamp == null ? that.__timestamp == null : this.__timestamp.equals(that.__timestamp));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    equal = equal && (this.u_wind_direction == null ? that.u_wind_direction == null : this.u_wind_direction.equals(that.u_wind_direction));
    equal = equal && (this.v_wind_direction == null ? that.v_wind_direction == null : this.v_wind_direction.equals(that.v_wind_direction));
    equal = equal && (this.wind_direction == null ? that.wind_direction == null : this.wind_direction.equals(that.wind_direction));
    equal = equal && (this.wind_speed == null ? that.wind_speed == null : this.wind_speed.equals(that.wind_speed));
    equal = equal && (this.wave_height == null ? that.wave_height == null : this.wave_height.equals(that.wave_height));
    equal = equal && (this.wave_direction == null ? that.wave_direction == null : this.wave_direction.equals(that.wave_direction));
    equal = equal && (this.wave_period == null ? that.wave_period == null : this.wave_period.equals(that.wave_period));
    equal = equal && (this.swell_height == null ? that.swell_height == null : this.swell_height.equals(that.swell_height));
    equal = equal && (this.swell_direction == null ? that.swell_direction == null : this.swell_direction.equals(that.swell_direction));
    equal = equal && (this.swell_period == null ? that.swell_period == null : this.swell_period.equals(that.swell_period));
    equal = equal && (this.ice_cover == null ? that.ice_cover == null : this.ice_cover.equals(that.ice_cover));
    equal = equal && (this.u_stream_direction == null ? that.u_stream_direction == null : this.u_stream_direction.equals(that.u_stream_direction));
    equal = equal && (this.v_stream_direction == null ? that.v_stream_direction == null : this.v_stream_direction.equals(that.v_stream_direction));
    equal = equal && (this.stream_direction == null ? that.stream_direction == null : this.stream_direction.equals(that.stream_direction));
    equal = equal && (this.stream_speed == null ? that.stream_speed == null : this.stream_speed.equals(that.stream_speed));
    equal = equal && (this.water_temperature == null ? that.water_temperature == null : this.water_temperature.equals(that.water_temperature));
    equal = equal && (this.pressure == null ? that.pressure == null : this.pressure.equals(that.pressure));
    equal = equal && (this.air_temperature == null ? that.air_temperature == null : this.air_temperature.equals(that.air_temperature));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof weather_info_temp)) {
      return false;
    }
    weather_info_temp that = (weather_info_temp) o;
    boolean equal = true;
    equal = equal && (this.__timestamp == null ? that.__timestamp == null : this.__timestamp.equals(that.__timestamp));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    equal = equal && (this.u_wind_direction == null ? that.u_wind_direction == null : this.u_wind_direction.equals(that.u_wind_direction));
    equal = equal && (this.v_wind_direction == null ? that.v_wind_direction == null : this.v_wind_direction.equals(that.v_wind_direction));
    equal = equal && (this.wind_direction == null ? that.wind_direction == null : this.wind_direction.equals(that.wind_direction));
    equal = equal && (this.wind_speed == null ? that.wind_speed == null : this.wind_speed.equals(that.wind_speed));
    equal = equal && (this.wave_height == null ? that.wave_height == null : this.wave_height.equals(that.wave_height));
    equal = equal && (this.wave_direction == null ? that.wave_direction == null : this.wave_direction.equals(that.wave_direction));
    equal = equal && (this.wave_period == null ? that.wave_period == null : this.wave_period.equals(that.wave_period));
    equal = equal && (this.swell_height == null ? that.swell_height == null : this.swell_height.equals(that.swell_height));
    equal = equal && (this.swell_direction == null ? that.swell_direction == null : this.swell_direction.equals(that.swell_direction));
    equal = equal && (this.swell_period == null ? that.swell_period == null : this.swell_period.equals(that.swell_period));
    equal = equal && (this.ice_cover == null ? that.ice_cover == null : this.ice_cover.equals(that.ice_cover));
    equal = equal && (this.u_stream_direction == null ? that.u_stream_direction == null : this.u_stream_direction.equals(that.u_stream_direction));
    equal = equal && (this.v_stream_direction == null ? that.v_stream_direction == null : this.v_stream_direction.equals(that.v_stream_direction));
    equal = equal && (this.stream_direction == null ? that.stream_direction == null : this.stream_direction.equals(that.stream_direction));
    equal = equal && (this.stream_speed == null ? that.stream_speed == null : this.stream_speed.equals(that.stream_speed));
    equal = equal && (this.water_temperature == null ? that.water_temperature == null : this.water_temperature.equals(that.water_temperature));
    equal = equal && (this.pressure == null ? that.pressure == null : this.pressure.equals(that.pressure));
    equal = equal && (this.air_temperature == null ? that.air_temperature == null : this.air_temperature.equals(that.air_temperature));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.__timestamp = JdbcWritableBridge.readString(1, __dbResults);
    this.longitude = JdbcWritableBridge.readBigDecimal(2, __dbResults);
    this.latitude = JdbcWritableBridge.readBigDecimal(3, __dbResults);
    this.u_wind_direction = JdbcWritableBridge.readBigDecimal(4, __dbResults);
    this.v_wind_direction = JdbcWritableBridge.readBigDecimal(5, __dbResults);
    this.wind_direction = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.wind_speed = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.wave_height = JdbcWritableBridge.readBigDecimal(8, __dbResults);
    this.wave_direction = JdbcWritableBridge.readBigDecimal(9, __dbResults);
    this.wave_period = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.swell_height = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.swell_direction = JdbcWritableBridge.readBigDecimal(12, __dbResults);
    this.swell_period = JdbcWritableBridge.readBigDecimal(13, __dbResults);
    this.ice_cover = JdbcWritableBridge.readBigDecimal(14, __dbResults);
    this.u_stream_direction = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.v_stream_direction = JdbcWritableBridge.readBigDecimal(16, __dbResults);
    this.stream_direction = JdbcWritableBridge.readBigDecimal(17, __dbResults);
    this.stream_speed = JdbcWritableBridge.readBigDecimal(18, __dbResults);
    this.water_temperature = JdbcWritableBridge.readBigDecimal(19, __dbResults);
    this.pressure = JdbcWritableBridge.readBigDecimal(20, __dbResults);
    this.air_temperature = JdbcWritableBridge.readBigDecimal(21, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.__timestamp = JdbcWritableBridge.readString(1, __dbResults);
    this.longitude = JdbcWritableBridge.readBigDecimal(2, __dbResults);
    this.latitude = JdbcWritableBridge.readBigDecimal(3, __dbResults);
    this.u_wind_direction = JdbcWritableBridge.readBigDecimal(4, __dbResults);
    this.v_wind_direction = JdbcWritableBridge.readBigDecimal(5, __dbResults);
    this.wind_direction = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.wind_speed = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.wave_height = JdbcWritableBridge.readBigDecimal(8, __dbResults);
    this.wave_direction = JdbcWritableBridge.readBigDecimal(9, __dbResults);
    this.wave_period = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.swell_height = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.swell_direction = JdbcWritableBridge.readBigDecimal(12, __dbResults);
    this.swell_period = JdbcWritableBridge.readBigDecimal(13, __dbResults);
    this.ice_cover = JdbcWritableBridge.readBigDecimal(14, __dbResults);
    this.u_stream_direction = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.v_stream_direction = JdbcWritableBridge.readBigDecimal(16, __dbResults);
    this.stream_direction = JdbcWritableBridge.readBigDecimal(17, __dbResults);
    this.stream_speed = JdbcWritableBridge.readBigDecimal(18, __dbResults);
    this.water_temperature = JdbcWritableBridge.readBigDecimal(19, __dbResults);
    this.pressure = JdbcWritableBridge.readBigDecimal(20, __dbResults);
    this.air_temperature = JdbcWritableBridge.readBigDecimal(21, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(__timestamp, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(longitude, 2 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(latitude, 3 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(u_wind_direction, 4 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(v_wind_direction, 5 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wind_direction, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wind_speed, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wave_height, 8 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wave_direction, 9 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wave_period, 10 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(swell_height, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(swell_direction, 12 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(swell_period, 13 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(ice_cover, 14 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(u_stream_direction, 15 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(v_stream_direction, 16 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(stream_direction, 17 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(stream_speed, 18 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(water_temperature, 19 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pressure, 20 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_temperature, 21 + __off, 2, __dbStmt);
    return 21;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(__timestamp, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(longitude, 2 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(latitude, 3 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(u_wind_direction, 4 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(v_wind_direction, 5 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wind_direction, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wind_speed, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wave_height, 8 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wave_direction, 9 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(wave_period, 10 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(swell_height, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(swell_direction, 12 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(swell_period, 13 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(ice_cover, 14 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(u_stream_direction, 15 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(v_stream_direction, 16 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(stream_direction, 17 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(stream_speed, 18 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(water_temperature, 19 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pressure, 20 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(air_temperature, 21 + __off, 2, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.__timestamp = null;
    } else {
    this.__timestamp = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.longitude = null;
    } else {
    this.longitude = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.latitude = null;
    } else {
    this.latitude = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.u_wind_direction = null;
    } else {
    this.u_wind_direction = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.v_wind_direction = null;
    } else {
    this.v_wind_direction = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wind_direction = null;
    } else {
    this.wind_direction = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wind_speed = null;
    } else {
    this.wind_speed = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wave_height = null;
    } else {
    this.wave_height = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wave_direction = null;
    } else {
    this.wave_direction = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wave_period = null;
    } else {
    this.wave_period = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.swell_height = null;
    } else {
    this.swell_height = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.swell_direction = null;
    } else {
    this.swell_direction = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.swell_period = null;
    } else {
    this.swell_period = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.ice_cover = null;
    } else {
    this.ice_cover = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.u_stream_direction = null;
    } else {
    this.u_stream_direction = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.v_stream_direction = null;
    } else {
    this.v_stream_direction = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.stream_direction = null;
    } else {
    this.stream_direction = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.stream_speed = null;
    } else {
    this.stream_speed = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.water_temperature = null;
    } else {
    this.water_temperature = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pressure = null;
    } else {
    this.pressure = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.air_temperature = null;
    } else {
    this.air_temperature = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.__timestamp) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, __timestamp);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.longitude, __dataOut);
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.latitude, __dataOut);
    }
    if (null == this.u_wind_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.u_wind_direction, __dataOut);
    }
    if (null == this.v_wind_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.v_wind_direction, __dataOut);
    }
    if (null == this.wind_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wind_direction, __dataOut);
    }
    if (null == this.wind_speed) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wind_speed, __dataOut);
    }
    if (null == this.wave_height) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wave_height, __dataOut);
    }
    if (null == this.wave_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wave_direction, __dataOut);
    }
    if (null == this.wave_period) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wave_period, __dataOut);
    }
    if (null == this.swell_height) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.swell_height, __dataOut);
    }
    if (null == this.swell_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.swell_direction, __dataOut);
    }
    if (null == this.swell_period) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.swell_period, __dataOut);
    }
    if (null == this.ice_cover) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.ice_cover, __dataOut);
    }
    if (null == this.u_stream_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.u_stream_direction, __dataOut);
    }
    if (null == this.v_stream_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.v_stream_direction, __dataOut);
    }
    if (null == this.stream_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.stream_direction, __dataOut);
    }
    if (null == this.stream_speed) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.stream_speed, __dataOut);
    }
    if (null == this.water_temperature) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.water_temperature, __dataOut);
    }
    if (null == this.pressure) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.pressure, __dataOut);
    }
    if (null == this.air_temperature) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.air_temperature, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.__timestamp) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, __timestamp);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.longitude, __dataOut);
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.latitude, __dataOut);
    }
    if (null == this.u_wind_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.u_wind_direction, __dataOut);
    }
    if (null == this.v_wind_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.v_wind_direction, __dataOut);
    }
    if (null == this.wind_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wind_direction, __dataOut);
    }
    if (null == this.wind_speed) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wind_speed, __dataOut);
    }
    if (null == this.wave_height) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wave_height, __dataOut);
    }
    if (null == this.wave_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wave_direction, __dataOut);
    }
    if (null == this.wave_period) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.wave_period, __dataOut);
    }
    if (null == this.swell_height) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.swell_height, __dataOut);
    }
    if (null == this.swell_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.swell_direction, __dataOut);
    }
    if (null == this.swell_period) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.swell_period, __dataOut);
    }
    if (null == this.ice_cover) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.ice_cover, __dataOut);
    }
    if (null == this.u_stream_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.u_stream_direction, __dataOut);
    }
    if (null == this.v_stream_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.v_stream_direction, __dataOut);
    }
    if (null == this.stream_direction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.stream_direction, __dataOut);
    }
    if (null == this.stream_speed) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.stream_speed, __dataOut);
    }
    if (null == this.water_temperature) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.water_temperature, __dataOut);
    }
    if (null == this.pressure) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.pressure, __dataOut);
    }
    if (null == this.air_temperature) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.air_temperature, __dataOut);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(__timestamp==null?"null":__timestamp, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(u_wind_direction==null?"null":u_wind_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v_wind_direction==null?"null":v_wind_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_direction==null?"null":wind_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_speed==null?"null":wind_speed.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wave_height==null?"null":wave_height.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wave_direction==null?"null":wave_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wave_period==null?"null":wave_period.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(swell_height==null?"null":swell_height.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(swell_direction==null?"null":swell_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(swell_period==null?"null":swell_period.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ice_cover==null?"null":ice_cover.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(u_stream_direction==null?"null":u_stream_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v_stream_direction==null?"null":v_stream_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(stream_direction==null?"null":stream_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(stream_speed==null?"null":stream_speed.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(water_temperature==null?"null":water_temperature.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pressure==null?"null":pressure.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_temperature==null?"null":air_temperature.toPlainString(), delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(__timestamp==null?"null":__timestamp, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(u_wind_direction==null?"null":u_wind_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v_wind_direction==null?"null":v_wind_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_direction==null?"null":wind_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind_speed==null?"null":wind_speed.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wave_height==null?"null":wave_height.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wave_direction==null?"null":wave_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wave_period==null?"null":wave_period.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(swell_height==null?"null":swell_height.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(swell_direction==null?"null":swell_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(swell_period==null?"null":swell_period.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ice_cover==null?"null":ice_cover.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(u_stream_direction==null?"null":u_stream_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v_stream_direction==null?"null":v_stream_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(stream_direction==null?"null":stream_direction.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(stream_speed==null?"null":stream_speed.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(water_temperature==null?"null":water_temperature.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pressure==null?"null":pressure.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(air_temperature==null?"null":air_temperature.toPlainString(), delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.__timestamp = null; } else {
      this.__timestamp = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.longitude = null; } else {
      this.longitude = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.latitude = null; } else {
      this.latitude = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.u_wind_direction = null; } else {
      this.u_wind_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.v_wind_direction = null; } else {
      this.v_wind_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_direction = null; } else {
      this.wind_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_speed = null; } else {
      this.wind_speed = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wave_height = null; } else {
      this.wave_height = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wave_direction = null; } else {
      this.wave_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wave_period = null; } else {
      this.wave_period = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.swell_height = null; } else {
      this.swell_height = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.swell_direction = null; } else {
      this.swell_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.swell_period = null; } else {
      this.swell_period = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ice_cover = null; } else {
      this.ice_cover = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.u_stream_direction = null; } else {
      this.u_stream_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.v_stream_direction = null; } else {
      this.v_stream_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.stream_direction = null; } else {
      this.stream_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.stream_speed = null; } else {
      this.stream_speed = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.water_temperature = null; } else {
      this.water_temperature = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pressure = null; } else {
      this.pressure = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_temperature = null; } else {
      this.air_temperature = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.__timestamp = null; } else {
      this.__timestamp = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.longitude = null; } else {
      this.longitude = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.latitude = null; } else {
      this.latitude = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.u_wind_direction = null; } else {
      this.u_wind_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.v_wind_direction = null; } else {
      this.v_wind_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_direction = null; } else {
      this.wind_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wind_speed = null; } else {
      this.wind_speed = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wave_height = null; } else {
      this.wave_height = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wave_direction = null; } else {
      this.wave_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wave_period = null; } else {
      this.wave_period = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.swell_height = null; } else {
      this.swell_height = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.swell_direction = null; } else {
      this.swell_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.swell_period = null; } else {
      this.swell_period = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ice_cover = null; } else {
      this.ice_cover = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.u_stream_direction = null; } else {
      this.u_stream_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.v_stream_direction = null; } else {
      this.v_stream_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.stream_direction = null; } else {
      this.stream_direction = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.stream_speed = null; } else {
      this.stream_speed = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.water_temperature = null; } else {
      this.water_temperature = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pressure = null; } else {
      this.pressure = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.air_temperature = null; } else {
      this.air_temperature = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    weather_info_temp o = (weather_info_temp) super.clone();
    return o;
  }

  public void clone0(weather_info_temp o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("_timestamp", this.__timestamp);
    __sqoop$field_map.put("longitude", this.longitude);
    __sqoop$field_map.put("latitude", this.latitude);
    __sqoop$field_map.put("u_wind_direction", this.u_wind_direction);
    __sqoop$field_map.put("v_wind_direction", this.v_wind_direction);
    __sqoop$field_map.put("wind_direction", this.wind_direction);
    __sqoop$field_map.put("wind_speed", this.wind_speed);
    __sqoop$field_map.put("wave_height", this.wave_height);
    __sqoop$field_map.put("wave_direction", this.wave_direction);
    __sqoop$field_map.put("wave_period", this.wave_period);
    __sqoop$field_map.put("swell_height", this.swell_height);
    __sqoop$field_map.put("swell_direction", this.swell_direction);
    __sqoop$field_map.put("swell_period", this.swell_period);
    __sqoop$field_map.put("ice_cover", this.ice_cover);
    __sqoop$field_map.put("u_stream_direction", this.u_stream_direction);
    __sqoop$field_map.put("v_stream_direction", this.v_stream_direction);
    __sqoop$field_map.put("stream_direction", this.stream_direction);
    __sqoop$field_map.put("stream_speed", this.stream_speed);
    __sqoop$field_map.put("water_temperature", this.water_temperature);
    __sqoop$field_map.put("pressure", this.pressure);
    __sqoop$field_map.put("air_temperature", this.air_temperature);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("_timestamp", this.__timestamp);
    __sqoop$field_map.put("longitude", this.longitude);
    __sqoop$field_map.put("latitude", this.latitude);
    __sqoop$field_map.put("u_wind_direction", this.u_wind_direction);
    __sqoop$field_map.put("v_wind_direction", this.v_wind_direction);
    __sqoop$field_map.put("wind_direction", this.wind_direction);
    __sqoop$field_map.put("wind_speed", this.wind_speed);
    __sqoop$field_map.put("wave_height", this.wave_height);
    __sqoop$field_map.put("wave_direction", this.wave_direction);
    __sqoop$field_map.put("wave_period", this.wave_period);
    __sqoop$field_map.put("swell_height", this.swell_height);
    __sqoop$field_map.put("swell_direction", this.swell_direction);
    __sqoop$field_map.put("swell_period", this.swell_period);
    __sqoop$field_map.put("ice_cover", this.ice_cover);
    __sqoop$field_map.put("u_stream_direction", this.u_stream_direction);
    __sqoop$field_map.put("v_stream_direction", this.v_stream_direction);
    __sqoop$field_map.put("stream_direction", this.stream_direction);
    __sqoop$field_map.put("stream_speed", this.stream_speed);
    __sqoop$field_map.put("water_temperature", this.water_temperature);
    __sqoop$field_map.put("pressure", this.pressure);
    __sqoop$field_map.put("air_temperature", this.air_temperature);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
