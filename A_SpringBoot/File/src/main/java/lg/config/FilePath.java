package lg.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author: LG
 * date: 2019-09-03 20:24
 * desc:
 */
@Data
@Component
public class FilePath {
    @Value("${spring.application.file-dir}")
    private  String path;
}
