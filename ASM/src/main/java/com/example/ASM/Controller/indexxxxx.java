package com.example.ASM.Controller;

import com.example.ASM.Dao.AccountDAO;
import com.example.ASM.Dao.CategoryDAO;
import com.example.ASM.Dao.ProductDAO;
import com.example.ASM.Service.SessionService;
import com.example.ASM.Service.cartService;
import com.example.ASM.entity.account;
import com.example.ASM.entity.cart;
import com.example.ASM.entity.category;
import com.example.ASM.entity.product;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;

@Controller
public class indexxxxx {
    @Autowired
    CategoryDAO caDao;
    @Autowired
    AccountDAO accountDAO;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private cartService cartService;



    @Autowired
    private com.example.ASM.repository.productRepository productRepository;


    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/details")
    public String details(Model model) {
        return "details";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("adminPage", "home.jsp");
        return "admin";
    }

    @RequestMapping("/admin")
    public String test(Model model) {
        model.addAttribute("adminPage", "home.jsp");
        return "admin";
    }

    @RequestMapping("/manager_user")
    public String manager_user(Model model, @ModelAttribute("accountItem") account account) {
        account.setId(0);
        account.setUsername(null);
        model.addAttribute("accountItems", accountDAO.findAll());
        model.addAttribute("adminPage", "manager_user.jsp");
        return "admin";
    }

    @RequestMapping("/manager_category")
    public String manager_category(Model model, @ModelAttribute("categoryItem") category ca) {
        ca.setId(0);
        ca.setCategoryName(null);
        model.addAttribute("categoryItems", caDao.findAll());
        model.addAttribute("adminPage", "manager_category.jsp");
        return "admin";
    }

    @RequestMapping("/manager_product")
    public String manager_product(Model model, @ModelAttribute("productItem") product pro) {
        pro.setId(0);
        pro.setName(null);
        model.addAttribute("productItems", productDAO.findAll());
        model.addAttribute("adminPage", "manager_product.jsp");
        return "admin";
    }

    @GetMapping
    public String index1(Model model) {
        model.addAttribute("products", productDAO.findAll());
        return "index";
    }


    @RequestMapping("/mail")
    public String sendmail(Model model) {
        return "sendMail";
    }


    @GetMapping("/index")
    public String index(Model model,@ModelAttribute("cart") cart cart) {
        model.addAttribute("products", productDAO.findAll());
        return "index";
    }

    @RequestMapping("/cart")
    public String cart(Model model, HttpSession session) {
        account account = (account) session.getAttribute("user");
        model.addAttribute("cart", cartService.getItems(account.getId()));
        return "cart";
    }

    @GetMapping("/index/account")
    public String index2(Model model) {
        model.addAttribute("products", productDAO.findAll());
        return "redirect:/index";
    }

    @GetMapping("/addcart/{id}")
    public String addCart(Model model, @PathVariable("id") int id, HttpSession session, RedirectAttributes redirectAttributes) {
        account account = (account) session.getAttribute("user");
        if (account != null) {
            if (id > 0) {
                product product = productRepository.getById(id);
                cartService.insertCart(account.getId(), product.getId());
                cart cart = cartService.getCart(account.getId());
                session.setAttribute("cart", cart);
                session.setAttribute("tongtien", cartService.getAmount(account.getId()));
            }
        }
        return "redirect:/index";
    }

    @RequestMapping("/cart/update")
    public String updateCart(@RequestParam("id") int productId, @RequestParam("qty") int quantity, HttpSession session) {
        System.out.println(quantity);
        account account = (account) session.getAttribute("user");
        if (account != null && quantity > 0) {
            cartService.updateCart(account.getId(), productId, quantity);
            session.setAttribute("cart", cartService.getCartById(account.getId()));
            session.setAttribute("tongtien", cartService.getAmount(account.getId()));
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteCartItem(@PathVariable("id") int productId, HttpSession session) {
        account account = (account) session.getAttribute("user");
        if (account != null) {
            cartService.deleteCart(account.getId(), productId, 0);
            session.setAttribute("cart", cartService.getCartById(account.getId()));
            session.setAttribute("tongtien", cartService.getAmount(account.getId()));

        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart(HttpSession session) {
        account account = (account) session.getAttribute("user");
        if (account != null) {
            cartService.clear(account.getId());
            session.setAttribute("cart", null);
            session.setAttribute("tongtien", 0.0);
        }
        return "redirect:/cart";
    }

    @GetMapping("/locale")
    public String changeLocale(@RequestParam("lang") String lang, HttpServletResponse response) {
        Cookie cookie = new Cookie("locale", lang);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/test";
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        String lang = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("locale")) {
                    lang = cookie.getValue();
                    break;
                }
            }
        }
        if (lang == null) {
            lang = request.getLocale().getLanguage();
        }
        request.setAttribute("locale", lang);
        return "redirect:/index";
    }


    @RequestMapping("/product/search")
    public String search(Model model, @RequestParam("min") double min,
                         @RequestParam("max") double max) {
        List<product> items = productDAO.findByPrice(min, max);
        model.addAttribute("products", items);
        return "redirect:/product/search-and-page";
    }
    @GetMapping("/product/page")
    public String page(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 4);
        Page<product> productPage = productDAO.findAll(pageable);
        model.addAttribute("page", productPage);
        model.addAttribute("products", productPage.getContent());
        return "index";
    }


//    @GetMapping("/products")
//    public String getProducts(
//            @RequestParam(required = false) Double minPrice,
//            @RequestParam(required = false) Double maxPrice,
//            @RequestParam(required = false) String sort,
//            @RequestParam(required = false) String brand,
//            Model model) {
//        List<product> products = productDAO.findFilteredProducts(minPrice, maxPrice, sort, brand);
//        model.addAttribute("products", products);
//        return "index";
//    }



}
