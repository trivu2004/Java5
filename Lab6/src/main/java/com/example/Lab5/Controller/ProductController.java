package com.example.Lab5.Controller;

import com.example.Lab5.Dao.ProductDAO;
import com.example.Lab5.entity.product;
import com.example.Lab5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductDAO dao;
    @Autowired
    SessionService session;

    @RequestMapping("/product/search")
    public String search(Model model, @RequestParam("min") double min,
                         @RequestParam("max") double max) {
        List<product> items = dao.findByPrice(min, max);
        model.addAttribute("items", items);
        return "sort";
    }

    @RequestMapping("/product/search-and-page")
    public String searchAndPage(
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p,Model model) {

        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<product> page = dao.findByKeywords("%"+kwords+"%", pageable);
        model.addAttribute("page", page);
        return "page";
    }

}
