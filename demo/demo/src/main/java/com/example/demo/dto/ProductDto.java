package com.example.demo.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;    
    private Long sku;
    private String name;
    private String brand;
    private String size;
    private Double price;    
    private String principal_image;
    private String other_images;
}
