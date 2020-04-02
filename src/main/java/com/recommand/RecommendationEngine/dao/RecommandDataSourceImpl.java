package com.recommand.RecommendationEngine.dao;

import com.sun.org.apache.regexp.internal.recompile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class RecommandDataSourceImpl implements RecommandDatasource {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(DataSource.class);
    private DriverManagerDataSource dataSource = null;

    @Override
    public DataSource getDataSource() {
        Environment environment=context.getEnvironment();
        dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Override
    public Connection getConnection() {

        Connection connection= null;
        try {
            connection =getDataSource().getConnection();
            connection.setAutoCommit(false);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return connection;
    }

    public void processClose(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                //Hikari needs it to know, DB connection not closed
                connection.close();
            }
        } catch (Exception e) {
            //ignore as connection may have closed already
            log.info("ignored error closing connections");
        }
    }
}
