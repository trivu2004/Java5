package com.example.ASM.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private account account;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<cartItem> cartItems = new ArrayList<>();

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                // Avoid accessing associated entities in toString() to prevent infinite recursion
                ", accountId=" + (account != null ? account.getId() : null) +
                ", cartItems=" + cartItems +
                '}';
    }
}
