package com.yjg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.yjg.api.model.Goods;
import com.yjg.api.model.User;
import com.yjg.api.service.ChinaTypeService;
import com.yjg.api.service.GoodsService;
   
@Controller  
@RequestMapping("/index")  
public class ToIndexController {  
	@Resource
    private ChinaTypeService chinaTypeService;
	@Resource
    private GoodsService goodsService;
 
      
	@RequestMapping(method = RequestMethod.GET)
    public String toIndex(HttpSession session,Model model){  
        return "index";  
    }
    
	@RequestMapping(value="/getSession" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
    public String getSession(HttpServletRequest request,HttpSession session){  
		User user=null;
		if( session.getAttribute("User")!=null){
			user = (User) session.getAttribute("User");
		}
		Map<String,Object> map=new HashMap<>();
		map.put("User", user);
		String jsonString = JSON.toJSONString(map);
        return jsonString;  
    }
	
	@RequestMapping(value="/remSession" ,method = RequestMethod.GET)
    public String remSession(HttpServletRequest request,HttpSession session){  
		session.removeAttribute("User");
		session.removeAttribute("User1");
		session.removeAttribute("name");
		session.removeAttribute("typeDid");
        return "index";  
    }

    @RequestMapping(value="/getTitle" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getTitle(HttpServletRequest request,HttpSession session){ 
    	Map<String,Object> map1=new HashMap<>();
    	Map<String, Object> selectAllChinaType=new HashMap<>();;
		try {
			selectAllChinaType = chinaTypeService.selectAllChinaType(map1);
		} catch (Exception e) {
			selectAllChinaType.put("RetCode",'0');
			selectAllChinaType.put("RetMessage","Ê§°Ü");
			String jsonString = JSON.toJSONString(selectAllChinaType);
	        return jsonString;
		}
    	String jsonString = JSON.toJSONString(selectAllChinaType);
        return jsonString;    
    }
    
	@RequestMapping(value="/getProducts" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
    public String getProducts(HttpServletRequest request,HttpSession session){  
		Map<String, Object> hashMap = new HashMap<>();
		try {
			Map<String,Object> map=new HashMap<>();
			Goods goods = new Goods();
			goods.setIfZK("N");
			map.put("Goods", goods);
			Map<String, Object> selectAllGoods = goodsService.SelectAllGoods(map);
			Map<String,Object> map2=new HashMap<>();
			Goods goods2 = new Goods();
			goods2.setIfZK("Y");
			map2.put("Goods", goods2);
			Map<String, Object> selectAllGoods2 = goodsService.SelectAllGoods(map2);
			selectAllGoods2.get("RetData");
			hashMap.put("RetData",selectAllGoods.get("RetData"));
			hashMap.put("RetDataZK",selectAllGoods2.get("RetData"));
			hashMap.put("RetCode", "1");
			hashMap.put("RetMessage", "³É¹¦");
		} catch (Exception e) {
			hashMap.put("RetCode", "0");
			hashMap.put("RetMessage", "Ê§°Ü");
			String jsonString = JSON.toJSONString(hashMap);
	        return jsonString;
		}
    	
		String jsonString = JSON.toJSONString(hashMap);
        return jsonString;  
    } 
	@RequestMapping(value="/getTypeD" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getTypeD(HttpServletRequest request,HttpSession session){ 
    	Map<String,Object> map1=new HashMap<>();
    	Map<String, Object> selectAllChinaType=new HashMap<>();;
		try {
			selectAllChinaType = chinaTypeService.selectAllChinaTypeD(map1);
		} catch (Exception e) {
			selectAllChinaType.put("RetCode",'0');
			selectAllChinaType.put("RetMessage","Ê§°Ü");
			String jsonString = JSON.toJSONString(selectAllChinaType);
	        return jsonString;
		}
		Gson gson=new Gson();  
	    String gsonStr=gson.toJson(selectAllChinaType);
    //	String jsonString = JSON.toJSONString(selectAllChinaType);
        return gsonStr;    
    }
}  