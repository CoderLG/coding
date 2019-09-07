package lg.controller;

import lg.config.FilePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * author: LG
 * date: 2019-09-03 19:34
 * desc:
 */
@RestController
public class Upload {
    @Autowired
    private FilePath filePath;


    @PostMapping("shpUpload")
    public String upload(@RequestParam("file") MultipartFile shapeFile) throws IOException {
        String tempFilePath =filePath.getPath() + File.separator + new Date().getTime();
        if (!new File(tempFilePath).exists()) {
            new File(tempFilePath).mkdirs();
        }
        File zipfile = new File(tempFilePath + File.separator + shapeFile.getOriginalFilename());
        shapeFile.transferTo(zipfile);

        return "suss";
    }
}
