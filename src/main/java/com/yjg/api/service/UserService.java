package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;


/**
 * 
 * @Title: UserService.java 
 * @Package com.yjg.api.service  
 * @author YJG  
 * @date 2017��3��10�� ����2:11:31 
 * @version V1.0
 */
@Service
public interface UserService {
	/**
	 * 
	 * @Title: addUser 
	 * @Description: ע���û�
	 * @param  map(�û���Ϣ)
	 * @return Map<String,Object> (RetCode(1:0),RetMessage(�ɹ�:ʧ��)) 
	 * @author YJG 
	 */
	public Map<String,Object> addUser(Map<String,Object> map);
	
	public Map<String,Object> updateUser(Map<String,Object> map);
	/**
	 * 
	 * @Title: checkName 
	 * @Description: ��֤�û��� 
	 * @param  map(�û���)
	 * @return Map<String,Object>(RetCode(1:0),RetMessage(�ɹ�:ʧ��),RetData(���ڣ�������)) 
	 * @author YJG
	 */
	public Map<String,Object> checkName(Map<String,Object> map);
	
	/**
	 * 
	 * @Title: checkLogin 
	 * @Description: ��֤�û��� 
	 * @param  map(�û���)
	 * @return Map<String,Object>(RetCode(1:0),RetMessage(�ɹ�:ʧ��),RetData(���ڣ�������)) 
	 * @author YJG
	 */
	public Map<String,Object> checkLogin(Map<String,Object> map);
	
	public Map<String,Object> selectAllUser(Map<String,Object> map);
	
	public Map<String,Object> selectUserList(Map<String,Object> map);
	
}
