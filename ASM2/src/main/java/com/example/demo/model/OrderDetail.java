package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Double price;
	Integer quantity;
	@ManyToOne
	@JoinColumn(name = "Productid", insertable = false, updatable = false)
	Product product;
	
	@Column(name = "Productid", insertable = true, updatable = true)
	Integer proid;
	
	@ManyToOne
	@JoinColumn(name = "Orderid", insertable = false, updatable = false)
	Order order;
	
	@Column(name = "Orderid", insertable = true, updatable = true)
	Long odid;
}