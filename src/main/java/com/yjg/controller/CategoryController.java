package com.yjg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yjg.api.service.GoodsService;

@Controller  
@RequestMapping("/category")
public class CategoryController {
	@Resource
	private GoodsService goodsService;
	@RequestMapping(method = RequestMethod.GET)
    public String toCategory(HttpServletRequest request,HttpSession session){  
		String name = request.getParameter("name");
		String typeDid = request.getParameter("typeDid");
		if(name!=null){
			session.setAttribute("name",name );
		}
		if(typeDid!=null){
			session.setAttribute("typeDid",Integer.parseInt(typeDid));
		}
		
		
        return "category";  
    }
	
	@RequestMapping(value = "/getGoodsList",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String getGoodsList(HttpServletRequest request,HttpSession session) {
		Integer pageIndex =Integer.parseInt(request.getParameter("pageIndex"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		Integer startPage=(pageIndex-1)*pageSize;//从多少条开始
		Map<String,Object> hashMap = new HashMap<String,Object>();
		Map<String,Object> returnMap=new HashMap<>();
		Integer a=null;
		if(session.getAttribute("User1")!=null){
			session.removeAttribute("typeDid");
			session.removeAttribute("name");
		}
		if(session.getAttribute("name")!=null){
			session.removeAttribute("typeDid");
			String name = (String) session.getAttribute("name");
			hashMap.put("name", name);
		}
		if(session.getAttribute("typeDid")!=null){
			a=(Integer) session.getAttribute("typeDid");
			hashMap.put("typeDid", a);
		}
		hashMap.put("startPage", startPage);
	
		hashMap.put("pageSize", pageSize);
		try {
			returnMap = goodsService.selectGoodsList(hashMap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}

    }
}
