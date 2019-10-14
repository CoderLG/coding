package lg.configurer;

import lg.domain.ConfCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: LG
 * date: 2019-08-18 18:17
 * desc:将bean 注入到Spring容器中，Bean返回什么注入什么
 *
 * @Configuration       与  @Bean组合
 * jdbc/cglib动态代理，调用该方法返回的都是同一个实例  @Beanf返回什么， 实例就是什么
 *
 * @EnableConfigurationProperties(CarProperties.class)
 * 使@ConfigurationProperties注解生效
 *
 *
 */
//@Component
@Configuration
@EnableConfigurationProperties(CarProperties.class)
public class CarConf {
    @Autowired
    private CarProperties carProperties;

    @Bean
    public ConfCar confCar(){
        /**
         * 后面用到更高效的连接池Hikari
         * 所以修改这里的代码
         */
        ConfCar confCar = new ConfCar();
        confCar.setAge(this.carProperties.getDriverName());
        confCar.setName(this.carProperties.getUrl());
        return confCar;
    }

    public void sayH(){
        System.out.println("H");
    }


}
