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
import com.google.gson.Gson;
import com.yjg.api.model.ChinaTypeD;
import com.yjg.api.model.Goods;
import com.yjg.api.model.GoodsMessage;
import com.yjg.api.model.User;
import com.yjg.api.service.ChinaTypeService;
import com.yjg.api.service.GoodsMessageService;
import com.yjg.api.service.GoodsService;
import com.yjg.util.DateUtil;

@Controller  
@RequestMapping("/product")
public class ProductController {
	@Resource
	private GoodsService goodsService;
	@Resource
	private ChinaTypeService chinaTypeService;
	@Resource
	private GoodsMessageService goodsMessageService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String toProduct(HttpServletRequest request,HttpSession session){  
		String goodsId1 = request.getParameter("goodsId");
		session.setAttribute("goodsId1", Integer.parseInt(goodsId1));
        return "product";  
    }
	
	@RequestMapping(value = "/loadGoods",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String loadGoods(HttpServletRequest request,HttpSession session) {
		Integer goodsId=(Integer) session.getAttribute("goodsId1");
		try {
			Map<String, Object> map1 = new HashMap<>();
			Goods goods = new Goods();
			goods.setGoodsId(goodsId);
			map1.put("Goods", goods);
			Map<String, Object> selectOneGoods = goodsService.SelectOneGoods(map1);
			Integer typeDid = (Integer) selectOneGoods.get("typedId");
			
			ChinaTypeD chinaTypeD = new ChinaTypeD();
			chinaTypeD.setTypeDid(typeDid);
			Map<String, Object> map2 = new HashMap<>();
			map2.put("ChinaTypeD", chinaTypeD);
			Map<String, Object> selectOneChinaTypeD = chinaTypeService.selectOneChinaTypeD(map2);
			ChinaTypeD object = (ChinaTypeD) selectOneChinaTypeD.get("RetData");
			String chinaTypeN=object.getName();
			selectOneGoods.put("RetData2", chinaTypeN);
			selectOneGoods.put("RetData3", typeDid);
	        String jsonString = JSON.toJSONString(selectOneGoods);
	        return jsonString;
		} catch (Exception e) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
	        String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}

    }
	
	@RequestMapping(value = "/xsGoods",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String xsGoods(HttpServletRequest request,HttpSession session) {
		Integer goodsId=(Integer) session.getAttribute("goodsId1");
		try {
			Map<String, Object> map1 = new HashMap<>();
			Goods goods = new Goods();
			goods.setGoodsId(goodsId);
			map1.put("Goods", goods);
			Map<String, Object> selectOneGoods = goodsService.SelectOneGoods(map1);
			Integer typeDid = (Integer) selectOneGoods.get("typedId");
			goods.setTypeDid(typeDid);
			Map<String, Object> goods2Map = goodsService.SelectAllGoods(map1);
			if(goods2Map.get("RetData")!=null){
				@SuppressWarnings({"unchecked" })
				List<Goods> list=(List<Goods>) goods2Map.get("RetData");
				for (int i = 0; i < list.size(); i++) { 
					  
					if (list.get(i).getGoodsId()==goodsId) { 					  
						list.remove(i); 					  
						i--; 					  
					} 					  
				}
			}
	        String jsonString = JSON.toJSONString(goods2Map);
	        return jsonString;
		} catch (Exception e) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
	        String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/goodsMessageS",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String goodsMessageS(HttpServletRequest request,HttpSession session) {
		Integer goodsId=(Integer) session.getAttribute("goodsId1");
		try {
			Map<String, Object> map1 = new HashMap<>();
			GoodsMessage goodsMessage = new GoodsMessage();
			goodsMessage.setGoodsId(goodsId);
			map1.put("GoodsMessage", goodsMessage);
			Map<String, Object> goods2Map = goodsMessageService.selectAllGoodsMessage(map1);			
			Gson gson=new Gson();  
	        String gsonStr=gson.toJson(goods2Map);
	        return gsonStr;
		} catch (Exception e) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
	        String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
	@RequestMapping(value = "/goodsMessageAdd",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String goodsMessageAdd(HttpServletRequest request,HttpSession session) {
		User user = (User) session.getAttribute("User");
		Integer userId = user.getUserId();
		String userName=user.getUserName();
		String parameter = request.getParameter("goodsId");
		Integer goodsId = Integer.parseInt(parameter);
		String myd = request.getParameter("myd");
		String message = request.getParameter("message");
		String timeString = DateUtil.toDateTimeString(new Date());
		try {
			Map<String, Object> map1 = new HashMap<>();
			GoodsMessage goodsMessage = new GoodsMessage();
			goodsMessage.setGoodsMDetail(message);
			goodsMessage.setUserName(userName);
			goodsMessage.setCreateDate(timeString);
			goodsMessage.setManyd(myd);
			goodsMessage.setUserId(userId);
			goodsMessage.setGoodsId(goodsId);
			map1.put("GoodsMessage", goodsMessage);
			Map<String, Object> selectOneGoods = goodsMessageService.addGoodsMessage(map1);
	        String jsonString = JSON.toJSONString(selectOneGoods);
	        return jsonString;
		} catch (Exception e) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
	        String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
	
}
