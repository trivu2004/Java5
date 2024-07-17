package com.example.ASM.Controller;

import com.example.ASM.Dao.AccountDAO;
import com.example.ASM.Service.accountService;
import com.example.ASM.entity.account;
import com.example.ASM.Service.SessionService_Login;
import com.example.ASM.entity.cart;
import com.example.ASM.entity.product;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class AccountController {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private SessionService_Login session;
    @Autowired
    private accountService accountService;



    @PostMapping("/checkLogin")
    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        try {
            account user = accountDAO.findFirstByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                session.set("user", user);
                if (user.isAdmin()) {
                    return "redirect:/admin";
                } else {
                    return "redirect:/index/account";
                }
            } else {
                model.addAttribute("message", "Invalid username or password");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error occurred");
            e.printStackTrace();
            return "login";
        }
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute account account, RedirectAttributes redirectAttributes) {
        account accountnew = new account();
        cart cartnew = new cart();
        accountnew.setFullname(account.getFullname());
        accountnew.setEmail(account.getEmail());
        accountnew.setUsername(account.getUsername());
        accountnew.setPassword(account.getPassword());
        accountnew.setActivated(true);
        accountnew.setAdmin(false);
        accountnew.setCart(cartnew);
        cartnew.setAccount(accountnew);
        accountService.addAccount(accountnew);
        redirectAttributes.addFlashAttribute("message", "Account created successfully");
        return "redirect:/login";

    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
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


    @RequestMapping("/account/new")
    public String showAccountForm(Model model) {
        // Retrieve the logged-in user from the session
        account loggedInUser = (account) session.get("user");
        // Check if a user is logged in
        if (loggedInUser != null) {
            // Pass the logged-in user's information to the model
            model.addAttribute("accountItem", loggedInUser);
            // Return the account form template
            return "account-form";
        } else {
            // If no user is logged in, redirect to the login page
            return "manager_user";
        }
    }
    @RequestMapping("/account/new1")
    public String showAccountForm1(Model model) {
        account loggedInUser = (account) session.get("user");
        if (loggedInUser != null) {
            model.addAttribute("accountItem", new account());  // Add this line
            return "redirect:/manager_user";
        } else {
            return "redirect:/manager_user";
        }
    }

    @PostMapping("/account/newupdate")
    public String newupdate(Model model, @ModelAttribute("accountItem") account ca, BindingResult result) {
        if (!result.hasErrors()) {
            if (accountDAO.findById(ca.getId()).isEmpty())
                model.addAttribute("error_category", "Id không tồn tại!");
            else {
                accountDAO.save(ca);
                model.addAttribute("success_category", "Update success!");
            }
        }
        return "redirect:/account/new";
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
