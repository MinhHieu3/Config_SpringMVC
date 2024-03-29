package com.mvc.springmvc.controller;

import com.mvc.springmvc.model.Product;
import com.mvc.springmvc.repository.CategoryRepository;
import com.mvc.springmvc.repository.ProductRepository;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("list", productRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("listCate", categoryRepository.findAll());
        modelAndView.addObject("product", new Product());

        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("edit", productRepository.findById(id).get());
        modelAndView.addObject("listCate", categoryRepository.findAll());
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productRepository.delete(productRepository.findById(id).get());
        return "redirect:/products";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        List<Product>productList=new ArrayList<>( productRepository.findProductByNameContaining(search));
        modelAndView.addObject("list",productList);
        return modelAndView;
    }
}
