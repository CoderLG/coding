package cn.com.geovis.data_import.data_import.model.po;

import cn.com.geovis.data_import.data_import.config.JsonbType;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Map;

@Data
@Entity
@Table(name = "analysis_basic_datas")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
@org.hibernate.annotations.Table(appliesTo = "analysis_basic_datas")
@TypeDef(name = "JsonbType", typeClass = JsonbType.class)
public class AnalysisBasicDatas extends BaseEntity {

    @JSONField(serialize = false)
    private Geometry geo;
    @Column
    private Double resolution;//分辨率

    /**
     * 数据级别
     */
    @Column(length = 5)
    private String level;

    @Column
    private Double cloudPercent;//云量

    /**
     * 卫星标识
     */
    @Column(length = 15)
    private String satelliteId;

    /**
     * 传感器信息
     */
    @Column(length = 15)
    private String sensorId;

    /**
     * 数据类型
     */
    @Column
    private String typeEnName;

    @Column
    private Integer bandCount;//通道数

    /**
     * 起始时间
     */
    @Column
    private Timestamp startTime;

    /**
     * 终止时间
     */
    @Column
    private Timestamp endTime;

    /**
     * 影像格式
     */
    @Column(length = 10)
    private String format;

    @Column(length = 100)
    private String description;

    /**
     * 影像名称
     */
    @Column
    private String imageName;

    /**
     * 文件名称
     */
    @Column
    private String fileName;
    @Column
    private Long dataEntityId;

    @Column
    @Type(type = "JsonbType")
    String info;


}
