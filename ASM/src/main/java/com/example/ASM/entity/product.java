package com.example.ASM.entity;

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

    // Remove associations that might trigger lazy loading from toString() method
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private category category;

    // Remove associations that might trigger lazy loading from toString() method
    // private List<order> orders;

    // Remove associations that might trigger lazy loading from toString() method
    // private List<orderDetail> orderDetails;

    public product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                ", available=" + available +
                '}';
    }
}
