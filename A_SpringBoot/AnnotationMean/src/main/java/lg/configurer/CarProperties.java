package lg.configurer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * author: LG
 * date: 2019-08-18 18:11
 * desc:
 *
 *  @ConfigurationProperties(prefix = "jdbc")      与 @EnableConfigurationProperties(CarProperties.class) 组合
 *  主要用来把properties配置文件转化为bean来使用的
 *  读取application.properties配置文件， 前缀是jdbc。必须生成get set方法
 *
 *
 */

//@Configuration
//@Component
@ConfigurationProperties(prefix = "jdbc")
public class CarProperties {
    private String driverName;
    private String url;
    private String userName;
    private String password;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
