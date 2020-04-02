package com.recommand.RecommendationEngine.dao;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public interface RecommandDatasource {

    public DataSource getDataSource();

    public Connection getConnection();

    public void processClose(Connection connection, Statement statement);
}
