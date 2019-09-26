package cn.com.geovis.data_import.data_import.model.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file_info_copy")
public class FileInfo {

    @Id
    @SequenceGenerator(name = "FileInfo_Generator", sequenceName = "FileInfo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FileInfo_Generator")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "imagemeta_id")
    @JsonIgnore
    @JSONField(serialize = false)
    private ImageMeta imageMeta;

    @Column(name = "file_size")
    private long fileSize;

    @Column
    private String fileName;

    @Column
    @JsonIgnore
    private String relativePath;

    @Column
    private String fileType;

    @Column
    private String rootPath;

    @Column
    private Date productTime;

    @Column
    private Boolean isSoftLink;

    public FileInfo() {

    }

    public FileInfo(FileInfo fileInfo) {
        this.fileSize = fileInfo.getFileSize();
        this.fileName = fileInfo.getFileName();
        this.relativePath = fileInfo.getRelativePath();
        this.fileType = fileInfo.getFileType();
        this.rootPath = fileInfo.getRootPath();
        this.productTime = fileInfo.getProductTime();
        this.isSoftLink = fileInfo.getIsSoftLink();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageMeta getImageMeta() {
        return imageMeta;
    }

    public void setImageMeta(ImageMeta imageMeta) {
        this.imageMeta = imageMeta;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public Boolean getIsSoftLink() {
        return isSoftLink;
    }

    public void setIsSoftLink(Boolean isSoftLink) {
        this.isSoftLink = isSoftLink;
    }


}
