package com.splunk.service;

import java.math.BigDecimal;
import java.util.List;

public interface DataService {
    List<Product> getProductList();

    List<String> getCategories();

    interface Product {
        List<String> getCategory();

        String getProductName();

        String getDescription();

        BigDecimal getPrice();

        String getImage();

        String getPriceWithCurrency();
    }
}
