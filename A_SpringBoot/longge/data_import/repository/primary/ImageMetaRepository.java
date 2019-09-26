package cn.com.geovis.data_import.data_import.repository.primary;


import cn.com.geovis.data_import.data_import.model.po.ImageMeta;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.awt.*;
import java.util.List;


@Repository
public interface ImageMetaRepository extends CrudRepository<ImageMeta, Long> {
    Slice<ImageMeta> findByBandCountIsNull(Pageable pageable);

}
