package com.splunk.service.impl;

import com.splunk.service.DataService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class)
public class ProductListModel {

    @Inject
    private DataService dataService;

    public List<DataService.Product> getProducts() {
        return dataService.getProductList();
    }
}
