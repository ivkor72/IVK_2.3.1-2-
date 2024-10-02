package hiber.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.Properties;

public class appConfig {

    @Configuration
    @EnableAspectJAutoProxy
    @PropertySource("classpath:db.properties")
    @EnableTransactionManagement
    @ComponentScan(value = "hiber")
    public  class AppConfig {



        @Autowired
        private final Environment env;

        public AppConfig(Environment env) {
            this.env = env;
        }

//        @Bean
//        public DataSource dataSource() {
//            DriverManagerDataSource dataSource = new DriverManagerDataSource();
//            dataSource.setDriverClassName(env.getProperty("db.driver"));
//            dataSource.setUrl(env.getProperty("db.url"));
//            dataSource.setUsername(env.getProperty("db.username"));
//            dataSource.setPassword(env.getProperty("db.password"));
//            return dataSource;
//        }

        @Bean
        public DataSource dataSource() throws PropertyVetoException {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(env.getProperty("db.driver"));
            dataSource.setJdbcUrl(env.getProperty("db.url"));
            dataSource.setUser(env.getProperty("db.user"));
            dataSource.setPassword(env.getProperty("db.password"));
            return dataSource;

        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
            JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
            emf.setDataSource(dataSource());
            emf.setPackagesToScan("hiber");
            emf.setJpaVendorAdapter(vendorAdapter);
            return emf;
        }

        @Bean
        public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        }

        //============
//        @Bean
//        public DataSource getDataSource() {
//            DriverManagerDataSource dataSource = new DriverManagerDataSource();
//            dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("db.driver")));
//            dataSource.setUrl(env.getProperty("db.url"));
//            dataSource.setUsername(env.getProperty("db.username"));
//            dataSource.setPassword(env.getProperty("db.password"));
//            return dataSource;
//        }
//
//        @Bean
//        public LocalSessionFactoryBean getSessionFactory() {
//            LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//            factoryBean.setDataSource(getDataSource());
//
//            Properties props=new Properties();
//            props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//            props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//
//            factoryBean.setHibernateProperties(props);
//            factoryBean.setAnnotatedClasses(User.class);
//            return factoryBean;
//        }
//
//        @Bean
//        public HibernateTransactionManager getTransactionManager() {
//            HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//            transactionManager.setSessionFactory(getSessionFactory().getObject());
//            return transactionManager;
//        }
        //=====================
    }
}
