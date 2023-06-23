package com.example.ecommerceapp.repository;

import com.example.ecommerceapp.entity.ProductCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class ProductCategoryRepoTest {
    @Autowired
    ProductCategoryRepo categoryRepo;
    @Test
    @DisplayName("List all categories is active")
    void givenListOfCategories_returnCategoriesActiveTrue() {
        //given
        ProductCategory category = new ProductCategory(1L,"Phones",true);
        ProductCategory category2 = new ProductCategory(2L,"Electronics",true);
        ProductCategory category3 = new ProductCategory(3L,"Vegetables",true);
        List<ProductCategory> expectedCategoriesList = categoryRepo.saveAll(List.of(category
                , category2, category3));
        //when
        List<ProductCategory> activeCategories = categoryRepo.findByActiveTrue();
        //then
        assertEquals(activeCategories,expectedCategoriesList);
        assertThat(activeCategories).isNotNull();
    }
}