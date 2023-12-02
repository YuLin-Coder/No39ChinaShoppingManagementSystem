package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjg.api.model.GoodsMessage;
import com.yjg.api.service.GoodsMessageService;
import com.yjg.service.mapper.GoodsMessageMapper;
import com.yjg.util.MyException;

@Service
public class GoodsMessageServiceImpl implements GoodsMessageService{
	
	@Resource
	private GoodsMessageMapper goodsMessageMapper;

	@Override
	public Map<String, Object> addGoodsMessage(Map<String, Object> map)throws MyException {
		if(map.get("GoodsMessage")==null){
			throw new MyException("GoodsMessage����Ϊ�գ�");
		}
		GoodsMessage goodsMessage=(GoodsMessage) map.get("GoodsMessage");
		if(goodsMessage.getGoodsId()==null){
			throw new MyException("goodsId����Ϊ�գ�");
		}
		if(goodsMessage.getUserId()==null){
			throw new MyException("userId����Ϊ�գ�");
		}
		goodsMessageMapper.inserGoodsMessage(goodsMessage);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectAllGoodsMessage(Map<String, Object> map) throws MyException{
		if(map.get("GoodsMessage")==null){
			throw new MyException("GoodsMessage����Ϊ�գ�");
		}
		GoodsMessage goodsMessage=(GoodsMessage) map.get("GoodsMessage");
		if(goodsMessage.getGoodsId()==null){
			throw new MyException("goodsId����Ϊ�գ�");
		}
		List<GoodsMessage> list = goodsMessageMapper.selectAllGoodsMessage(goodsMessage);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> deletGoodsMessage(Map<String, Object> map) throws MyException{
		if(map.get("GoodsMessage")==null){
			throw new MyException("GoodsMessage����Ϊ�գ�");
		}
		GoodsMessage goodsMessage=(GoodsMessage) map.get("GoodsMessage");
		if(goodsMessage.getGoodsId()==null){
			throw new MyException("goodsId����Ϊ�գ�");
		}
		goodsMessageMapper.deletGoodsMessage(goodsMessage);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}


}
