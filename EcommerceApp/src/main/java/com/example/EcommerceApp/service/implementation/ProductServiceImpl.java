package com.example.EcommerceApp.service.implementation;

import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.repository.ProductRepo;
import com.example.EcommerceApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Product product) {
        Product updatedProduct = productRepo.findById(product.getProductId()).get();
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setProductCategory(product.getProductCategory());
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void activateProduct(Long productId) {
        Product product = productRepo.findById(productId).get();
        product.setActive(true);
        productRepo.save(product);
    }

    public void deactivateProduct(Long productId) {
        Product product = productRepo.findById(productId).get();
        product.setActive(false);
        productRepo.save(product);
    }

    public List<Product> findByProductCategoryId(Long categoryId) {
        return productRepo.findByProductCategoryId(categoryId);
    }

    public List<Product> findByProductCategoryAndPriceRange(Long categoryId,
                                                            Double minPrice,
                                                            Double maxPrice) {
        return productRepo.findByProductCategoryAndPriceRange(categoryId
                , minPrice, maxPrice);
    }


}
