//package com.example.ASM.Service;
//
//import com.example.ASM.entity.cartItem;
//import com.example.ASM.entity.product;
//import com.example.ASM.entity.account;
//import com.example.ASM.entity.cart;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//
//@Service
//@Transactional
//public class CartItemServiceImpl implements czzzz {
//
//    private accountService accountService;
//    private productService productService;
//
//    @Autowired
//    public CartItemServiceImpl(productService productService, accountService accountService) {
//        this.productService = productService;
//        this.accountService = accountService;
//    }
//
//
//    @Override
//    public cart getCart() {
//        return null;
//    }
//
//    @Override
//    public void setCart(cart cart) {
//
//    }
//
//    @Override
//    public int getCount(int id) {
//        account account = accountService.getAccountById(id);
//        cart cart = account.getCart();
//        if (cart != null) {
//            return cart.getCartItems().size();
//        }
//        return 0;
//    }
//
//    @Override
//    public Collection<cartItem> getItems(int id) {
//        account account = accountService.getAccountById(id);
//        cart cart = account.getCart();
//        if (cart != null) {
//            return cart.getCartItems();
//        }
//        return List.of();
//    }
//
//    @Override
//    public void clear(int id) {
//        account account = accountService.getAccountById(id);
//        if (account != null) {
//            throw new IllegalArgumentException("User not fund");
//        }
//        cart cart = account.getCart();
//        if (cart != null) {
//            cart.getCartItems().clear();
//            accountService.addAccount(account);
//        }
//    }
//
//    @Override
//    public cart insertCart(int id, int productId) {
//        account account = accountService.getAccountById(id);
//        product product = productService.getProduct(productId);
//
//        cart cart = account.getCart();
//        List<cartItem> cartItems = cart.getCartItems();
//        cartItem cartItem = findCartItemByBookId(cartItems, productId);
//        if (cartItem == null) {
//            cartItem = new cartItem();
//            cartItem.setProduct(product);
//            cartItem.setQty(1);
//            cartItem.setCart(cart);
//            cartItems.add(cartItem);
//        } else {
//            cartItem.incrementQuantity();
//        }
//        accountService.addAccount(account);
//        return cart;
//
//    }
//
//    @Override
//    public void deleteCart(int id, int product, int qty) {
//        account account = accountService.getAccountById(id);
//        cart cart = account.getCart();
//        if (cart != null) {
//            List<cartItem> cartItems = cart.getCartItems();
//            cartItems.removeIf(cartItem -> cartItem.getProduct().getId() == product);
//            accountService.addAccount(account);
//
//        }
//    }
//
//    @Override
//    public cart getCartById(int id) {
//        return null;
//    }
//
//    @Override
//    public cart updateCart(int id, int product, int qty) {
//        account account = accountService.getAccountById(id);
//        cart cart = account.getCart();
//        if (cart != null) {
//            List<cartItem> cartItems = cart.getCartItems();
//            cartItem cartItem = findCartItemByBookId(cartItems, product);
//            if (cartItem != null) {
//                if (qty > 0) {
//                    cartItem.setQty(qty);
//                } else {
//                    cartItems.remove(cartItem);
//                }
//                accountService.addAccount(account);
//            }
//        }
//        return cart;
//    }
//
//    @Override
//    public void incrementQuantity(int id, int product) {
//        account account = accountService.getAccountById(id);
//        cart cart = account.getCart();
//        if (cart != null) {
//            List<cartItem> cartItems = cart.getCartItems();
//            cartItem cartItem = findCartItemByBookId(cartItems, product);
//                if (cartItem != null){
//                    cartItem.incrementQuantity();
//                    accountService.addAccount(account);
//                }
//        }
//
//    }
//
//    @Override
//    public void decreaseQuantity(int id, int product) {
//        account account = accountService.getAccountById(id);
//    }
//
//    @Override
//    public double getAmount(int id) {
//        account account = accountService.getAccountById(id);
//        cart cart = account.getCart();
//        if (cart != null) {
//            return cart.getCartItems().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQty()).sum();
//
//        }
//        return 0;
//    }
//
//    private cartItem findCartItemByBookId(List<cartItem> cartItems, int bookId) {
//        for (cartItem cartItem : cartItems) {
//            if (cartItem.getProduct().getId() == bookId) {
//                return cartItem;
//            }
//        }
//        return null;
//    }
//
//
//}
