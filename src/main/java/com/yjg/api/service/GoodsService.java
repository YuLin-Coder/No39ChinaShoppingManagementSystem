package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface GoodsService {
	public Map<String,Object> addGoods(Map<String,Object> map);
	
	public Map<String,Object> SelectOneGoods(Map<String,Object> map);
	
	public Map<String,Object> SelectAllGoods(Map<String,Object> map);
	
	public Map<String,Object> selectGoodsList(Map<String,Object> map);
	
	public Map<String,Object> deletGoods(Map<String,Object> map);
	
	public Map<String,Object> upDateGoods(Map<String,Object> map);
}
