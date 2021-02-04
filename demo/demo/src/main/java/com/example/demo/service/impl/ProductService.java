package com.example.demo.service.impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

public interface ProductService {
	public ProductDto getProductById(Long idProduct);
	public ProductDto saveProduct(ProductDto product);
	public ProductDto updateProduct(Long idProduct, ProductDto product);
	public void deleteProduct(Long idProduct);
	public ProductDto productEntityToDto(Product productEntity);
	public Product productDtoToEntity(ProductDto productDto);	
	
}
