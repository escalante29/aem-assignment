package com.splunk.service.impl;

import com.splunk.service.DataService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Model(adaptables = SlingHttpServletRequest.class)
public class CategoryListModel {

    @Inject
    private DataService dataService;

    @SlingObject
    private SlingHttpServletRequest request;

    public List<String> getCategories() {
        // Fetch all products
        List<DataService.Product> products = dataService.getProductList();

        // Extract unique categories from products
        return products.stream()
                .flatMap(product -> product.getCategory().stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
