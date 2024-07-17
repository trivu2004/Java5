package com.example.ASM.Service;

import com.example.ASM.entity.cart;
import org.springframework.stereotype.Service;
import com.example.ASM.entity.cartItem;
import java.util.Collection;

public interface cartService {
    public cart getCart(int id);
    public void setCart(cart cart);
    public int getCount(int id);
    public Collection<cartItem> getItems(int id);
    public void clear(int id);
    public cart insertCart(int id , int product);
    public void deleteCart(int id , int product,int qty);
     cart getCartById(int id);
    public cart updateCart(int id,int product,int qty);
    public void incrementQuantity(int id,int product);
    public void decreaseQuantity(int id,int product);
    public double getAmount(int id);

}
