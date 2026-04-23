package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/display";
    }

    @GetMapping("/display")
    public String displayProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "display-products";
    }
}
