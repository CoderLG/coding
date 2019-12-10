package lg.controller;

import lg.rc.FileInfo;
import lg.service.LoadService;
import lg.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * author: LG
 * date: 2019-09-03 20:36
 * desc:
 */
@RestController
public class download {

    @GetMapping("downloadUrl")
    public String downloadFileByLayerName(int start ,int end ,String downloadUrl,String FilePath){
        FileUtils.streamWrite( start , end , downloadUrl, FilePath);
        return "OK";
    }
}
