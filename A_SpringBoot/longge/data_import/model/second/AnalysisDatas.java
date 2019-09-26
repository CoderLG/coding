package cn.com.geovis.data_import.data_import.model.second;

import cn.com.geovis.data_import.data_import.config.JsonbType;
import com.vividsolutions.jts.geom.Geometry;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;


@Entity
@Table(name = "analysis_datas")
@TypeDef(name = "JsonbType", typeClass = JsonbType.class)
public class AnalysisDatas implements Serializable {
    @Id
    @SequenceGenerator(name = "AnalysisDatas_Generator", sequenceName = "analysis_datas_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AnalysisDatas_Generator")
    private long id;
    @Column
    private Integer batchNumber;
    @Column
    private String fileMD5;
    @Column
    private String fileName;
    @Column
    private String fileSize;


    @Column
    @Type(type = "JsonbType")
    private String info;
    @Column
    private String typeName;
    @Column
    private Geometry geom;


    public AnalysisDatas() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getFileMD5() {
        return fileMD5;
    }

    public void setFileMD5(String fileMD5) {
        this.fileMD5 = fileMD5;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }
}
