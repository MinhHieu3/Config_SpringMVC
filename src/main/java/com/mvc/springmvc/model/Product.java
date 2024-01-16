package com.mvc.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    private String name;
    private double price;
    @ManyToOne
    private Category idCate;


    public Product() {
    }

    public Product(int id, String name, double price, Category idCate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idCate = idCate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void put(int id, Product product) {
    }

    public Category getIdCate() {
        return idCate;
    }

    public void setIdCate(Category idCate) {
        this.idCate = idCate;
    }
}
