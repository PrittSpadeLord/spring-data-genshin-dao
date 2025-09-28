package io.github.prittspadelord.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "io.github.prittspadelord.dao.impl")
public class DataSourceConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(DataSourceConfiguration.class);

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
            LOG.error(errorMessage, e);
            throw new IllegalStateException(errorMessage, e);
        }
    }

    @Bean
    public SQLExceptionTranslator sqlExceptionTranslator() {
        return new SQLErrorCodeSQLExceptionTranslator();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(
            @Autowired DataSource dataSource,
            @Autowired SQLExceptionTranslator sqlExceptionTranslator
    ) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setExceptionTranslator(sqlExceptionTranslator);
        return jdbcTemplate;
    }
}