package cn.com.geovis.data_import.data_import.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Package: cn.com.geovis.dm.po
 * @ClassName: BaseEntity
 * @Description: po的基类，用来自动插入时间和id；
 * @Author: 李昕哲
 * @CreateDate: 2019/7/17 11:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/7/17 11:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})

public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreatedDate
    private Date createTime = new Date();

    @LastModifiedDate
    private Date updateTime = new Date();
}
