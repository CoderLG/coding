package lg.service;

import lg.rc.FileInfo;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * author: LG
 * date: 2019-09-04 09:45
 * desc:
 */
@Service
public class LoadService {

    public FileInfo queryTiltFilePathByLayerName() throws IOException {
        FileInfo fileInfo = new FileInfo();
        String fullPath = "F:\\Burning\\Coding\\A_SpringBoot\\File\\upload\\1567513969887\\a.ttl";
        File file = new File(fullPath);
        if (file.exists()) {
            int bLength = 4096;
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            try(InputStream inputStream = fileSystemResource.getInputStream();
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();) {
                fileInfo.setLength(fileSystemResource.contentLength());
//                byte[] data = new byte[bLength];
//                int count = -1;
//                while((count = inputStream.read(data,0,bLength)) != -1){
//                    outStream.write(data, 0, count);
//                }
//                fileInfo.setBytes(outStream.toByteArray());
                fileInfo.setInputStreamResource(new InputStreamResource(fileSystemResource.getInputStream()));
                HttpHeaders headers = new HttpHeaders();
                headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                headers.add("Content-Disposition", String.format("attachment; filename=%s",
                        URLEncoder.encode(fileSystemResource.getFilename(), "UTF-8")));
                headers.add("Pragma", "no-cache");
                headers.add("Expires", "0");
                fileInfo.setHeaders(headers);
                return  fileInfo;
            } catch (IOException e) {

                throw new IOException();
            }
        }
        return  null;
    }

}
