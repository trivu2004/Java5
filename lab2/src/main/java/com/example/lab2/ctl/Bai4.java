package com.example.lab2.ctl;

import com.example.lab2.Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Bai4 {
    List<Product> products = new ArrayList<>();
    @GetMapping("/product/Bai4")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("product", p);
        return "Bai4";
    }

    @PostMapping("/product/Bai4save")
    public String save(@ModelAttribute("product") Product p, Model model) {
        products.add(p);
        System.out.println("----");
        products.forEach(System.out::println);
        model.addAttribute("products", products);
        return "Bai4";
    }



//    @ModelAttribute("items")
//    public List<Product> getItems() {
//        return Arrays.asList(new Product("A", 1.0), new Product("B", 12.0));
//    }
}
