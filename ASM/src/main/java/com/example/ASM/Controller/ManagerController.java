package com.example.ASM.Controller;

import com.example.ASM.Dao.ProductDAO;
import com.example.ASM.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.ASM.Service.SessionService;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

@Controller
public class ManagerController {

    @Autowired
    ProductDAO productDAO;

    SessionService session;

    @PostMapping("/product/create")
    public String product_create(Model model, @ModelAttribute("productItem") product pro, BindingResult result) {
        if (!result.hasErrors()) {
            if (!productDAO.findById(pro.getId()).isEmpty())
                model.addAttribute("error_category", "Id đã tồn tại!");
            else {
                productDAO.save(pro);
                model.addAttribute("success_category", "Create success!");
            }
        }
        model.addAttribute("productItems", productDAO.findAll());
        return "manager_product";
    }

    @PostMapping("/product/update")
    public String product_update(Model model, @ModelAttribute("productItem") product pro, BindingResult result) {
        if (!result.hasErrors()) {
            if (productDAO.findById(pro.getId()).isEmpty())
                model.addAttribute("error_category", "Id không tồn tại!");
            else {
                productDAO.save(pro);
                model.addAttribute("success_category", "Update success!");
            }
        }
        model.addAttribute("productItems", productDAO.findAll());
        return "manager_product";
    }

    @PostMapping("/product/delete")
    public String product_delete(Model model, @ModelAttribute("productItem") product pro) {
        productDAO.deleteById(pro.getId());
        model.addAttribute("success_category", "Delete success!");
        model.addAttribute("productItems", productDAO.findAll());
        return "manager_product";
    }

    @GetMapping("/product/edit")
    public String product_edit(Model model, @RequestParam("id") int id, @ModelAttribute("productItem") product pro) {
        if (productDAO.findById(pro.getId()).isEmpty())
            return "redirect:/product/index";
        else {
            product product = productDAO.findById(id).get();
            pro.setId(product.getId());
            pro.setName(product.getName());
            pro.setImage(product.getImage());
            pro.setPrice(product.getPrice());
        }
        model.addAttribute("productItems", productDAO.findAll());
        return "manager_product";
    }

    @GetMapping("/product/delete")
    public String product_delete(Model model, @RequestParam("id") int id, @ModelAttribute("productItem") product pro) {
        if (productDAO.findById(pro.getId()).isEmpty())
            return "redirect:/product/index";
        else {
            productDAO.deleteById(id);
            model.addAttribute("success_category", "Delete success!");
        }
        model.addAttribute("productItems", productDAO.findAll());
        return "manager_product";
    }

    @RequestMapping("/product/search-and-page")
    public String searchAndPage(
            @RequestParam("keywords") Optional<String> kw,
            @RequestParam("p") Optional<Integer> p,
            @SessionAttribute(name = "keywords", required = false) String sessionKeywords,
            Model model,
            WebRequest request) {

        String kwords = kw.orElse(sessionKeywords != null ? sessionKeywords : "");
        request.setAttribute("keywords", kwords, WebRequest.SCOPE_SESSION);
        Pageable pageable = PageRequest.of(p.orElse(0), 10);
        Page<product> page = productDAO.findByKeywords("%" + kwords + "%", pageable);
        model.addAttribute("products", page.getContent());
        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords); // Add keywords to model for the search form
        return "index";
    }

}
