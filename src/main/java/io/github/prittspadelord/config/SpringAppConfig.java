package io.github.prittspadelord.config;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
@Configuration
@ComponentScan(basePackages = "io.github.prittspadelord.dao.impl")
public class SpringAppConfig {

    @Bean
    public DataSource dataSource() {

        Properties props = new Properties();

        try {
            props.load(this.getClass().getResourceAsStream("/jdbc.properties"));
            final String driverClassName = props.getProperty("driverClassName");
            final String dbUrl = props.getProperty("dbUrl");
            final String username = props.getProperty("username");
            final String password = props.getProperty("password");

            BasicDataSource dataSource = new BasicDataSource();

            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(dbUrl);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            dataSource.setLogWriter(new PrintWriter(System.out));

            dataSource.setMinIdle(1);
            dataSource.setMaxTotal(5);

            return dataSource;
        }
        catch(IOException e) {
            String errorMessage = "Error occurred while reading resource as stream";
            log.error(errorMessage, e);
            throw new IllegalStateException(errorMessage, e);
        }
        catch(SQLException e) {
            String errorMessage = "Error occurred while setting log writer";
            log.error(errorMessage, e);
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