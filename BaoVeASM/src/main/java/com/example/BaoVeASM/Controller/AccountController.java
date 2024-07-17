package com.example.BaoVeASM.Controller;

import com.example.BaoVeASM.Dao.AccountDao;
import com.example.BaoVeASM.Model.account;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Controller
public class AccountController {

    @Autowired
    private AccountDao accountDAO;
    @RequestMapping("/index")
    public String index(Model model, @ModelAttribute("accountItem") account account) {
        model.addAttribute("accountItems", accountDAO.findAll());
        return "manager_user";
    }
    @PostMapping("/account/create")
    public String category_create(Model model, @ModelAttribute("accountItem") account ca, BindingResult result) {
        if (!result.hasErrors()) {
            if (!accountDAO.findById(ca.getId()).isEmpty())
                model.addAttribute("error_category", "Id đã tồn tại!");
            else {
                accountDAO.save(ca);
                model.addAttribute("success_category", "Create success!");
            }
        }
        model.addAttribute("accountItems", accountDAO.findAll());
        return "manager_user";
    }

    @PostMapping("/account/update")
    public String category_update(Model model, @ModelAttribute("accountItem") account ca, BindingResult result) {
        if (!result.hasErrors()) {
            if (accountDAO.findById(ca.getId()).isEmpty())
                model.addAttribute("error_category", "Id không tồn tại!");
            else {
                accountDAO.save(ca);
                model.addAttribute("success_category", "Update success!");
            }
        }
        model.addAttribute("accountItems", accountDAO.findAll());
        return "manager_user";
    }

    @PostMapping("/account/delete")
    public String category_delete(Model model, @ModelAttribute("accountItem") account ca) {
        accountDAO.deleteById(ca.getId());
        model.addAttribute("success_category", "Delete success!");
        model.addAttribute("accountItems", accountDAO.findAll());
        return "manager_user";
    }

    @GetMapping("/account/edit")
    public String category_edit(Model model, @RequestParam("id") int id, @ModelAttribute("accountItem") account ca) {
        if (accountDAO.findById(ca.getId()).isEmpty())
            return "redirect:/account/index";
        else {
            account account = accountDAO.findById(id).get();
            ca.setId(account.getId());
            ca.setUsername(account.getUsername());
            ca.setPassword(account.getPassword());
            ca.setFullname(account.getFullname());
            ca.setEmail(account.getEmail());
            ca.setAdmin(account.isAdmin());
        }
        model.addAttribute("accountItems", accountDAO.findAll());
        return "manager_user";
    }

    @GetMapping("/account/delete")
    public String category_delete(Model model, @RequestParam("id") int id, @ModelAttribute("accountItem") account ca) {
        if (accountDAO.findById(ca.getId()).isEmpty())
            return "redirect:/category/index";
        else {
            accountDAO.deleteById(id);
            model.addAttribute("success_category", "Delete success!");
        }
        model.addAttribute("accountItems", accountDAO.findAll());
        return "manager_user";
    }
    @RequestMapping("/account/new1")
    public String showAccountForm1(Model model, HttpSession session) {
            model.addAttribute("accountItem", new account());
            return "redirect:/index";
    }
    @RequestMapping("/account/search-and-page")
    public String searchAndPage(
            @RequestParam("keywords") Optional<String> kw,
            @RequestParam("p") Optional<Integer> p,
            @SessionAttribute(name = "keywords", required = false) String sessionKeywords,
            Model model,
            WebRequest request) {

        String kwords = kw.orElse(sessionKeywords != null ? sessionKeywords : "");
        request.setAttribute("keywords", kwords, WebRequest.SCOPE_SESSION);

        Pageable pageable = PageRequest.of(p.orElse(0), 10);
        Page<account> page = accountDAO.findByKeywords("%" + kwords + "%", pageable);

        model.addAttribute("accountItems", page.getContent());
        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords); // Add keywords to model for the search form

        if (!model.containsAttribute("accountItem")) {
            model.addAttribute("accountItem", new account());
        }

        return "manager_user";
    }
}
