package cn.com.geovis.data_import.data_import.config;

import org.hibernate.spatial.dialect.postgis.PostgisPG95Dialect;

import java.sql.Types;

public class JsonbPostgresDialect extends PostgisPG95Dialect {

    public JsonbPostgresDialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
