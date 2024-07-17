//package com.example.Lab5;
//
//import com.example.Lab5.entity.product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import com.example.Lab5.Dao.ProductDAO;
//@Configuration
//public class conf {
//    @Autowired
//    private ProductDAO repo;
//
//
//    @Bean
//    public CommandLineRunner runner() {
//        return runner -> {
//
//            repo.save(new product("Iphone 11", 2000));
//            repo.save(new product("Samsung Galaxy S20", 1800));
//            repo.save(new product("Google Pixel 5", 1500));
//            repo.save(new product("OnePlus 8", 1200));
//            repo.save(new product("Sony Xperia 1 II", 1600));
//            repo.save(new product("Huawei P40", 1700));
//            repo.save(new product("Xiaomi Mi 10", 1300));
//            repo.save(new product("Oppo Find X2", 1400));
//            repo.save(new product("LG V60 ThinQ", 1100));
//            repo.save(new product("Nokia 8.3", 1000));
//            repo.save(new product("Asus ROG Phone 3", 2000));
//            repo.save(new product("Realme X50 Pro", 900));
//            repo.save(new product("Vivo X50", 950));
//            repo.save(new product("Motorola Edge+", 1750));
//            repo.save(new product("Lenovo Legion Phone Duel", 1850));
//            repo.save(new product("ZTE Axon 11", 800));
//            repo.save(new product("Meizu 17", 700));
//            repo.save(new product("Sharp Aquos R5G", 650));
//            repo.save(new product("TCL 10 Pro", 600));
//            repo.save(new product("Alcatel 3L", 500));
//
//        };
//    }
//}
