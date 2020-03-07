package cn.com.geovis;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * author: LG
 * date: 2019-09-02 18:39
 * desc:
 */


@EnableSwagger2Doc
@SpringBootApplication
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }
}
