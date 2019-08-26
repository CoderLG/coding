package lg.configurer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * author: LG
 * date: 2019-08-18 18:11
 * desc:
 *
 *  @ConfigurationProperties(prefix = "jdbc")
 *  主要用来把properties配置文件转化为bean来使用的
 *  读取application.properties配置文件， 前缀是jdbc。必须生成get set方法
 *
 */


@Getter
@Setter
//@Component
@ConfigurationProperties(prefix = "jdbc")
public class CarProperties {
    private String driverName;
    private String url;
    private String userName;
    private String password;
}
