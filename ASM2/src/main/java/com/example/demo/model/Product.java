package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String image;
	Double price;
	int qty;
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	Date createDate = new Date();

	Boolean available;

	@ManyToOne
	@JoinColumn(name = "Categoryid", insertable = false, updatable = false)
	Category category;
	
	@Column(name = "Categoryid", insertable = true, updatable = true)
	String cae;

	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
}