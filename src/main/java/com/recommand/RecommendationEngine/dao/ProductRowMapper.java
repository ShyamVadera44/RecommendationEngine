package com.recommand.RecommendationEngine.dao;

import com.recommand.RecommendationEngine.domain.Products;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProductRowMapper {

    public static List<Products>productRows(List<Map<String, Object>> rows,String productId) throws SQLException{
        List<Products>productsList=new ArrayList<Products>();
        for (Map row : rows) {
                Products products = new Products((String) row.get("PRODUCT_ID"),(String) row.get("PRODUCT_NAME"),(Math.toIntExact((Long) row.get("PRODUCT_COUNT"))));
                productsList.add(products);
        }
        return productsList;
    }
}
