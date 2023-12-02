package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjg.api.model.Mibao;
import com.yjg.api.service.MibaoService;
import com.yjg.service.mapper.MibaoMapper;
import com.yjg.util.MyException;

@Service
public class MibaoServiceImpl implements MibaoService{
	
	@Resource
	private MibaoMapper mibaoMapper;

	@Override
	public Map<String, Object> addMibao(Map<String, Object> map)throws MyException {
		Mibao mibao=(Mibao)map.get("Mibao");
		mibaoMapper.inserMibao(mibao);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}

	@Override
	public Map<String, Object> SelectOneMibao(Map<String, Object> map) throws MyException{
		if(map.get("Mibao")==null){
			throw new MyException("Mibao不能为空！");
		}
		Mibao mibao=(Mibao)map.get("Mibao");
		if(mibao.getUserId()==null){
			throw new MyException("userID不能为空！");
		}
		Mibao mibao2 = mibaoMapper.findOneMibao(mibao);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetData", mibao2);
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}





}
