package com.example.EcommerceApp.service.implementation;

import com.example.EcommerceApp.entity.ProductCategory;
import com.example.EcommerceApp.repository.ProductCategoryRepo;
import com.example.EcommerceApp.service.ProductCategoryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepo productCategoryRepo;

    public ProductCategory addCategory(ProductCategory productCategory) {
        return productCategoryRepo.save(productCategory);
    }

    public ProductCategory updateCategory(ProductCategory category) {
        ProductCategory updatedCategory = productCategoryRepo.findById(category.getCategoryId()).get();
        updatedCategory.setCategoryName(category.getCategoryName());
        updatedCategory.setActive(category.isActive());
        return productCategoryRepo.save(category);
    }
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepo.findAll();
    }


    public void activateCategory(Long categoryId) {
        ProductCategory category = productCategoryRepo.findById(categoryId)
                .orElseThrow(NoSuchElementException::new);
        category.setActive(true);
        productCategoryRepo.save(category);
    }

//    public void deactivateCategory(Long categoryId) {
//        ProductCategory category = productCategoryRepo.findById(categoryId)
//                .orElseThrow(NoSuchElementException::new);
//        category.setActive(false);
//        productCategoryRepo.save(category);
//    }


}
