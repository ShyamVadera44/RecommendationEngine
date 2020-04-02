package com.recommand.RecommendationEngine.service;

import com.recommand.RecommendationEngine.domain.Products;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RecommandService {
    public List<Products> getProductList(String productId);
}
