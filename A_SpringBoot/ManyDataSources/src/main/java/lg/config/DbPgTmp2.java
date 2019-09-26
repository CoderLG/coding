package lg.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author: LG
 * date: 2019-09-11 13:57
 * desc:
 */
@Component
@Data
@ConfigurationProperties(prefix="spring.datasource.test2")
public class DbPgTmp2 {
    private String driverName;
    private String url;
    private String username;
    private String password;

}
