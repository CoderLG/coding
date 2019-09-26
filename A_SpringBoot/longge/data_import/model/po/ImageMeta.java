package cn.com.geovis.data_import.data_import.model.po;


import cn.com.geovis.data_import.data_import.model.type.Gridset;
import cn.com.geovis.data_import.data_import.utils.GeometryDerializer;
import cn.com.geovis.data_import.data_import.utils.GeometrySerializer;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "image_meta")
public class ImageMeta implements Serializable {


    @Id
    @SequenceGenerator(name = "ImageMeta_Generator", sequenceName = "ImageMeta_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ImageMeta_Generator")
    private Long id;

    /**
     * 数据级别
     */
    @Column(length = 5)
    private String level;

    /**
     * 左上纬度
     */
    @Column
    private Double upleftLat;

    /**
     * 左上经度
     */
    @Column
    private Double upleftLon;

    /**
     * 左下纬度-
     */
    @Column
    private Double lowleftLat;

    /**
     * 左下经度
     */
    @Column
    private Double lowleftLon;

    /**
     * 右上纬度-
     */
    @Column
    private Double uprightLat;

    /**
     * 右上经度
     */
    @Column
    private Double uprightLon;

    /**
     * 右下纬度
     */
    @Column
    private Double lowrightLat;

    /**
     * 右下经度
     */
    @Column
    private Double lowrightLon;

    /**
     * 左上纬度
     */
    @Column
    private Double upleftLatPre;

    /**
     * 左上经度
     */
    @Column
    private Double upleftLonPre;

    /**
     * 左下纬度-
     */
    @Column
    private Double lowleftLatPre;

    /**
     * 左下经度
     */
    @Column
    private Double lowleftLonPre;

    /**
     * 右上纬度-
     */
    @Column
    private Double uprightLatPre;

    /**
     * 右上经度
     */
    @Column
    private Double uprightLonPre;

    /**
     * 右下纬度
     */
    @Column
    private Double lowrightLatPre;

    /**
     * 右下经度
     */
    @Column
    private Double lowrightLonPre;

    /**
     * 影像名称
     */
    @Column(length = 100)
    private String imageName;

    /**  */
    @Column(length = 50)
    private String region;

    /**
     * 传感器信息
     */
    @Column(length = 15)
    private String sensorId;

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

    /**
     * 分辨率
     */
    @Column
    private Double resolution;

    /**
     * 卫星标识
     */
    @Column(length = 15)
    private String satelliteId;

    /**
     * 数据类型
     */
    @Column(length = 8)
    @NotEmpty
    private String dataType;

    /**
     * 文件名称
     */
    @Column(length = 100)
    private String fileName;

    @Column(length = 10)
    @NotEmpty

    private String userId;

    @OneToOne(targetEntity = FileInfo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "thumb_file_id")
    @Transient
    private FileInfo thumbnail;

    @OneToOne(targetEntity = FileInfo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "icon_file_id")
    @Transient
    private FileInfo icon;

    @Column
    private Integer bandCount;

    @Column
    private Integer rasterXSize;

    @Column
    private Integer rasterYSize;

    @Column(name = "geo")
    @JsonSerialize(using = GeometrySerializer.class)//用于数据转换转换成规定的格式
    @JsonDeserialize(using = GeometryDerializer.class)
    @JSONField(serialize = false)
    private Geometry geo_tmp;

    @Transient
    private String geo;

    @Column(name = "valid_area")
    @JsonSerialize(using = GeometrySerializer.class)//用于数据转换转换成规定的格式
    @JsonDeserialize(using = GeometryDerializer.class)

    @JSONField(serialize = false)
    private Geometry validArea_tmp;

    @Transient
    private String validArea;

    @Column
    private Gridset gridset;

    @Column(length = 100)
    private String description;

    @Column(length = 20)
    private String keyword;

    @Column
    private Timestamp uploadTime;

    @Column
    private Double cloudPercent;
    @Transient
    @OneToMany(mappedBy = "imageMeta", targetEntity = FileInfo.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<FileInfo> fileInfos;

    @Column(length = 10)
    private String dataId;


    public ImageMeta() {
    }

    public ImageMeta(String level, Double upleftLat, Double upleftLon, Double lowleftLat, Double lowleftLon, Double uprightLat, Double uprightLon, Double lowrightLat, Double lowrightLon, Double upleftLatPre, Double upleftLonPre, Double lowleftLatPre, Double lowleftLonPre, Double uprightLatPre, Double uprightLonPre, Double lowrightLatPre, Double lowrightLonPre, String imageName, String region, String sensorId, Timestamp startTime, Timestamp endTime, String format, Double resolution, String satelliteId, @NotEmpty String dataType, String fileName, @NotEmpty String userId, FileInfo thumbnail, FileInfo icon, Integer bandCount, Integer rasterXSize, Integer rasterYSize, Geometry geo_tmp, String geo, Geometry validArea_tmp, Gridset gridset, String description, String keyword, Timestamp uploadTime, Double cloudPercent, List<FileInfo> fileInfos, String dataId) {
        this.level = level;
        this.upleftLat = upleftLat;
        this.upleftLon = upleftLon;
        this.lowleftLat = lowleftLat;
        this.lowleftLon = lowleftLon;
        this.uprightLat = uprightLat;
        this.uprightLon = uprightLon;
        this.lowrightLat = lowrightLat;
        this.lowrightLon = lowrightLon;
        this.upleftLatPre = upleftLatPre;
        this.upleftLonPre = upleftLonPre;
        this.lowleftLatPre = lowleftLatPre;
        this.lowleftLonPre = lowleftLonPre;
        this.uprightLatPre = uprightLatPre;
        this.uprightLonPre = uprightLonPre;
        this.lowrightLatPre = lowrightLatPre;
        this.lowrightLonPre = lowrightLonPre;
        this.imageName = imageName;
        this.region = region;
        this.sensorId = sensorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.format = format;
        this.resolution = resolution;
        this.satelliteId = satelliteId;
        this.dataType = dataType;
        this.fileName = fileName;
        this.userId = userId;
        this.thumbnail = thumbnail;
        this.icon = icon;
        this.bandCount = bandCount;
        this.rasterXSize = rasterXSize;
        this.rasterYSize = rasterYSize;
        this.geo_tmp = geo_tmp;
        this.geo = geo;
        this.validArea_tmp = validArea_tmp;
        this.gridset = gridset;
        this.description = description;
        this.keyword = keyword;
        this.uploadTime = uploadTime;
        this.cloudPercent = cloudPercent;
        this.fileInfos = fileInfos;
        this.dataId = dataId;
    }

    public ImageMeta(ImageMeta imageMeta) {

        this.level = imageMeta.getLevel();
        this.upleftLat = imageMeta.getUpleftLat();
        this.upleftLon = imageMeta.getUpleftLon();
        this.lowleftLat = imageMeta.getLowleftLat();
        this.lowleftLon = imageMeta.getLowleftLon();
        this.uprightLat = imageMeta.getUprightLat();
        this.uprightLon = imageMeta.getUprightLon();
        this.lowrightLat = imageMeta.getLowrightLat();
        this.lowrightLon = imageMeta.getLowrightLon();
        this.upleftLatPre = imageMeta.getUpleftLatPre();
        this.upleftLonPre = imageMeta.getUpleftLonPre();
        this.lowleftLatPre = imageMeta.getLowleftLatPre();
        this.lowleftLonPre = imageMeta.getLowleftLonPre();
        this.uprightLatPre = imageMeta.getUprightLatPre();
        this.uprightLonPre = imageMeta.getUprightLonPre();
        this.lowrightLatPre = imageMeta.getLowrightLatPre();
        this.lowrightLonPre = imageMeta.getLowrightLonPre();
        this.imageName = imageMeta.getImageName();
        this.region = imageMeta.getRegion();
        this.sensorId = imageMeta.getSensorId();
        this.startTime = imageMeta.getStartTime();
        this.endTime = imageMeta.getEndTime();
        this.format = imageMeta.getFormat();
        this.resolution = imageMeta.getResolution();
        this.satelliteId = imageMeta.getSatelliteId();
        this.dataType = imageMeta.getDataType();
        this.fileName = imageMeta.getFileName();
        this.userId = imageMeta.getUserId();
        this.bandCount = imageMeta.getBandCount();
        this.rasterXSize = imageMeta.getRasterXSize();
        this.rasterYSize = imageMeta.getRasterYSize();

        this.description = imageMeta.getDescription();
        this.keyword = imageMeta.getKeyword();
        this.uploadTime = imageMeta.getUploadTime();
        this.cloudPercent = imageMeta.getCloudPercent();
        this.dataId = imageMeta.getDataId();
        this.gridset = imageMeta.getGridset();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Geometry getGeo_tmp() {
        return geo_tmp;
    }

    public void setGeo_tmp(Geometry geo_tmp) {
        this.geo_tmp = geo_tmp;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public Geometry getValidArea_tmp() {
        return validArea_tmp;
    }

    public void setValidArea_tmp(Geometry validArea_tmp) {
        this.validArea_tmp = validArea_tmp;
    }

    public Double getUpleftLat() {
        return this.upleftLat;
    }

    public void setUpleftLat(Double upleftLat) {
        this.upleftLat = upleftLat;
    }

    public Double getUpleftLon() {
        return this.upleftLon;
    }

    public void setUpleftLon(Double upleftLon) {
        this.upleftLon = upleftLon;
    }

    public Integer getBandCount() {
        return bandCount;
    }

    public void setBandCount(Integer bandCount) {
        this.bandCount = bandCount;
    }

    public Double getLowrightLat() {
        return lowrightLat;
    }

    public void setLowrightLat(Double lowrightLat) {
        this.lowrightLat = lowrightLat;
    }

    public Double getLowrightLon() {
        return this.lowrightLon;
    }

    public void setLowrightLon(Double lowrightLon) {
        this.lowrightLon = lowrightLon;
    }

    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getRasterXSize() {
        return rasterXSize;
    }

    public void setRasterXSize(Integer rasterXSize) {
        this.rasterXSize = rasterXSize;
    }

    public Integer getRasterYSize() {
        return rasterYSize;
    }

    public void setRasterYSize(Integer rasterYSize) {
        this.rasterYSize = rasterYSize;
    }

    public Gridset getGridset() {
        return gridset;
    }

    public void setGridset(Gridset gridset) {
        this.gridset = gridset;
    }

    public Timestamp getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Double getResolution() {
        return resolution;
    }

    public void setResolution(Double resolution) {
        this.resolution = resolution;
    }

    public String getSatelliteId() {
        return this.satelliteId;
    }

    public void setSatelliteId(String sateliteId) {
        this.satelliteId = sateliteId;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getLowleftLat() {
        return lowleftLat;
    }

    public void setLowleftLat(Double lowleftLat) {
        this.lowleftLat = lowleftLat;
    }

    public Double getLowleftLon() {
        return lowleftLon;
    }

    public void setLowleftLon(Double lowleftLon) {
        this.lowleftLon = lowleftLon;
    }

    public Double getUprightLat() {
        return uprightLat;
    }

    public void setUprightLat(Double uprightLat) {
        this.uprightLat = uprightLat;
    }

    public Double getUprightLon() {
        return uprightLon;
    }

    public void setUprightLon(Double uprightLon) {
        this.uprightLon = uprightLon;
    }


    public Double getUpleftLatPre() {
        return upleftLatPre;
    }

    public void setUpleftLatPre(Double upleftLatPre) {
        this.upleftLatPre = upleftLatPre;
    }

    public Double getUpleftLonPre() {
        return upleftLonPre;
    }

    public void setUpleftLonPre(Double upleftLonPre) {
        this.upleftLonPre = upleftLonPre;
    }

    public Double getLowleftLatPre() {
        return lowleftLatPre;
    }

    public void setLowleftLatPre(Double lowleftLatPre) {
        this.lowleftLatPre = lowleftLatPre;
    }

    public Double getLowleftLonPre() {
        return lowleftLonPre;
    }

    public void setLowleftLonPre(Double lowleftLonPre) {
        this.lowleftLonPre = lowleftLonPre;
    }

    public Double getUprightLatPre() {
        return uprightLatPre;
    }

    public void setUprightLatPre(Double uprightLatPre) {
        this.uprightLatPre = uprightLatPre;
    }

    public Double getUprightLonPre() {
        return uprightLonPre;
    }

    public void setUprightLonPre(Double uprightLonPre) {
        this.uprightLonPre = uprightLonPre;
    }

    public Double getLowrightLatPre() {
        return lowrightLatPre;
    }

    public void setLowrightLatPre(Double lowrightLatPre) {
        this.lowrightLatPre = lowrightLatPre;
    }

    public Double getLowrightLonPre() {
        return lowrightLonPre;
    }

    public void setLowrightLonPre(Double lowrightLonPre) {
        this.lowrightLonPre = lowrightLonPre;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getCloudPercent() {
        return cloudPercent;
    }

    public void setCloudPercent(Double cloudPercent) {
        this.cloudPercent = cloudPercent;
    }

    public List<FileInfo> getFileInfos() {
        return fileInfos;
    }

    public void setFileInfos(List<FileInfo> fileInfos) {
        this.fileInfos = fileInfos;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getValidArea() {
        return validArea;
    }

    public void setValidArea(String validArea) {
        this.validArea = validArea;
    }

    public FileInfo getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(FileInfo thumbnail) {
        this.thumbnail = thumbnail;
    }

    public FileInfo getIcon() {
        return icon;
    }

    public void setIcon(FileInfo icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":"
                + id
                + ",\"level\":\""
                + level + '\"'
                + ",\"upleftLat\":"
                + upleftLat
                + ",\"upleftLon\":"
                + upleftLon
                + ",\"lowleftLat\":"
                + lowleftLat
                + ",\"lowleftLon\":"
                + lowleftLon
                + ",\"uprightLat\":"
                + uprightLat
                + ",\"uprightLon\":"
                + uprightLon
                + ",\"lowrightLat\":"
                + lowrightLat
                + ",\"lowrightLon\":"
                + lowrightLon
                + ",\"upleftLatPre\":"
                + upleftLatPre
                + ",\"upleftLonPre\":"
                + upleftLonPre
                + ",\"lowleftLatPre\":"
                + lowleftLatPre
                + ",\"lowleftLonPre\":"
                + lowleftLonPre
                + ",\"uprightLatPre\":"
                + uprightLatPre
                + ",\"uprightLonPre\":"
                + uprightLonPre
                + ",\"lowrightLatPre\":"
                + lowrightLatPre
                + ",\"lowrightLonPre\":"
                + lowrightLonPre
                + ",\"imageName\":\""
                + imageName + '\"'
                + ",\"region\":\""
                + region + '\"'
                + ",\"sensorId\":\""
                + sensorId + '\"'
                + ",\"startTime\":\""
                + startTime + '\"'
                + ",\"endTime\":\""
                + endTime + '\"'
                + ",\"format\":\""
                + format + '\"'
                + ",\"resolution\":"
                + resolution
                + ",\"satelliteId\":\""
                + satelliteId + '\"'
                + ",\"dataType\":\""
                + dataType + '\"'
                + ",\"fileName\":\""
                + fileName + '\"'
                + ",\"userId\":\""
                + userId + '\"'
                + ",\"thumbnail\":"
                + thumbnail
                + ",\"icon\":"
                + icon
                + ",\"bandCount\":"
                + bandCount
                + ",\"rasterXSize\":"
                + rasterXSize
                + ",\"rasterYSize\":"
                + rasterYSize
                + ",\"geo\":"
                + geo
                + ",\"validArea\":"
                + validArea
                + ",\"gridset\":"
                + gridset
                + ",\"description\":\""
                + description + '\"'
                + ",\"keyword\":\""
                + keyword + '\"'
                + ",\"uploadTime\":\""
                + uploadTime + '\"'
                + ",\"cloudPercent\":"
                + cloudPercent
                + ",\"fileInfos\":"
                + fileInfos
                + ",\"dataId\":\""
                + dataId + '\"'
                + "}";

    }
}
