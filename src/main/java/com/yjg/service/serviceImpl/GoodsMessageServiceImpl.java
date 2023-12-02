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
			throw new MyException("GoodsMessage不能为空！");
		}
		GoodsMessage goodsMessage=(GoodsMessage) map.get("GoodsMessage");
		if(goodsMessage.getGoodsId()==null){
			throw new MyException("goodsId不能为空！");
		}
		if(goodsMessage.getUserId()==null){
			throw new MyException("userId不能为空！");
		}
		goodsMessageMapper.inserGoodsMessage(goodsMessage);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectAllGoodsMessage(Map<String, Object> map) throws MyException{
		if(map.get("GoodsMessage")==null){
			throw new MyException("GoodsMessage不能为空！");
		}
		GoodsMessage goodsMessage=(GoodsMessage) map.get("GoodsMessage");
		if(goodsMessage.getGoodsId()==null){
			throw new MyException("goodsId不能为空！");
		}
		List<GoodsMessage> list = goodsMessageMapper.selectAllGoodsMessage(goodsMessage);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> deletGoodsMessage(Map<String, Object> map) throws MyException{
		if(map.get("GoodsMessage")==null){
			throw new MyException("GoodsMessage不能为空！");
		}
		GoodsMessage goodsMessage=(GoodsMessage) map.get("GoodsMessage");
		if(goodsMessage.getGoodsId()==null){
			throw new MyException("goodsId不能为空！");
		}
		goodsMessageMapper.deletGoodsMessage(goodsMessage);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}


}
