package com.recommand.RecommendationEngine.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.sql.*;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private RecommandDatasource recommandDatasource;

    private static final Logger log = LoggerFactory.getLogger(DataSource.class);
    @Override
    public void run(String...args) throws Exception {

        boolean succes = false;
        Connection connection = null;
        Statement statement=null;

        try {
            connection = recommandDatasource.getConnection();
            statement=connection.createStatement();
            statement.execute("drop table if exists testdata");
            statement.execute("CREATE TABLE TESTDATA AS SELECT * FROM CSVREAD('classpath:/csvdata.csv')");
            succes=true;
        } catch (Exception e) { //something bad
            connection.rollback();
            log.error("DB insert unsuccessful ", e.getMessage());
        } finally {
           if(!succes){
               recommandDatasource.processClose(connection,statement);
           }
        }

    }
}
