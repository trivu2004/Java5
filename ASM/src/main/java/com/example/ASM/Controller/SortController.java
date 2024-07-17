//package com.example.ASM.Controller;
//
//
//import com.example.ASM.Dao.ProductDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Optional;
//
//@Controller
//public class SortController {
//
//    @Autowired
//    ProductDAO proDao;
//
//    @GetMapping("/product/index")
//    public String sort_index(Model model) {
//
//        s
//        return "index";
//    }
////
////    @GetMapping("/product/sort")
////    public String sort_sort(Model model, @RequestParam("field") Optional<String> field) {
////        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
////        model.addAttribute("field", field.orElse("price").substring(0, 1).toUpperCase() + field.orElse("price").substring(1, field.orElse("price").length()));
////        model.addAttribute("products", proDao.findAll(sort));
////        return "sort";
////    }
//}
