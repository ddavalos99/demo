package com.example.demo.service.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    EntityManager em;
    
    @Override
    public ProductDto getProductById(Long idProduct) {

        Optional<Product> product = productRepository.findById(idProduct);

        if (product.isPresent()) {
            return productEntityToDto(product.get());
        } else {
            return null;
        }
    }

    @Override
    public ProductDto saveProduct(ProductDto product) {
        Product productEntity = productDtoToEntity(product);
        try {
            return productEntityToDto(productRepository.save(productEntity));
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    
    @Override
    public ProductDto updateProduct(Long idProduct, ProductDto product) {
    	ProductDto vProduct = getProductById(idProduct);

        if (vProduct == null) {
            return null;
        } else {
            try {
                return saveProduct(product);
            } catch (Exception e) {                
            	throw new RuntimeException("Error: " + e.getMessage());
            }
        }
    }
    
    @Override
    public void deleteProduct(Long idProduct) {
        try {
        	productRepository.deleteById(idProduct);
        } catch (Exception e) {            
        	throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    
        
    @Override
    public ProductDto productEntityToDto(Product productEntity) {

        if (productEntity == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        if (productEntity.getSku() != null) {
        	productDto.setSku(productEntity.getSku());        	
        }
        
        if (productEntity.getName() != null) {
        	productDto.setName(productEntity.getName());        	
        }

        if (productEntity.getBrand() != null) {
        	productDto.setBrand(productEntity.getBrand());        	
        }
        
        if (productEntity.getSize() != null) {
        	productDto.setSize(productEntity.getSize());        	
        }

        if (productEntity.getPrice() != null) {
        	productDto.setPrice(productEntity.getPrice());        	
        }
        
        if (productEntity.getPrincipal_image() != null) {
        	productDto.setPrincipal_image(productEntity.getPrincipal_image());        	
        }
        
        if (productEntity.getOther_images() != null) {
        	productDto.setOther_images(productEntity.getOther_images());        	
        }
        
        
        return productDto;
    }
    
    @Override
    public Product productDtoToEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }

        Product productEntity = new Product();

        if (productDto.getSku() != null) {
        	productEntity.setSku(productDto.getSku());        	
        }
        
        if (productDto.getName() != null) {
        	productEntity.setName(productDto.getName());        	
        }

        if (productDto.getBrand() != null) {
        	productEntity.setBrand(productDto.getBrand());        	
        }
        
        if (productDto.getSize() != null) {
        	productEntity.setSize(productDto.getSize());        	
        }

        if (productDto.getPrice() != null) {
        	productEntity.setPrice(productDto.getPrice());        	
        }
        
        if (productDto.getPrincipal_image() != null) {
        	productEntity.setPrincipal_image(productDto.getPrincipal_image());        	
        }
        
        if (productDto.getOther_images() != null) {
        	productEntity.setOther_images(productDto.getOther_images());        	
        }
        
        
        return productEntity;
    }
        
}
