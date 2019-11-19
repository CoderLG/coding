package lg.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * author: LG
 * date: 2019-09-04 20:36
 * desc:
 */
@Data
@EnableTransactionManagement
@Configuration
public class TransactionFig {
    @Value("${spring.datasource.url}")
    private static String url;
    @Value("${spring.datasource.username}")
    private static String user;
    @Value("${spring.datasource.password}")
    private static String password;

    @Bean
    public  HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(50);
        config.setMaxLifetime(5000);
        config.setIdleTimeout(4000);
        return new HikariDataSource(config);
    }


    public PlatformTransactionManager transactionManager(){
        //Spring 会对Configuration下面的方法特殊处理， dataSource是单例
        return new DataSourceTransactionManager(dataSource());
    }
}
