package com.mvc.springmvc.controller;

import com.mvc.springmvc.model.Product;
import com.mvc.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView("/product/list");
        modelAndView.addObject("list",productService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView=new ModelAndView("/product/create");
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(Product product){
        ModelAndView modelAndView =new ModelAndView("/product/list");
        productService.add(product);
        modelAndView.addObject("list",productService.findAll());
        modelAndView.addObject("mess","Them Thanh Cong");
        return modelAndView;
    }
}
