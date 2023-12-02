package com.yjg.controller;


import java.util.Date;
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
import com.yjg.api.model.ChinaType;
import com.yjg.api.model.ChinaTypeD;
import com.yjg.api.model.User;
import com.yjg.api.service.ChinaTypeService;
import com.yjg.util.DateUtil;

   
@Controller  
@RequestMapping("/index2")  
public class ToIndex2Controller {  
	@Resource
    private ChinaTypeService chinaTypeService;
 
      
	@RequestMapping(method = RequestMethod.GET)
    public String toIndex(HttpSession session,Model model){  
        return "index2";  
    }
	
	
	@RequestMapping(value="/addType" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String addType(HttpServletRequest request,HttpSession session){ 
		User user = (User) session.getAttribute("User1");
    	Map<String,Object> map1=new HashMap<>();
    	Map<String, Object> map2=new HashMap<>();
    	String name = request.getParameter("name");
    	String typeid = request.getParameter("typeid");
    	ChinaType chinaType = new ChinaType();
    	chinaType.setName(name);
    	String timeString = DateUtil.toDateTimeString(new Date()); //当前时间
		try {
			if(typeid!=null&&!"".equals(typeid)){
				//修改
				chinaType.setTypeId(Integer.parseInt(typeid));
				chinaType.setModeDate(timeString);
				chinaType.setModeId(user.getUserId());
				chinaType.setModePer(user.getUserName());
				map1.put("ChinaType", chinaType);
				map2 = chinaTypeService.updateChinaType(map1);
			}else{
				//新增
				chinaType.setCreateDate(timeString);
				chinaType.setCreateId(user.getUserId());
				chinaType.setCreatePer(user.getUserName());
				map1.put("ChinaType", chinaType);
				map2=chinaTypeService.addChinaType(map1);
			}
		} catch (Exception e) {
			map2.put("RetCode",'0');
			map2.put("RetMessage","失败");
			String jsonString = JSON.toJSONString(map2);
	        return jsonString;
		}
    	String jsonString = JSON.toJSONString(map2);
        return jsonString;    
    }
	//子品种修改或增加
	@RequestMapping(value="/addTypeD" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String addTypeD(HttpServletRequest request,HttpSession session){ 
		User user = (User) session.getAttribute("User1");
    	Map<String,Object> map1=new HashMap<>();
    	Map<String, Object> map2=new HashMap<>();
    	String name = request.getParameter("name");
    	String typeid = request.getParameter("typeid");
    	String typeDid = request.getParameter("typeDid");
    	ChinaTypeD chinaTypeD = new ChinaTypeD();
    	chinaTypeD.setName(name);
    	chinaTypeD.setTypeId(Integer.parseInt(typeid));
    	String timeString = DateUtil.toDateTimeString(new Date()); //当前时间
		try {
			if(typeDid!=null&&!"".equals(typeDid)){
				//修改
				chinaTypeD.setTypeDid(Integer.parseInt(typeDid));
				chinaTypeD.setModeDate(timeString);
				chinaTypeD.setModeId(user.getUserId());
				chinaTypeD.setModePer(user.getUserName());
				map1.put("ChinaTypeD", chinaTypeD);
				map2 = chinaTypeService.updateChinaTypeD(map1);
			}else{
				//新增
				chinaTypeD.setCreateDate(timeString);
				chinaTypeD.setCreateId(user.getUserId());
				chinaTypeD.setCreatePer(user.getUserName());
				map1.put("ChinaTypeD", chinaTypeD);
				map2=chinaTypeService.addChinaTypeD(map1);
			}
		} catch (Exception e) {
			map2.put("RetCode",'0');
			map2.put("RetMessage","失败");
			String jsonString = JSON.toJSONString(map2);
	        return jsonString;
		}
    	String jsonString = JSON.toJSONString(map2);
        return jsonString;    
    }
	@RequestMapping(value="/delType" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String delType(HttpServletRequest request,HttpSession session){ 
    	Map<String,Object> map1=new HashMap<>();
    	Map<String, Object> map2=new HashMap<>();
    	String typeid = request.getParameter("typeid");
		try {
			ChinaType chinaType = new ChinaType();
			chinaType.setTypeId(Integer.parseInt(typeid));
			map1.put("ChinaType", chinaType);
			map2 = chinaTypeService.deletChinaType(map1);
		} catch (Exception e) {
			map2.put("RetCode",'0');
			map2.put("RetMessage","失败");
			String jsonString = JSON.toJSONString(map2);
	        return jsonString;
		}
    	String jsonString = JSON.toJSONString(map2);
        return jsonString;    
    }
	@RequestMapping(value="/delTypeD" ,method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String delTypeD(HttpServletRequest request,HttpSession session){ 
    	Map<String,Object> map1=new HashMap<>();
    	String typeDid = request.getParameter("typeDid");
    	Map<String, Object> map2=new HashMap<>();
		try {
			
			ChinaTypeD chinaTypeD = new ChinaTypeD();
			chinaTypeD.setTypeDid(Integer.parseInt(typeDid));
			map1.put("ChinaTypeD", chinaTypeD);
			map2 = chinaTypeService.deletChinaTypeD(map1);
		} catch (Exception e) {
			map2.put("RetCode",'0');
			map2.put("RetMessage","失败");
			String jsonString = JSON.toJSONString(map2);
	        return jsonString;
		}
    	String jsonString = JSON.toJSONString(map2);
        return jsonString;    
    }
}  