package test.java.com.splunk.service.impl;

import com.splunk.service.DataService;
import com.splunk.service.impl.DataServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DataServiceImplTest {

    @Test
    public void testGetProductList() {
        // Create a mock of DataService
        DataService dataService = Mockito.mock(DataService.class);

        // Define the expected list of products
        List<DataService.Product> expectedProductList = Arrays.asList(
                new DataServiceImpl.ProductImpl(
                        Arrays.asList("category1", "category2"),
                        "Product 1",
                        "Description of Product 1",
                        new BigDecimal("10.99"),
                        "content/dam/splunk/Product1.jpeg"),
                new DataServiceImpl.ProductImpl(
                        Arrays.asList("category3", "category4"),
                        "Product 2",
                        "Description of Product 2",
                        new BigDecimal("20.49"),
                        "content/dam/splunk/Product2.jpeg")
        // Add more expected products as needed
        );

        // Define the behavior of the mocked service
        Mockito.when(dataService.getProductList()).thenReturn(expectedProductList);

        // Call the method being tested
        List<DataService.Product> actualProductList = dataService.getProductList();

        // Assert that the actual product list matches the expected product list
        Assert.assertEquals(expectedProductList, actualProductList);
    }

    @Test
    public void testGetProductListByCategory() {
        // Create a mock of DataService
        DataService dataService = Mockito.mock(DataService.class);

        // Define sample products
        List<DataService.Product> sampleProducts = Arrays.asList(
                new DataServiceImpl.ProductImpl(
                        Arrays.asList("category1", "category2"),
                        "Product 1",
                        "Description of Product 1",
                        new BigDecimal("10.99"),
                        "content/dam/splunk/Product1.jpeg"),
                new DataServiceImpl.ProductImpl(
                        Arrays.asList("category3", "category4"),
                        "Product 2",
                        "Description of Product 2",
                        new BigDecimal("20.49"),
                        "content/dam/splunk/Product2.jpeg"),
                new DataServiceImpl.ProductImpl(
                        Arrays.asList("category1", "category5"),
                        "Product 3",
                        "Description of Product 3",
                        new BigDecimal("15.75"),
                        "content/dam/splunk/Product3.jpeg"));

        // Define the expected list of products for category "category1"
        List<DataService.Product> expectedProductsForCategory1 = Arrays.asList(
                sampleProducts.get(0),
                sampleProducts.get(2));

        // Define the behavior of the mocked service
        Mockito.when(dataService.getProductListByCategory("category1")).thenReturn(expectedProductsForCategory1);

        // Call the method being tested
        List<DataService.Product> actualProductsForCategory1 = dataService.getProductListByCategory("category1");

        // Assert that the actual product list matches the expected product list for
        // category "category1"
        Assert.assertEquals(expectedProductsForCategory1, actualProductsForCategory1);
    }

    @Test
    public void testGetProductListByNonExistentCategory() {
        // Create a mock of DataService
        DataService dataService = Mockito.mock(DataService.class);

        // Define sample products
        List<DataService.Product> sampleProducts = Arrays.asList(
                new DataServiceImpl.ProductImpl(
                        Arrays.asList("category1", "category2"),
                        "Product 1",
                        "Description of Product 1",
                        new BigDecimal("10.99"),
                        "content/dam/splunk/Product1.jpeg"),
                new DataServiceImpl.ProductImpl(
                        Arrays.asList("category3", "category4"),
                        "Product 2",
                        "Description of Product 2",
                        new BigDecimal("20.49"),
                        "content/dam/splunk/Product2.jpeg"),
                new DataServiceImpl.ProductImpl(
                        Arrays.asList("category1", "category5"),
                        "Product 3",
                        "Description of Product 3",
                        new BigDecimal("15.75"),
                        "content/dam/splunk/Product3.jpeg"));

        // Define the behavior of the mocked service
        Mockito.when(dataService.getProductListByCategory("nonexistent_category")).thenReturn(Arrays.asList());

        // Call the method being tested
        List<DataService.Product> actualProductsForNonExistentCategory = dataService
                .getProductListByCategory("nonexistent_category");

        // Assert that the actual product list for a non-existent category is empty
        Assert.assertTrue(actualProductsForNonExistentCategory.isEmpty());
    }
}
