package com.example.ecommerceapp.mapper;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductModel toModel(Product product);
    Product toEntity(ProductModel productModel);
}
