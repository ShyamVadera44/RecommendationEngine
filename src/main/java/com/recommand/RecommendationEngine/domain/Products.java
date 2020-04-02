package com.recommand.RecommendationEngine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class Products {

    @JsonProperty(value="product_id")
    private String productId;

    @JsonProperty(value="product_name")
    private String productName;

    @JsonIgnore
    private int count;


    public Products(String productId, String productName, int count) {
        this.productId = productId;
        this.productName = productName;
        this.count = count;
    }

    // You can also use LOMBOK dependency for direct use of getter-setter without write that
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
