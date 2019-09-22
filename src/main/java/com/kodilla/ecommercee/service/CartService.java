package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService {
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Optional<Cart> getCart(Long id) {
        return cartRepository.findById(id);
    }

    public Cart createCart(final Long userId){
        Cart cart = new Cart(1L, null, null, null, null, new ArrayList<>(), userRepository.findById(userId).orElse(null));
        Cart cart2 = cartRepository.save(cart);
        return cart2;
    }

    public Optional<Product> findProduct(final Long id) {
        return productRepository.findById(id);
    }
}
