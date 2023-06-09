package com.example.ecommerceapp.service.implementation;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.exception.ProductNotFoundException;
import com.example.ecommerceapp.mapper.ProductMapper;
import com.example.ecommerceapp.model.ProductModel;
import com.example.ecommerceapp.repository.ProductRepo;
import com.example.ecommerceapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Override
    public ProductModel addProduct(ProductModel productModel) {
        Product product = productMapper.toEntity(productModel);
        product = productRepo.save(product);
        productModel = productMapper.toModel(product);
        return productModel;
    }

    @Override
    public ProductModel updateProduct(ProductModel productModel) {
        Product product = productMapper.toEntity(productModel);
        Optional<Product> updatedProduct = productRepo
                .findById(product.getProductId());
        if (updatedProduct.isPresent()) {
            product.setProductName(product.getProductName());
            product.setDescription(product.getDescription());
            product.setPrice(product.getPrice());
            product.setProductCategory(product.getProductCategory());
            product = productRepo.save(product);
            return productMapper.toModel(product);
        }
        return null;
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("product is not found"));
        return product;
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(productMapper::toModel)
                .collect(Collectors.toList());
    }
    @Override
    public void activateProduct(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(NoSuchElementException::new);
        product.setActive(true);
        productRepo.save(product);
    }
    @Override
    public void deactivateProduct(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(NoSuchElementException::new);
        product.setActive(false);
        productRepo.save(product);
    }
    @Override
    public List<Product> findByActiveTrue() {
        return productRepo.findByActiveTrue();
    }
    @Override
    public List<Product> findByProductCategoryId(Long categoryId) {
        return productRepo.findByProductCategoryId(categoryId);
    }
    @Override
    public List<Product> findByProductCategoryAndPriceRange(Long categoryId,
                                                            Double minPrice,
                                                            Double maxPrice) {
        return productRepo.findByProductCategoryAndPriceRange(categoryId
                , minPrice, maxPrice);
    }


}
