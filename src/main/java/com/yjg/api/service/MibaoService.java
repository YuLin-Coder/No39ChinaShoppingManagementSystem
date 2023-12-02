package com.yjg.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface MibaoService {
	public Map<String,Object> addMibao(Map<String,Object> map);
	public Map<String,Object> SelectOneMibao(Map<String,Object> map);
	
}
