package com.recommand.RecommendationEngine.dao;

import com.recommand.RecommendationEngine.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface RecommandDao {

    public String recommandQuery="SELECT TOP 5 DISTINCT PRODUCT_NAME ,COUNT (PRODUCT_NAME ) AS PRODUCT_COUNT FROM TESTDATA WHERE PRODUCT_ID =? GROUP BY PRODUCT_NAME  ORDER BY COUNT (PRODUCT_NAME ) DESC ;";

    public List<Products>getProductList(String productId) throws SQLException;

}
