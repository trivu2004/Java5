package com.example.Lab5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private double price;
    private Date createDate = new Date();
    private boolean available;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private category category;
    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    private List<order> orders;
    @OneToMany(mappedBy = "product")
    private List<orderDetail> orderDetails;
    public product(String name, double price){
        this.name = name;
        this.price = price;
    }
}
