package lg.controller;

import lg.rc.FileInfo;
import lg.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * author: LG
 * date: 2019-09-03 20:36
 * desc:
 */
@RestController
public class load {

    @Autowired
    private LoadService loadService;

    @GetMapping("downloadFile")
    public ResponseEntity<InputStreamResource> downloadFileByLayerName(){       //原来返回值byte[]
        System.out.println("--------开始下载----------");
        FileInfo fileInfo = null;
        try {
            fileInfo = loadService.queryTiltFilePathByLayerName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------开始返回----------");

        return ResponseEntity
                .ok()
                .headers(fileInfo.getHeaders())
                .contentLength(fileInfo.getLength())
                .contentType(MediaType.parseMediaType("application/json"))
                .body(fileInfo.getInputStreamResource());

    }
}
