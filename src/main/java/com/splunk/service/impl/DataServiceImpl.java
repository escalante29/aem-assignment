package com.splunk.service.impl;

import com.splunk.service.DataService;
import com.splunk.service.DataService.Product;

import org.osgi.service.component.annotations.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(service = DataService.class)
public class DataServiceImpl implements DataService {
    @Override
    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();

        productList.add(new ProductImpl(
                Arrays.asList("category1", "category2"),
                "Product 1",
                "Description of Product 1",
                new BigDecimal("10.99"),
                "content/dam/splunk/Product1.jpeg"));

        productList.add(new ProductImpl(
                Arrays.asList("category3", "category4"),
                "Product 2",
                "Description of Product 2",
                new BigDecimal("20.49"),
                "content/dam/splunk/Product2.jpeg"));

        // Add more products as needed

        return productList;
    }

    private static class ProductImpl implements Product {
        private List<String> category;
        private String productName;
        private String description;
        private BigDecimal price;
        private String image;

        public ProductImpl(List<String> category, String productName, String description, BigDecimal price,
                String image) {
            this.category = category;
            this.productName = productName;
            this.description = description;
            this.price = price;
            this.image = image;
        }

        @Override
        public List<String> getCategory() {
            return category;
        }

        @Override
        public String getProductName() {
            return productName;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public BigDecimal getPrice() {
            return price;
        }

        @Override
        public String getImage() {
            return image;
        }

        public String getPriceWithCurrency() {
            return "$" + price;
        }
    }
}
