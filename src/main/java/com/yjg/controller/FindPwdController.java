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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yjg.api.model.Mibao;
import com.yjg.api.model.User;
import com.yjg.api.service.MibaoService;
import com.yjg.api.service.UserService;
import com.yjg.util.DateUtil;

@Controller  
@RequestMapping("/findpwd")
public class FindPwdController {
	@Resource
	private UserService userService;
	@Resource
	private MibaoService mibaoService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String toRegister(HttpServletRequest request,Model model){  
      
        return "findPwd";  
    }
	

	@RequestMapping(value = "/checkUser",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String checkUser(@RequestParam String userName) {
        Map<String, Object> requestmap = new HashMap<>();
        User user = new User();
        user.setUserName(userName);
        requestmap.put("User", user);
        try {
			Map<String, Object> checkNameMap = userService.checkName(requestmap);		
			if(checkNameMap.get("RetData")!=null){
				User user1=(User)checkNameMap.get("RetData");
				 Map<String, Object> requestmap2 = new HashMap<>();
		        Mibao mibao = new Mibao();
		        mibao.setUserId(user1.getUserId());
		        requestmap2.put("Mibao", mibao);
		        Map<String, Object> mibao2 = mibaoService.SelectOneMibao(requestmap2);
		        checkNameMap.put("Mibao", mibao2.get("RetData"));
			}
			String jsonString = JSON.toJSONString(checkNameMap);
			return jsonString;
		} catch (Exception e) {
		    Map<String, Object> map = new HashMap<>();
	        map.put("RetCode", "0");
	        String jsonString = JSON.toJSONString(map);
	        return jsonString;
		}
    
    }
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
    public String updateUser(User user,HttpSession session) {
		Map<String, Object> requestmap = new HashMap<>();
		Map<String, Object> returnMap = new HashMap<>();
		String timeString = DateUtil.toDateTimeString(new Date());
		user.setModeDate(timeString);
		requestmap.put("User",user);
		try {
			returnMap = userService.updateUser(requestmap);
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		} catch (Exception e) {
			returnMap.put("RetCode", "0");
			returnMap.put("RetMessage", "Ê§°Ü");
			String jsonString = JSON.toJSONString(returnMap);
	        return jsonString;
		}
    }
}
