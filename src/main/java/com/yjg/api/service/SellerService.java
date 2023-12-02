package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;


/**
 * 
 * @author YJG
 *
 */
@Service
public interface SellerService {

	public Map<String,Object> addSeller(Map<String,Object> map);

	public Map<String,Object> upDateSeller(Map<String,Object> map);
	
	public Map<String,Object> deletSeller(Map<String,Object> map);
	
	public Map<String,Object> selectOneSeller(Map<String,Object> map);
	
	public Map<String,Object> selectAllSeller(Map<String,Object> map);
	
	public Map<String,Object> selectSellerList(Map<String,Object> map);
}
