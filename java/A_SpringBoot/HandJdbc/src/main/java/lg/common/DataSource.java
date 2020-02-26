package lg.common;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataSource {

	private static String url;

	private static String user;

	private static String password;


    private DataSource() {}

    @Value("${spring.datasource.url}")
	public void setUrl(String url) {
    	this.url = url;
	}
    @Value("${spring.datasource.username}")
	public void setUser(String username) {
    	this.user = username;
	}
    @Value("${spring.datasource.password}")
	public void setPassword(String password) {
    	this.password = password;
	}


	private static class SingletonHolder{

        private static HikariDataSource instance = getDataSource();

        private static HikariDataSource getDataSource() {
    		HikariConfig config = new HikariConfig();
    		config.setJdbcUrl(url);
    		config.setUsername(user);
    		config.setPassword(password);
    		config.setMaximumPoolSize(50);
    		config.setMaxLifetime(5000);
    		config.setIdleTimeout(4000);
//    		config.addDataSourceProperty("cachePrepStmts", "true");
//    		config.addDataSourceProperty("prepStmtCacheSize", "250");
//    		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    		return new HikariDataSource(config);
    	}
    }

    public static HikariDataSource getInstance(){
        return SingletonHolder.instance;
    }


}
