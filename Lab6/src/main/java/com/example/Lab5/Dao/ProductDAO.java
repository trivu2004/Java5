package com.example.Lab5.Dao;

import com.example.Lab5.entity.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<product, Integer> {
    @Query("SELECT o FROM products  o WHERE o.price BETWEEN ?1 AND ?2")
    List<product> findByPrice(double minPrice, double maxPrice);

        @Query("SELECT o FROM products o WHERE o.name LIKE ?1")
        Page<product> findByKeywords(String keywords, Pageable pageable);


//    @Query("SELECT o FROM products o WHERE o.name LIKE ?1 or o.price LIKE ?1 or o.id LIKE ?1 or o.category.name LIKE ?1")
//    Page<product> findByKeywords(String keywords, Pageable pageable);

    //Bài 4
    //List<Product> findByPriceBetween(double minPrice, double maxPrice);
    //Bài 5
    //Page<Product> findAllByNameLike(String keywords, Pageable pageable);
}

