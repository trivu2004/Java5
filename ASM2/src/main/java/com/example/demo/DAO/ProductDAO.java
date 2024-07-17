package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Report;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("select o from Product o where o.price between ?1 and ?2")
	List<Product> finByPrice(double minPrice, double maxPrice);

	@Query("select o from Product o where o.name like ?1")
	Page<Product> findByKeywords(String keywords, Pageable pageable);

	@Query("SELECT new Report(o.category, sum(o.price), count(o)) " + " FROM Product o " + " GROUP BY o.category"
			+ " ORDER BY sum(o.price) DESC")
	List<Report> getInventoryByCategory();

	Optional<Product> findByName(String name);

	void deleteByName(String name);

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	Page<Product> findAllByNameLike(String keywords, Pageable pageable);

	default Product getProductById(Integer id) {
		Optional<Product> optionalProduct = findById(id);
		return optionalProduct.orElse(null); 
	}

	@Query("select o from Product o where  o.category.id = ?1")
	List<Product> findByIdCategory(String id);

}
