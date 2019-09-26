package cn.com.geovis.data_import.data_import.controller;

import cn.com.geovis.data_import.data_import.service.MigrateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageMetaController {
    @Autowired
    MigrateDataService migrateDataService;

    @RequestMapping("/a")
    public void test() {
        migrateDataService.migrateData();
    }


}
