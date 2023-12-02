package com.yjg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yjg.api.model.Mibao;
import com.yjg.api.model.User;
import com.yjg.api.service.MibaoService;
import com.yjg.api.service.UserService;
import com.yjg.util.DateUtil;

@Controller  
@RequestMapping("/register")
public class RegisterController {
	@Resource
	private UserService userService;
	@Resource
	private MibaoService mibaoService;
	
	/**
	 * 
	 * @Title: toRegister 
	 * @Description: 页面跳转 
	 * @param @param request
	 * @param @param model
	 * @param @return  
	 * @return String
	 * @author YJG
	 */
	@RequestMapping(method = RequestMethod.GET)
    public String toRegister(HttpServletRequest request,Model model){  
      
        return "register";  
    }
	
	/**
	 * 
	 * @Title: checkUser 
	 * @Description: 验证用户名是否存在 
	 * @param @param userName
	 * @param @return  
	 * @return String
	 * @author YJG
	 */
	@RequestMapping(value = "/checkUser",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String checkUser(@RequestParam String userName) {
        boolean result = true;
        Map<String, Object> requestmap = new HashMap<>();
        User user = new User();
        user.setUserName(userName);
        requestmap.put("User", user);
        try {
			Map<String, Object> checkNameMap = userService.checkName(requestmap);		
			if(checkNameMap.get("RetData")!=null){
				User user2=(User)checkNameMap.get("RetData");
				if(user2.getUserName()!=null){
					result=false;
				}
			}
		} catch (Exception e) {
		    Map<String, Boolean> map = new HashMap<>();
	        map.put("valid", false);
	        String jsonString = JSON.toJSONString(map);
	        return jsonString;
		}
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
	
	/**
	 * 
	 * @Title: addUser 
	 * @Description: 新增用户 
	 * @param @param user
	 * @param @return  
	 * @return String
	 * @author YJG
	 */
	@RequestMapping(value = "/addUser",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addUser(User user,Mibao mibao) {
		
		Map<String, Object> requestmap = new HashMap<>();
		String address=user.getProvince()+"-"+user.getCity()+"-"+user.getDistrict();
		user.setAddress(address);
		String timeString = DateUtil.toDateTimeString(new Date());
		user.setCreateDate(timeString);
		user.setIfAdmin("N");
		requestmap.put("User",user );
		try {
			Map<String, Object> mapzz = userService.addUser(requestmap);
			Integer userId = (int) mapzz.get("userIdz");
			mibao.setUserId(userId);
			requestmap.put("Mibao", mibao);
			mibaoService.addMibao(requestmap);
		} catch (Exception e) {
			return "register";
		}
		return "login";
    }
}
