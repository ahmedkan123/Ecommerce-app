package com.example.ecommerceapp.service;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.mapper.ProductMapper;
import com.example.ecommerceapp.model.ProductModel;
import com.example.ecommerceapp.repository.ProductRepo;
import com.example.ecommerceapp.service.implementation.ProductServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    @Mock
    ProductRepo productRepo;
    @Spy
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    @InjectMocks
    ProductServiceImpl productService;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void givenProductModelObject_whenSaveProduct_thenReturnProductObject() {
        //Arrange
        ProductModel productModel = new ProductModel(1L,"test product","test description", 120.0, true,null);
        Product product = productMapper.toEntity(productModel);
        //Mock
        when(productRepo.save(any(Product.class))).thenReturn(product);
        //Action
        ProductModel savedProductModel = productService.addProduct(productModel);
        //Assert
        assertEquals("test product", savedProductModel.getProductName());
        assertFalse(savedProductModel.getProductName().isEmpty());
        assertTrue(savedProductModel.isActive());
        verify(productRepo,times(1)).save(product);

    }
    @Test
    void givenProductModel_whenUpdateProduct_thenReturnProductUpdated() {
        //Arrange
        ProductModel productModel = new ProductModel(1L,"Updated Product","test description",10.0,true,null);
        Product product = productMapper.toEntity(productModel);
        //Mock
        when(productRepo.findById(product.getProductId())).thenReturn(Optional.of(product));
        when(productRepo.save(any(Product.class))).thenReturn(product);
        //Action
        ProductModel updatedProductModel = productService.updateProduct(productModel);
        //Assert
        assertNotNull(updatedProductModel);
        assertNotNull(updatedProductModel.getProductId()); // Add null check here
        assertEquals(productModel.getProductId(), updatedProductModel.getProductId());
        assertEquals(productModel.getProductName(), updatedProductModel.getProductName());
    }
    @Test
    void getProductById_WithValidID_thenReturnProductObject() {
        // Arrange
        long productId = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setProductId(productId);
        expectedProduct.setProductName("Test Product");
        //Given
        when(productRepo.findById(productId)).thenReturn(Optional.of(expectedProduct));
        //When
        Product actualProduct  = productService.getProductById(productId);
        //Then
        assertNotNull(actualProduct);
        assertEquals(expectedProduct.getProductId(), actualProduct.getProductId());
        assertEquals(expectedProduct.getProductName(), actualProduct.getProductName());

        // Verify method invocation
        verify(productRepo, times(1)).findById(productId);

    }
    @Test
    void givenProductsList_whenGetAllProducts_thenReturnProductsList() {
        //Given
        when(productRepo.findAll()).thenReturn(List.of(new Product(),new Product()));
        //When
        List<ProductModel> ProductModelList= productService.getAllProducts();
        //Then
        assertFalse(ProductModelList.isEmpty());
        verify(productRepo,times(1)).findAll();
    }
    @Test
    void givenProductActive_whenActivatedProduct_thenReturnProductActive() {
        long productId = 1L;
        Product product = new Product(productId,"test product","test description", 120.0, false,null);
        when(productRepo.findById(productId)).thenReturn(Optional.of(product));
        product.setActive(true);
        when(productRepo.save(product)).thenReturn(product);
        assertTrue(product.isActive());

    }
    @Test
    void givenProductNotActive_whenDeactivatedProduct_thenReturnProductNotActive() {
        long productId = 1L;
        Product product = new Product(productId,"test product","test description", 120.0, true,null);
        when(productRepo.findById(productId)).thenReturn(Optional.of(product));
        product.setActive(false);
        when(productRepo.save(product)).thenReturn(product);
        assertFalse(product.isActive());
    }
    @Test
    void findProductActiveTrue_ReturnsListOfActiveProducts() {
        //Arrange
        Product product1 = new Product();
        product1.setProductId(1L);
        product1.setProductName("Product 1");
        product1.setActive(true);

        Product product2 = new Product();
        product2.setProductId(2L);
        product2.setProductName("Product 2");
        product2.setActive(true);

        List<Product> expectedProducts = Arrays.asList(product1, product2);

        when(productRepo.findByActiveTrue()).thenReturn(expectedProducts);

        // Act
        List<Product> actualProducts = productService.findByActiveTrue();

        // Assert
        assertEquals(expectedProducts, actualProducts);
    }
    @Test
    void findProductsByCategoryId_thenReturnListsOfProducts() {
        //Arrange
        long categoryId = 1L;
        Product product1 = new Product(1L,"test product","test description", 120.0, true,null);
        Product product2 = new Product(2L,"test product","test description", 120.0, true,null);
        Product product3 = new Product(3L,"test product","test description", 120.0, true,null);
        List<Product> expectedProducts = Arrays.asList(product1, product2, product3);
        //Mock
        when(productRepo.findByProductCategoryId(categoryId)).thenReturn(expectedProducts);
        //Action
        List<Product> actualProducts = productService.findByProductCategoryId(categoryId);
        // Assert
        assertEquals(expectedProducts, actualProducts);

    }
    @Test
    void findProductsByCategoryIdAndPriceRange_thenReturnListsOfProducts() {
        //Arrange
        Long categoryId = 1L;
        Double minPrice = 100.0;
        Double maxPrice = 900.0;
        Product product1 = new Product(1L,"test product","test description", 120.0, true,null);
        Product product2 = new Product(2L,"test product","test description", 650.0, true,null);
        Product product3 = new Product(3L,"test product","test description", 800.0, true,null);
        List<Product> expectedProducts = Arrays.asList(product1, product2, product3);
        when(productRepo.findByProductCategoryAndPriceRange(categoryId,minPrice,maxPrice))
                .thenReturn(expectedProducts);
        //Action
        List<Product> actualProducts = productService.findByProductCategoryAndPriceRange(categoryId,minPrice,maxPrice);
        //Assert
        assertEquals(expectedProducts, actualProducts);
    }
}