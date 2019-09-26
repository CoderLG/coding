package cn.com.geovis.data_import.data_import.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vividsolutions.jts.geom.Geometry;

import java.io.IOException;


/**
 * 为jackson定制的地理空间类型的自定义序列化工具
 *
 * @author DELL
 */
public class GeometrySerializer extends JsonSerializer<Geometry> {

    @Override
    public void serialize(Geometry geometry, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {

        String wkt = null;
        if (geometry != null) {
            wkt = geometry.toText();
            gen.writeString(wkt);
        }

    }

}

