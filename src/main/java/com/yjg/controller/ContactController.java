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
import com.google.gson.Gson;
import com.yjg.api.model.Message;
import com.yjg.api.model.User;
import com.yjg.api.service.MessageService;
import com.yjg.util.DateUtil;

@Controller  
@RequestMapping("/contact")
public class ContactController {
	@Resource
	private MessageService messageService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String toContact(HttpServletRequest request,Model model){  
      
        return "contact";  
    }
	
	
	@RequestMapping(value = "/addContact",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String addContact(Message message) {
		
		Map<String, Object> requestmap = new HashMap<>();
		message.setmStatus("10");
		//当前时间
		String timeString = DateUtil.toDateTimeString(new Date());
		message.setCreateDate(timeString);
		requestmap.put("Message",message );
		Map<String, Object> map=new HashMap<>();
		try {
			map = messageService.addMessage(requestmap);
		} catch (Exception e) {
			map.put("RetCode", "0");
			map.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(map);
	        return jsonString;
		}
		String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
	
	@RequestMapping(value = "/getContact",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getContact(HttpServletRequest request) {
		
		Map<String, Object> requestmap = new HashMap<>();
		Message message = new Message();
		requestmap.put("Message", message);
		Map<String, Object> map=new HashMap<>();
		try {
			map = messageService.selectAllMessage(requestmap);
		} catch (Exception e) {
			map.put("RetCode", "0");
			map.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(map);
	        return jsonString;
		}
	//	String jsonString = JSON.toJSONString(map);
		Gson gson=new Gson();  
        String gsonStr=gson.toJson(map);
        return gsonStr;
    }
	
	@RequestMapping(value = "/getOneContact",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getOneContact(HttpServletRequest request,HttpSession session) {
		User user = (User) session.getAttribute("User1");
		int messageId=Integer.parseInt(request.getParameter("messageId"));
		Map<String, Object> requestmap = new HashMap<>();
		Message message = new Message();
		message.setMessageId(messageId);
		requestmap.put("Message", message);
		Map<String, Object> map=new HashMap<>();
		try {
			map = messageService.selectOneMessage(requestmap);
			if(map.get("RetData")!=null){
				Message message2=new Message();
				message2.setMessageId(messageId);
				message2.setHandleId(user.getUserId());
				message2.setHandleName(user.getUserName());
				message2.setmStatus("20");
				String timeString = DateUtil.toDateTimeString(new Date());
				message2.setHandleDate(timeString);
				requestmap.put("Message", message2);
				messageService.updateMessage(requestmap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("RetCode", "0");
			map.put("RetMessage", "失败");
			String jsonString = JSON.toJSONString(map);
	        return jsonString;
		}
	//	String jsonString = JSON.toJSONString(map);
		Gson gson=new Gson();  
        String gsonStr=gson.toJson(map);
		return gsonStr;
    }
		
}
