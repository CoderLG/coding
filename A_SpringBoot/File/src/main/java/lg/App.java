package lg;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: LG
 * date: 2019-09-03 19:31
 * desc:
 */
@SpringBootApplication
@EnableSwagger2Doc
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
