package io.github.prittspadelord.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * WIP
 */
@Configuration
@ComponentScan(basePackages = "io.github.prittspadelord.dao.impl")
public class DataSourceConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Bean
    public DataSource dataSource() {

        Properties props = new Properties();

        try {
            props.load(this.getClass().getResourceAsStream("/jdbc.properties"));
            final String driverClassName = props.getProperty("driverClassName");
            final String dbUrl = props.getProperty("dbUrl");
            final String username = props.getProperty("username");
            final String password = props.getProperty("password");

            HikariConfig config = new HikariConfig();
            config.setDriverClassName(driverClassName);
            config.setJdbcUrl(dbUrl);
            config.setUsername(username);
            config.setPassword(password);

            config.setMinimumIdle(1);
            config.setMaximumPoolSize(5);

            return new HikariDataSource(config);
        }
        catch(IOException e) {
            String errorMessage = "Error occurred while reading resource as stream";
            LOGGER.error(errorMessage, e);
            throw new IllegalStateException(errorMessage, e);
        }
    }
}