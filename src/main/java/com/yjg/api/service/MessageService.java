package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 
 * @Title: MessageService.java 
 * @Package com.yjg.api.service  
 * @author YJG  
 * @date 2017年4月14日 上午10:25:47 
 * @version V1.0
 */
@Service
public interface MessageService {
	public Map<String,Object> addMessage(Map<String,Object> map);
	public Map<String,Object> selectOneMessage(Map<String,Object> map);
	public Map<String,Object> selectAllMessage(Map<String,Object> map);
	public Map<String,Object> updateMessage(Map<String,Object> map);
}
