package com.example.Lab5.Controller;

import com.example.Lab5.Dao.CategoryDAO;
import com.example.Lab5.entity.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class CategoryController {

    @Autowired
    CategoryDAO caDao;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/category/index")
    public String category_index(Model model, @ModelAttribute("categoryItem") category ca) {
        ca.setId(0);
        ca.setCategoryName(null);
        model.addAttribute("categoryItems", caDao.findAll());
        return "category";
    }

    @PostMapping("/category/create")
    public String category_create(Model model, @ModelAttribute("categoryItem") category ca, BindingResult result) {
        if (!result.hasErrors()) {
            if (!caDao.findById(ca.getId()).isEmpty())
                model.addAttribute("error_category", "Id đã tồn tại!");
            else {
                caDao.save(ca);
                model.addAttribute("success_category", "Create success!");
            }
        }
        model.addAttribute("categoryItems", caDao.findAll());
        return "category";
    }

    @PostMapping("/category/update")
    public String category_update(Model model, @ModelAttribute("categoryItem") category ca, BindingResult result) {
        if (!result.hasErrors()) {
            if (caDao.findById(ca.getId()).isEmpty())
                model.addAttribute("error_category", "Id không tồn tại!");
            else {
                caDao.save(ca);
                model.addAttribute("success_category", "Update success!");
            }
        }
        model.addAttribute("categoryItems", caDao.findAll());
        return "category";
    }

    @PostMapping("/category/delete")
    public String category_delete(Model model, @ModelAttribute("categoryItem") category ca) {
        caDao.deleteById(ca.getId());
        model.addAttribute("success_category", "Delete success!");
        model.addAttribute("categoryItems", caDao.findAll());
        return "category";
    }

    @GetMapping("/category/edit")
    public String category_edit(Model model, @RequestParam("id") int id, @ModelAttribute("categoryItem") category ca) {
        if (caDao.findById(ca.getId()).isEmpty())
            return "redirect:/category/index";
        else {
            category category = caDao.findById(id).get();
            ca.setId(category.getId());
            ca.setCategoryName(category.getCategoryName());
        }
        model.addAttribute("categoryItems", caDao.findAll());
        return "category";
    }

    @GetMapping("/category/delete")
    public String category_delete(Model model, @RequestParam("id") int id, @ModelAttribute("categoryItem") category ca) {
        if (caDao.findById(ca.getId()).isEmpty())
            return "redirect:/category/index";
        else {
            caDao.deleteById(id);
            model.addAttribute("success_category", "Delete success!");
        }
        model.addAttribute("categoryItems", caDao.findAll());
        return "category";
    }
}
