package com.example.ASM.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class cartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) // Fetch associations lazily to avoid eager loading
    @JoinColumn(name="productId")
    private product product;

    private double price;
    private int qty = 1;

    @ManyToOne(fetch = FetchType.LAZY) // Fetch associations lazily to avoid eager loading
    @JoinColumn(name="cartId")
    private cart cart;

    @ManyToOne(fetch = FetchType.LAZY) // Fetch associations lazily to avoid eager loading
    @JoinColumn(name = "user_id")
    private account user;

    public void incrementQuantity(){
        this.qty++;
    }

    public void decreaseQuantity(){
        this.qty--;
        if (this.qty < 1) {
            this.qty = 1; // Ensure quantity doesn't go below 1
        }
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", product=" + (product != null ? product.getId() : null) +
                ", price=" + price +
                ", qty=" + qty +
                ", cart=" + (cart != null ? cart.getId() : null) +
                ", user=" + (user != null ? user.getId() : null) +
                '}';
    }
}
