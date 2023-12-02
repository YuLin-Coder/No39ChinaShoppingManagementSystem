package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.yjg.api.model.Collect;
import com.yjg.api.service.CollectService;
import com.yjg.service.mapper.CollectMapper;
import com.yjg.util.MyException;

@Service
public class CollectServiceImpl implements CollectService{
	
	@Resource
	private CollectMapper collectMapper;

	@Override
	public Map<String, Object> addCollect(Map<String, Object> map) throws MyException{
		if(map.get("Collect")==null){
			throw new MyException("Collect����Ϊ�գ�");
		}
		Collect collect=(Collect) map.get("Collect");
		if(collect.getGoodsId()==null){
			throw new MyException("goodsId����Ϊ�գ�");
		}
		if(collect.getUserId()==null){
			throw new MyException("userId����Ϊ�գ�");
		}
		collectMapper.inserCollect(collect);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> deletCollect(Map<String, Object> map) throws MyException{
		if(map.get("Collect")==null){
			throw new MyException("Collect����Ϊ�գ�");
		}
		Collect collect=(Collect) map.get("Collect");
		if(collect.getCollectId()==null){
			throw new MyException("collectId����Ϊ�գ�");
		}
		collectMapper.removeCollect(collect);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectAllCollect(Map<String, Object> map) throws MyException{
		if(map.get("Collect")==null){
			throw new MyException("Collect����Ϊ�գ�");
		}
		Collect collect=(Collect) map.get("Collect");
		if(collect.getUserId()==null){
			throw new MyException("userId����Ϊ�գ�");
		}
		List<Collect> list = collectMapper.findAllCollect(collect);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}






}
