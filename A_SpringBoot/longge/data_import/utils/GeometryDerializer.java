package cn.com.geovis.data_import.data_import.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

import java.io.IOException;

public class GeometryDerializer extends JsonDeserializer<Geometry> {

    @Override
    public Geometry deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        String wkt = p.getText();
        System.out.println(wkt);
        Geometry geometry = null;
        try {
            if (wkt.startsWith("SRID")) {
                String[] strarray = wkt.split(";");
                int srid = Integer.parseInt(strarray[0].substring(5));
                wkt = strarray[1];
                geometry = new WKTReader().read(wkt);
                geometry.setSRID(srid);
            } else {
                geometry = new WKTReader().read(wkt);
                geometry.setSRID(4326);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return geometry;
    }

}
