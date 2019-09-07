package lg.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author: LG
 * date: 2019-09-04 11:05
 * desc:
 */
@Data
@Component
public class BaseConf {
    @Value("${spring.application.name}")
    private String name;
}
