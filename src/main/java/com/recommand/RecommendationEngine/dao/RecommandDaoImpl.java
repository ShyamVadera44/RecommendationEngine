package com.recommand.RecommendationEngine.dao;

import com.recommand.RecommendationEngine.domain.Products;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class RecommandDaoImpl implements RecommandDao{

    private static final Logger log = LoggerFactory.getLogger(DataSource.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Products> getProductList(String productId) throws SQLException {

        try {
            List<Map<String, Object>> rows=jdbcTemplate.queryForList(recommandQuery,productId,productId);
            System.out.println(rows.size());
            return ProductRowMapper.productRows(rows,productId);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
}
