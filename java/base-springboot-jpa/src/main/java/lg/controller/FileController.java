package lg.controller;

import lg.dvo.FileInfoVo;
import lg.service.impl.LoadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * author: LG
 * date: 2019-09-03 20:36
 * desc:
 */
@RestController
public class FileController {

    @Autowired
    private LoadServiceImpl loadService;

    @GetMapping("downloadFile")
    public ResponseEntity<InputStreamResource> downloadFileByLayerName(){       //原来返回值byte[]
        System.out.println("--------开始下载----------");
        FileInfoVo fileInfo = null;
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


    @PostMapping("shpUpload")
    public String upload(@RequestParam("file") MultipartFile shapeFile) throws IOException {
        String tempFilePath ="F:\\Burning\\Coding\\A_SpringBoot\\File\\upload" + File.separator + new Date().getTime();
        if (!new File(tempFilePath).exists()) {
            new File(tempFilePath).mkdirs();
        }
        File zipfile = new File(tempFilePath + File.separator + shapeFile.getOriginalFilename());
        shapeFile.transferTo(zipfile);

        return "suss";
    }
}
