package com.recommand.RecommendationEngine.controller;

import com.recommand.RecommendationEngine.domain.Products;
import com.recommand.RecommendationEngine.service.RecommandService;
import com.recommand.RecommendationEngine.service.RecommandServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class RecommandController {

    @Autowired
    RecommandServiceImpl recommandService;

    private static final Logger log = LoggerFactory.getLogger(DataSource.class);

    @GetMapping("/test/{productId}")
    @ResponseBody
    public ResponseEntity<Object> getrecomandList(@PathVariable String productId) {
        try {
            List<Products> recommandList=recommandService.getProductList(productId);
            if(recommandList.size()>5){
                return ResponseEntity.ok().body(recommandList.subList(0,4));
            }else {
                return ResponseEntity.ok().body(recommandList);
            }
        } catch (Exception ex) {
           log.error(ex.getMessage());
        }

        return null;

    }
}
