package ru.yakhin.coincollections.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.sql.DataSource;
@Configuration
@EnableWebMvc
@ComponentScan("ru.yakhin.coincollections")
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@EnableJpaRepositories("ru.yakhin.coincollections.repository")
public class MyConfig implements WebMvcConfigurer {

    private final Environment environment;

    @Autowired
    public MyConfig(Environment environment) {
        this.environment = environment;
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("database.driver"));
        dataSource.setUrl(environment.getProperty("database.url"));
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));

        return dataSource;
    }
}
