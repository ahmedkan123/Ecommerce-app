package com.example.EcommerceApp.mapper;

import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductModel toModel(Product product);
    Product toEntity(ProductModel productModel);
}
