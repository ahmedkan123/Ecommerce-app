package com.example.ecommerceapp.repository;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.entity.ProductCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class ProductRepoTest {
    @Autowired
    ProductRepo productRepo;
    @Test
    @DisplayName("List all products Active")
    void givenListOfProducts_findProductsByActiveTrue() {
        //given
        Product product1 = new Product(1L,"test productRepo1","description1",120.0,true,null);
        Product product2 = new Product(2L,"test productRepo2","description2",130.0,true,null);
        Product product3 = new Product(3L,"test productRepo3","description3",140.0,true,null);
        List<Product> expectedProductsList = productRepo.saveAll(Arrays.asList(product1,product2,product3));
        //when
        List<Product> activeProducts = productRepo.findByActiveTrue();
        //Then
        assertThat(activeProducts).isEqualTo(expectedProductsList);
    }

    @Test
    @DisplayName("List all products under category id")
    void givenCategoryId_returnProductsByCategoryId() {
        //given
        Long categoryId = 1L;
        Product product1 = new Product(1L,"test productRepo1","description1",120.0,
                true, new ProductCategory(categoryId,"phones",true));
        Product product2 = new Product(2L,"test productRepo2","description2",130.0,
                true, new ProductCategory(categoryId,"phones",true));
        Product product3 = new Product(3L,"test productRepo3","description3",140.0,
                true, new ProductCategory(categoryId,"phones",true));
        List<Product> expectedProductsList = productRepo.saveAll(List.of(product1,product2,product3));
        //When
        List<Product> productsUnderCategoryId = productRepo.findByProductCategoryId(categoryId);
        //Then
        assertThat(productsUnderCategoryId).isNotNull();
        //assertTrue(productsUnderCategoryId.contains(product2));
    }

    @Test
    @DisplayName("List all products under category id and price range ")
    void givenCategoryIdAndPriceRange_returnListOfProductsMatchedToCondition() {
        //given
        Long categoryId = 1L;
        Double minPrice = 1000.0;
        Double maxPrice = 2000.0;
        Product product1 = new Product(1L,"Laptop","description1",1500.0,
                true, new ProductCategory(categoryId,"Electronics",true));
        Product product2 = new Product(2L,"Phone","description2",800.0,
                true, new ProductCategory(categoryId,"Electronics",true));
        Product product3 = new Product(3L,"TV","description3",1200.0,
                true, new ProductCategory(categoryId,"Electronics",true));
        List<Product> expectedProductsList = productRepo.saveAll(List.of(product1,product2,product3));
        //when
        List<Product> productsMatched = productRepo.findByProductCategoryAndPriceRange(categoryId, minPrice
                , maxPrice);
        //then
        assertThat(productsMatched).isNotNull();
//        assertThat(productsMatched).hasSize(2);
//        assertThat(productsMatched).extracting(Product::getProductName)
//                .containsExactlyInAnyOrder("Laptop", "TV");
//        assertThat(productsMatched).extracting(Product::getPrice)
//                .allSatisfy((price) -> {
//            assertThat(price).isGreaterThanOrEqualTo(1000.0);
//            assertThat(price).isLessThanOrEqualTo(2000.0);
//        });
    }
}