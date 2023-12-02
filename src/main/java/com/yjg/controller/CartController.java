package com.yjg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yjg.api.model.Cart;
import com.yjg.api.model.Collect;
import com.yjg.api.model.User;
import com.yjg.api.service.CartService;
import com.yjg.api.service.CollectService;
import com.yjg.util.DateUtil;

@Controller  
@RequestMapping("/cart")
public class CartController {
	@Resource
	private CartService cartService;
	@Resource
	private CollectService collectService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String toCart(HttpServletRequest request,HttpSession session){  
      
        return "cart";  
    }
	/**
	 * 
	 * @Title: getCart 
	 * @Description: »ñÈ¡¹ºÎï³µÄÚÈÝ
	 * @param @param request
	 * @param @param session
	 * @param @return  
	 * @return String
	 * @author YJG
	 */
	@RequestMapping(value = "/getCart",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String getCart(HttpServletRequest request,HttpSession session) {
		
		User user = (User) session.getAttribute("User");
		Integer userId = user.getUserId();
		Cart cart = new Cart();
		cart.setUserId(userId);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Cart", cart);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = cartService.SelectAllCart(reMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/remCart",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String remCart(HttpServletRequest request,HttpSession session) {
		User user = (User) session.getAttribute("User");
		Integer userId = user.getUserId();
		Integer cartId=null;
		if(request.getParameter("cartId")!=null){
			cartId=Integer.parseInt(request.getParameter("cartId"));
		}
		Cart cart = new Cart();
		cart.setCartId(cartId);
		cart.setUserId(userId);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Cart", cart);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = cartService.removeCart(reMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/updateCart",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String updateCart(HttpServletRequest request,HttpSession session) {
		Integer cartId=Integer.parseInt(request.getParameter("cartId"));
		Integer goodsNum=Integer.parseInt(request.getParameter("goodsNum"));
		Cart cart = new Cart();
		cart.setCartId(cartId);
		cart.setGoodsNum(goodsNum);
		String timeString = DateUtil.toDateTimeString(new Date());
		cart.setModeDate(timeString);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Cart", cart);
		Map<String,Object> returnMap=new HashMap<>();
		try {
		    returnMap = cartService.updateCart(reMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/addCart",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String addCart(HttpServletRequest request,HttpSession session) {
		Integer goodsId=Integer.parseInt(request.getParameter("goodsId"));
		String numz = request.getParameter("num");
		Integer userId=((User)session.getAttribute("User")).getUserId();
		Cart cart = new Cart();
		if(numz!=null){
			cart.setGoodsNum(Integer.parseInt(numz));
		}else{
			cart.setGoodsNum(1);
		}
		cart.setGoodsId(goodsId);
		cart.setUserId(userId);
		String timeString = DateUtil.toDateTimeString(new Date());
		cart.setCreateDate(timeString);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Cart", cart);
		Map<String,Object> returnMap=new HashMap<>();
		try {
			Map<String, Object> selectAllCart = cartService.SelectAllCart(reMap);
			@SuppressWarnings("unchecked")
			List<Cart> list=(List<Cart>) selectAllCart.get("RetData");
			if(list!=null&&list.size()>0){
				int num= list.get(0).getGoodsNum();
				int num2=num+1;
				Cart cart2 = new Cart();
				cart2.setCartId(list.get(0).getCartId());
				cart2.setGoodsNum(num2);
				Map<String,Object> reMap2=new HashMap<>();
				reMap2.put("Cart", cart2);
				returnMap= cartService.updateCart(reMap2);
			}else{
				 returnMap = cartService.addCart(reMap);
			}
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/addCollect",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String addCollect(HttpServletRequest request,HttpSession session) {
		Integer goodsId=Integer.parseInt(request.getParameter("goodsId"));
		Integer userId=((User)session.getAttribute("User")).getUserId();
		Collect collect = new Collect();
		collect.setGoodsId(goodsId);
		collect.setUserId(userId);
		String timeString = DateUtil.toDateTimeString(new Date());
		collect.setCreateDate(timeString);
		Map<String,Object> reMap=new HashMap<>();
		reMap.put("Collect", collect);
		Map<String,Object> returnMap=new HashMap<>();
		try {
			Map<String, Object> collect2 = collectService.selectAllCollect(reMap);
			@SuppressWarnings("unchecked")
			List<Collect> list=(List<Collect>) collect2.get("RetData");
			if(list!=null&&list.size()>0){
				returnMap.put("RetCode", "2");
				String jsonString = JSON.toJSONString(returnMap);
		        return jsonString;
			}else{
				returnMap = collectService.addCollect(reMap);
				String jsonString = JSON.toJSONString(returnMap);
		        return jsonString;
			}
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
}
