package com.example.ecommerceapp.mapper;

import com.example.ecommerceapp.entity.ProductCategory;
import com.example.ecommerceapp.model.ProductCategoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    ProductCategoryModel toModel(ProductCategory product);
    ProductCategory toEntity(ProductCategoryModel productCategoryModel);
}
