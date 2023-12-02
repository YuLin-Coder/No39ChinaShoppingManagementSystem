package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;


/**
 * 
 * @Title: UserService.java 
 * @Package com.yjg.api.service  
 * @author YJG  
 * @date 2017年3月10日 下午2:11:31 
 * @version V1.0
 */
@Service
public interface UserService {
	/**
	 * 
	 * @Title: addUser 
	 * @Description: 注册用户
	 * @param  map(用户信息)
	 * @return Map<String,Object> (RetCode(1:0),RetMessage(成功:失败)) 
	 * @author YJG 
	 */
	public Map<String,Object> addUser(Map<String,Object> map);
	
	public Map<String,Object> updateUser(Map<String,Object> map);
	/**
	 * 
	 * @Title: checkName 
	 * @Description: 验证用户名 
	 * @param  map(用户名)
	 * @return Map<String,Object>(RetCode(1:0),RetMessage(成功:失败),RetData(存在：不存在)) 
	 * @author YJG
	 */
	public Map<String,Object> checkName(Map<String,Object> map);
	
	/**
	 * 
	 * @Title: checkLogin 
	 * @Description: 验证用户名 
	 * @param  map(用户名)
	 * @return Map<String,Object>(RetCode(1:0),RetMessage(成功:失败),RetData(存在：不存在)) 
	 * @author YJG
	 */
	public Map<String,Object> checkLogin(Map<String,Object> map);
	
	public Map<String,Object> selectAllUser(Map<String,Object> map);
	
	public Map<String,Object> selectUserList(Map<String,Object> map);
	
}
