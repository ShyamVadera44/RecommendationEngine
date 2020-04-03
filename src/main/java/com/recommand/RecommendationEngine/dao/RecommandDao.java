package com.recommand.RecommendationEngine.dao;

import com.recommand.RecommendationEngine.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface RecommandDao {

    public String recommandQuery="select top 5 product_id ,product_name,count(product_name ) as PRODUCT_COUNT from testdata where customer_ip in (select distinct customer_ip  from testdata where product_id =? )\n" +
            " and product_name not in(select distinct product_name  from testdata where product_id =?)group by product_name  order by count(product_name) desc;";
            //"SELECT TOP 5 DISTINCT PRODUCT_NAME ,COUNT (PRODUCT_NAME ) AS PRODUCT_COUNT FROM TESTDATA WHERE PRODUCT_ID =? GROUP BY PRODUCT_NAME  ORDER BY COUNT (PRODUCT_NAME ) DESC ;";

    public List<Products>getProductList(String productId) throws SQLException;

}
