package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface CartService {
	public Map<String,Object> addCart(Map<String,Object> map);
	public Map<String,Object> updateCart(Map<String,Object> map);
	public Map<String,Object> removeCart(Map<String,Object> map);
	public Map<String,Object> SelectOneCart(Map<String,Object> map);
	
	public Map<String,Object> SelectAllCart(Map<String,Object> map);
}
