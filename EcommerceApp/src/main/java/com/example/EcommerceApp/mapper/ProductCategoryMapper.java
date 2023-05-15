package com.example.EcommerceApp.mapper;

import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.entity.ProductCategory;
import com.example.EcommerceApp.model.ProductCategoryModel;
import com.example.EcommerceApp.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    ProductCategoryModel toModel(ProductCategory product);
    ProductCategory toEntity(ProductCategoryModel productCategoryModel);
}
