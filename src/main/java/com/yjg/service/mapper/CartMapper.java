package com.yjg.service.mapper;

import java.util.List;

import com.yjg.api.model.Cart;


public interface CartMapper {
	public void inserCart(Cart cart);
	public Cart findOneCart(Cart cart);
	public void updateCart(Cart cart);
	public void removeCart(Cart cart);
	public void removeAllCart(Cart cart);
	public List<Cart> findAllCart(Cart cart);
}
