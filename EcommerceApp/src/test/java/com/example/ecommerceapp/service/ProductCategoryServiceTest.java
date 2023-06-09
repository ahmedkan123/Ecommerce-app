package com.example.ecommerceapp.service;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.entity.ProductCategory;
import com.example.ecommerceapp.repository.ProductCategoryRepo;
import com.example.ecommerceapp.service.implementation.ProductCategoryServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
class ProductCategoryServiceTest {
    @Mock
    private ProductCategoryRepo categoryRepository;
    @InjectMocks
    private ProductCategoryServiceImpl categoryService;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void addCategoryObject_thenReturnCategoryObject() {
        // Arrange
        ProductCategory category = new ProductCategory();
        category.setCategoryId(1L);
        category.setCategoryName("Test Category");
        category.setActive(true);

        when(categoryRepository.save(any(ProductCategory.class))).thenReturn(category);

        // Act
        ProductCategory result = categoryService.addCategory(category);

        // Assert
        assertEquals(category, result);
        verify(categoryRepository).save(category);
    }
    @Test
    void updateCategoryObject_thenReturnUpdatedCategoryObject() {
        // Arrange
        long categoryId = 1L;
        ProductCategory existingCategory = new ProductCategory(categoryId, "Existing Category", false);
        ProductCategory updatedCategory = new ProductCategory(categoryId, "Updated Category", false);

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.save(updatedCategory)).thenReturn(updatedCategory);

        // Act
        ProductCategory result = categoryService.updateCategory(updatedCategory);

        // Assert
        assertEquals(updatedCategory, result);
        verify(categoryRepository, times(1)).findById(categoryId);
        verify(categoryRepository, times(1)).save(updatedCategory);
    }
    @Test
    void activateCategoryObject_thenReturnCategoryObjectActive() {
        // Arrange
        long categoryId = 1L;
        ProductCategory category = new ProductCategory(categoryId, "Test Category", false);
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));

        // Act
        categoryService.activateCategory(categoryId);

        // Assert
        assertTrue(category.isActive());
        verify(categoryRepository, times(1)).findById(categoryId);
        verify(categoryRepository, times(1)).save(category);
    }
    @Test
    void getAllCategoriesObjects_thenReturnListOfCategoriesObjects() {
        // Arrange
        ProductCategory category1 = new ProductCategory(1L, "Category 1", true);
        ProductCategory category2 = new ProductCategory(2L, "Category 2", true);
        List<ProductCategory> expectedCategories = Arrays.asList(category1, category2);

        when(categoryRepository.findAll()).thenReturn(expectedCategories);

        // Act
        List<ProductCategory> result = categoryService.getAllCategories();

        // Assert
        assertEquals(expectedCategories, result);
        verify(categoryRepository, times(1)).findAll();
    }
    @Test
    void findCategoryObjectActiveTrue_thenReturnListOfCategoriesObjectsActives() {
        // Arrange
        ProductCategory category1 = new ProductCategory(1L, "Category 1", true);
        ProductCategory category2 = new ProductCategory(2L, "Category 2", true);
        List<ProductCategory> expectedCategories = Arrays.asList(category1, category2);

        when(categoryRepository.findByActiveTrue()).thenReturn(expectedCategories);

        // Act
        List<ProductCategory> result = categoryService.findByActiveTrue();

        // Assert
        assertEquals(expectedCategories, result);
        verify(categoryRepository, times(1)).findByActiveTrue();
    }
}