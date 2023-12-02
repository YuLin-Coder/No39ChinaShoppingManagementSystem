package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public interface GoodsMessageService {
	public Map<String,Object> addGoodsMessage(Map<String,Object> map);
	public Map<String,Object> selectAllGoodsMessage(Map<String,Object> map);
	public Map<String,Object> deletGoodsMessage(Map<String,Object> map);
}
