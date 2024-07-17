package com.example.ASM.Dao;

import com.example.ASM.entity.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<product, Integer> {

    @Query("SELECT o FROM products  o WHERE o.price BETWEEN ?1 AND ?2")
    List<product> findByPrice(double minPrice, double maxPrice);

    @Query("SELECT p FROM products p WHERE p.name LIKE :keywords")
    Page<product> findByKeywords(@Param("keywords") String keywords, Pageable pageable);

//    @Query("SELECT p FROM products p WHERE " +
//            "(:brand IS NULL OR :brand = '' OR p.name LIKE :brand) AND " +
//            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
//            "(:maxPrice IS NULL OR p.price <= :maxPrice) AND " +
//            "(p.name LIKE :keywords OR p.description LIKE :keywords)")
//    Page<product> findByBrandAndPriceRangeAndKeywords(String brand, Integer minPrice, Integer maxPrice, String keywords, Pageable pageable);
//
//    @Query("SELECT p FROM products p WHERE " +
//            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
//            "(:maxPrice IS NULL OR p.price <= :maxPrice) AND " +
//            "(p.name LIKE :keywords OR p.description LIKE :keywords)")
//    Page<product> findByPriceRangeAndKeywords(Integer minPrice, Integer maxPrice, String keywords, Pageable pageable);
//    @Query("SELECT p FROM Product p WHERE " +
//            "(:brand IS NULL OR p.brand = :brand) AND " +
//            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
//            "(:maxPrice IS NULL OR p.price <= :maxPrice) AND " +
//            "(p.name LIKE :keywords OR p.description LIKE :keywords)")
//    Page<Product> findByBrandAndPriceRangeAndKeywords(String brand, Integer minPrice, Integer maxPrice, String keywords, Pageable pageable);
//
//    @Query("SELECT p FROM Product p WHERE " +
//            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
//            "(:maxPrice IS NULL OR p.price <= :maxPrice) AND " +
//            "(p.name LIKE :keywords OR p.description LIKE :keywords)")
//    Page<Product> findByPriceRangeAndKeywords(Integer minPrice, Integer maxPrice, String keywords, Pageable pageable);


//    @Query("SELECT p FROM products p WHERE " +
//            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
//            "(:maxPrice IS NULL OR p.price <= :maxPrice) AND " +
//            "(:brand IS NULL OR p.name LIKE %:brand%) " +
//            "ORDER BY " +
//            "CASE WHEN :sort = 'asc' THEN p.price END ASC, " +
//            "CASE WHEN :sort = 'desc' THEN p.price END DESC")
//    List<product> findFilteredProducts(@Param("minPrice") Double minPrice,
//                                       @Param("maxPrice") Double maxPrice,
//                                       @Param("sort") String sort,
//                                       @Param("brand") String brand);
}

