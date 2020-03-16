package lg.domain;


import lombok.Data;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

@Data
@Document(indexName = "provinceid",type = "City", shards = 1,replicas = 0, refreshInterval = "-1")
public class Province {
    @Id
    private String gid;
    private String code;
    private String name;
    private String parent;
    private String cityproces;      //全0字段，推测无用
    private String countyproc;      //全0字段，推测无用
    private String shape_area;
    private String shape_len;
    private String geom;
    private String geomStr;
    @GeoPointField
    private GeoPoint geomGeoPoint;  //对应原数据库字段
//
//    public Province(ProvinceCityCountyNewReq req) {
//        this.gid = req.getGid();
//        this.code = req.getCode();
//        this.name = req.getName();
//        this.parent = null;
//        this.cityproces = "0";
//        this.countyproc = "0";
//        this.shape_area = req.getShape_area();
//        this.shape_len = req.getShape_len();
//        this.geom = req.getGeom();
//        this.geomStr = req.getGeomStr();
////        this.geomGeoPoint = new GeoPoint();
////        this.geomGeoPoint.reset(req.getLat(),req.getLon());
//    }
}