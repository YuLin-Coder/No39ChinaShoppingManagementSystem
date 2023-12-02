package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjg.api.model.Cart;
import com.yjg.api.service.CartService;
import com.yjg.service.mapper.CartMapper;
import com.yjg.util.MyException;

@Service
public class CartServiceImpl implements CartService{
	
	@Resource
	private CartMapper cartMapper;

	@Override
	public Map<String, Object> addCart(Map<String, Object> map)throws MyException {
		if(map.get("Cart")==null){
			throw new MyException("Cart����Ϊ�գ�");
		}
		Cart cart=(Cart) map.get("Cart");
		if(cart.getGoodsId()==null){
			throw new MyException("goodsId����Ϊ�գ�");
		}
		if(cart.getUserId()==null){
			throw new MyException("userId����Ϊ�գ�");
		}
		cartMapper.inserCart(cart);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> SelectOneCart(Map<String, Object> map)throws MyException {
		if(map.get("Cart")==null){
			throw new MyException("Cart����Ϊ�գ�");
		}
		Cart cart=(Cart) map.get("Cart");
		if(cart.getCartId()==null){
			throw new MyException("cardId����Ϊ�գ�");
		}
		Cart cart2 = cartMapper.findOneCart(cart);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", cart2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> SelectAllCart(Map<String, Object> map)throws MyException {
		if(map.get("Cart")==null){
			throw new MyException("Cart����Ϊ�գ�");
		}
		Cart cart=(Cart) map.get("Cart");
		if(cart.getUserId()==null){
			throw new MyException("userId����Ϊ�գ�");
		}
		List<Cart> list = cartMapper.findAllCart(cart);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> updateCart(Map<String, Object> map) {
		if(map.get("Cart")==null){
			throw new MyException("Cart����Ϊ�գ�");
		}
		Cart cart=(Cart) map.get("Cart");
		if(cart.getCartId()==null){
			throw new MyException("cardId����Ϊ�գ�");
		}
		cartMapper.updateCart(cart);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> removeCart(Map<String, Object> map) {
		if(map.get("Cart")==null){
			throw new MyException("Cart����Ϊ�գ�");
		}
		Cart cart=(Cart) map.get("Cart");
		Map<String,Object> returnMap=new HashMap<String,Object>();
		if(cart.getCartId()==null){
			cartMapper.removeAllCart(cart);
		}else{
			cartMapper.removeCart(cart);
		}
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}




}
