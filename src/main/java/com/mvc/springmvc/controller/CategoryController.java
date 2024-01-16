package com.mvc.springmvc.controller;

import com.mvc.springmvc.model.Category;
import com.mvc.springmvc.model.Product;
import com.mvc.springmvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("list", categoryRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/product/create");
    }

    @PostMapping("/save")
    public String save(Category category) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("edit", categoryRepository.findById(id).get());
        modelAndView.addObject("listCate", categoryRepository.findAll());
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        categoryRepository.deleteProductsByCategoryId(id);
        categoryRepository.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
