package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product")
    private Long id;
    
    @Column(name = "sku", nullable = false)
    private Long sku;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "size", nullable = true)
    private String size;

    @Column(name = "price", nullable = false)
    private Double price;
    
    @Column(name = "principal_image", nullable = false)
    private String principal_image;

    @Column(name = "other_images", nullable = true)
    private String other_images;
    
}
