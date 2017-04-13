package demo;

import demo.dao.BookDao;
import demo.dao.BookDaoJpaImpl;
import demo.service.BookService;
import demo.service.BookServiceImpl;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Tom on 2017/4/8.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"demo.service"})
public class MainConfiguration {
    @Bean
    public BookDao bookDao() {
        BookDao bean = new BookDaoJpaImpl();
        return bean;
    }

    @Bean
    public BookService bookService() {
        BookService bean = new BookServiceImpl();
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());

        return factoryBean;
    }

    @Bean
    public DataSource dataSource() {
        //PooledDataSource
        PooledDataSource dataSrc = new PooledDataSource();

        dataSrc.setDriver("org.h2.Driver");
        dataSrc.setUrl("jdbc:h2:mem:test");
        dataSrc.setUsername("sa");
        dataSrc.setPassword("");
        dataSrc.setPoolMaximumActiveConnections(100);
        dataSrc.setPoolMaximumCheckoutTime(20000);
        dataSrc.setPoolMaximumIdleConnections(10);
        dataSrc.setPoolTimeToWait(20000);
        return dataSrc;
    }

    @Bean
    private JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter =
                new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        return jpaVendorAdapter;
    }

}
