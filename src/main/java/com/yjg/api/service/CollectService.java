package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;


/**
 * 
 * @author YJG
 *
 */
@Service
public interface CollectService {
	
	public Map<String,Object> addCollect(Map<String,Object> map);
	
	public Map<String,Object> deletCollect(Map<String,Object> map);
	
	public Map<String,Object> selectAllCollect(Map<String,Object> map);
}
