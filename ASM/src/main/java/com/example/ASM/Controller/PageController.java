package com.example.ASM.Controller;

import com.example.ASM.Dao.ProductDAO;
import com.example.ASM.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PageController {
//
//    @Autowired
//    ProductDAO proDao;

//    @GetMapping("/product/page")
//    public String page(Model model, @RequestParam("p") Optional<Integer> p) {
//        Pageable pageable = PageRequest.of(p.orElse(0), 5);
//        Page<product> productPage = proDao.findAll(pageable);
//        model.addAttribute("page", productPage);
//        return "page";
//    }
}
