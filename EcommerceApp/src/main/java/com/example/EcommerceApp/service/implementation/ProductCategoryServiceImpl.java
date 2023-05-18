package com.example.EcommerceApp.service.implementation;

import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.entity.ProductCategory;
import com.example.EcommerceApp.repository.ProductCategoryRepo;
import com.example.EcommerceApp.service.ProductCategoryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepo productCategoryRepo;
    @Override
    public ProductCategory addCategory(ProductCategory productCategory) {
        return productCategoryRepo.save(productCategory);
    }
    @Override
    public ProductCategory updateCategory(ProductCategory category) {
        Optional<ProductCategory> updatedCategory = productCategoryRepo
                .findById(category.getCategoryId());
        if (updatedCategory.isPresent()) {
            category.setCategoryName(category.getCategoryName());
            category.setActive(category.isActive());
            return productCategoryRepo.save(category);
        }
        return null;
    }
    @Override
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepo.findAll();
    }

    @Override
    public List<ProductCategory> findByActiveTrue() {
        return productCategoryRepo.findByActiveTrue();
    }

    @Override
    public void activateCategory(Long categoryId) {
        ProductCategory category = productCategoryRepo.findById(categoryId)
                .orElseThrow(NoSuchElementException::new);
        category.setActive(true);
        productCategoryRepo.save(category);
    }

}
