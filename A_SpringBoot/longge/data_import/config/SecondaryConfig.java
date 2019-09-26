//package cn.com.geovis.data_import.data_import.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactorySecondary",
//        transactionManagerRef = "transactionManagerSecondary",
//        basePackages = {"cn.com.geovis.data_import.data_import.repository.second"}) //设置Repository所在位置
//public class SecondaryConfig {
//    @Autowired
//    private HibernateProperties hibernateProperties;
//    @Autowired
//    @Qualifier("secondaryDataSource")
//    private DataSource secondaryDataSource;
//
//    @Bean(name = "entityManagerSecondary")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name = "entityManagerFactorySecondary")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {
//        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
//
//        return builder
//                .dataSource(secondaryDataSource)
//                .properties(properties)
//                .packages("cn.com.geovis.data_import.data_import.model.second") //设置实体类所在位置
//                .persistenceUnit("secondaryPersistenceUnit")
//                .build();
//    }
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    private Map<String, String> getVendorProperties(DataSource dataSource) {
//        return jpaProperties.getProperties();
//    }
//
//    @Bean(name = "transactionManagerSecondary")
//    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
//    }
//
//}