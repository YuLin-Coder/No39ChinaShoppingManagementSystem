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
import com.yjg.api.model.User;
import com.yjg.api.service.UserService;

@Controller  
@RequestMapping("/login")
public class LoginController {
	@Resource
	private UserService userService;
	/**
	 * 
	 * @Title: toLogin 
	 * @Description: 登录页面跳转 
	 * @param @param request
	 * @param @param model
	 * @param @return  
	 * @return String
	 * @author YJG
	 */
	@RequestMapping(method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request,Model model){  
      
        return "login";  
    }
	
	/**
	 * 
	 * @Title: checkUser 
	 * @Description: 登录验证 
	 * @param @param request
	 * @param @param session
	 * @param @return  
	 * @return String
	 * @author YJG
	 */
	@RequestMapping(value = "/checkLogin",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String checkUser(HttpServletRequest request,HttpSession session) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> returnMap = new HashMap<>();
        requestMap.put("User", user);
        try {
			Map<String, Object> checkLogin = userService.checkLogin(requestMap);
			if(checkLogin.get("RetData")!=null){
				User user2=(User)checkLogin.get("RetData");
				if((user2.getIfAdmin()).equals("Y")){
					session.setAttribute("User1", user2);
					session.removeAttribute("User");
				}else{
					session.setAttribute("User", user2);
					session.removeAttribute("User1");
				}
				returnMap.put("ifAdmin", user2.getIfAdmin());
				returnMap.put("RetCode", '1');
			}else{
				returnMap.put("RetCode", '0');
			}
		} catch (Exception e) {
			returnMap.put("RetCode", '0');
			String jsonString = JSON.toJSONString(requestMap);
		    return jsonString;
		}
        String jsonString = JSON.toJSONString(returnMap);
        return jsonString;
    }
}
