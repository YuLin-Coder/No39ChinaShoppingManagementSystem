package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjg.api.model.ChinaTypeD;

/**
 * 
 * @Title: ChinaTypeService.java 
 * @Package com.yjg.api.service  
 * @author YJG  
 * @date 2017年4月14日 上午10:23:37 
 * @version V1.0
 */
@Service
public interface ChinaTypeService {
	
	public Map<String,Object> addChinaType(Map<String,Object> map);
	
	public Map<String,Object> addChinaTypeD(Map<String,Object> map);
	
	public Map<String,Object> updateChinaType(Map<String,Object> map);
	
	public Map<String,Object> updateChinaTypeD(Map<String,Object> map);
	
	
	public Map<String,Object> selectOneChinaType(Map<String,Object> map);
	
	public Map<String,Object> selectAllChinaType(Map<String,Object> map);
	
	public Map<String,Object> selectOneChinaTypeD(Map<String,Object> map);
	
	public Map<String,Object> selectAllChinaTypeD(Map<String,Object> map);

	public Map<String,Object> selectChinaTypeDByName(ChinaTypeD chinaTypeD);
	
	public Map<String,Object> deletChinaType(Map<String,Object> map);
	public Map<String,Object> deletChinaTypeD(Map<String,Object> map);
}
