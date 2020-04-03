package com.recommand.RecommendationEngine.service;

import com.recommand.RecommendationEngine.dao.RecommandDao;
import com.recommand.RecommendationEngine.dao.RecommandDaoImpl;
import com.recommand.RecommendationEngine.domain.Products;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommandServiceImpl implements RecommandService {

    @Autowired
    RecommandDaoImpl recommandDao;

    private static final Logger log = LoggerFactory.getLogger(DataSource.class);

    @Override
    public List<Products> getProductList(String productId) {
        try {
            List<Products>productsList=recommandDao.getProductList(productId);
            /*HashMap<String,Integer> recommandMap=new HashMap<String, Integer>();
            HashMap<String,Integer> highRecommandMap=new HashMap<String, Integer>();
            List<Products>recommandList=new ArrayList<Products>();
            productsList.forEach(products -> {
                Arrays.asList(products.getProductName().split("\\+ ")).forEach(s -> {
                    if(recommandMap.containsKey(s)){
                        recommandMap.put(s,recommandMap.get(s)+products.getCount());
                    }else{
                        recommandMap.put(s,products.getCount());
                    }
                });
            });


            highRecommandMap = recommandMap
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                            Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                    LinkedHashMap::new));


            highRecommandMap.forEach((productName, count) -> {
                recommandList.add(new Products(productId,productName,count));
                log.info("ProductId: "+productId+"\tProductName: "+productName+"\tCount: "+count);
            });*/
            productsList.forEach(products -> {
                log.info("ProductId: "+products.getProductId()+"\tProductName: "+products.getProductName()+"\tCount: "+products.getCount());
            });
            return productsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
