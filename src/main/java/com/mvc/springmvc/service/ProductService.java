package com.mvc.springmvc.service;

import com.mvc.springmvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    List<Product>list=new ArrayList<>();

    public List<Product>findAll(){
        return list;
    }
    public void add(Product product){
        list.add(product);
    }
    public Product findById(int id){
        Product product=new Product();
        for (Product p :list){
            if (p.getId()==id){
                product=p;
            }
        }
        return product;
    }
    public void update(int id, Product updatedProduct) {
        for (Product p : list) {
            if (p.getId() == id) {
                p.setName(updatedProduct.getName());
                p.setPrice(updatedProduct.getPrice());
                break;
            }
        }
    }
}
