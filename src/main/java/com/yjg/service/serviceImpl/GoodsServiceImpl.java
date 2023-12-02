package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjg.api.model.Goods;
import com.yjg.api.service.GoodsService;
import com.yjg.service.mapper.GoodsMapper;
import com.yjg.util.MyException;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Resource
	private GoodsMapper goodsMapper;

	@Override
	public Map<String, Object> addGoods(Map<String, Object> map) throws MyException{
		if(map.get("Goods")==null){
			throw new MyException("Goods不能为空！");
		}
		Goods goods=(Goods)map.get("Goods");
		if(goods.getGoodsFrom()==null){
			throw new MyException("goodsFrom不能为空！");
		}
		if(goods.getTypeDid()==null){
			throw new MyException("typeDid不能为空！");
		}
		if(goods.getCreateId()==null){
			throw new MyException("createId不能为空！");
		}
		goodsMapper.inserGoods(goods);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}

	@Override
	public Map<String, Object> SelectOneGoods(Map<String, Object> map) throws MyException{
		if(map.get("Goods")==null){
			throw new MyException("Goods不能为空！");
		}
		Goods goods=(Goods)map.get("Goods");
		if(goods.getGoodsId()==null){
			throw new MyException("goodsId不能为空！");
		}
		Goods goods2 = goodsMapper.findOneGoods(goods);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetData", goods2);
		map1.put("typedId", goods2.getTypeDid());
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}

	@Override
	public Map<String, Object> SelectAllGoods(Map<String, Object> map) throws MyException{
		if(map.get("Goods")==null){
			throw new MyException("Goods不能为空！");
		}
		Goods goods=(Goods)map.get("Goods");
		List<Goods> list = goodsMapper.findAllGoods(goods);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetData", list);
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}

	@Override
	public Map<String, Object> selectGoodsList(Map<String, Object> map) throws MyException{
		if(map.get("pageSize")==null){
			throw new MyException("pageSize不能为空！");
		}
		if(map.get("startPage")==null){
			throw new MyException("startPage不能为空！");
		}

		List<Goods> list = goodsMapper.selectGoodsList(map);
		int listcount = goodsMapper.selectGoodsListcount(map);
		Map<String,Object> map1=new HashMap<>();
		Map<String,Object> map2=new HashMap<>();
		map2.put("list", list);
		map2.put("size", listcount);
		map1.put("RetData", map2);
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}

	@Override
	public Map<String, Object> deletGoods(Map<String, Object> map) {
		if(map.get("Goods")==null){
			throw new MyException("Goods不能为空！");
		}
		Goods goods=(Goods)map.get("Goods");
		if(goods.getGoodsId()==null){
			throw new MyException("goodsId不能为空！");
		}
		goodsMapper.removeGoods(goods);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}

	@Override
	public Map<String, Object> upDateGoods(Map<String, Object> map) {
		if(map.get("Goods")==null){
			throw new MyException("Goods不能为空！");
		}
		Goods goods=(Goods)map.get("Goods");
		if(goods.getGoodsId()==null){
			throw new MyException("goodsId不能为空！");
		}
		goodsMapper.updateGoods(goods);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}


}
