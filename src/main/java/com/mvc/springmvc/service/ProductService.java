package com.mvc.springmvc.service;

import com.mvc.springmvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    List<Product>list;
    public ProductService(){
        this.list=new ArrayList<>();
        list.add(new Product(1,"A",10));
        list.add(new Product(2,"B",15));
    }
    public List<Product>findAll(){
        return list;
    }
    public void add(Product product){
        list.add(product);
    }
}
