package com.yjg.service.mapper;

import java.util.List;
import java.util.Map;

import com.yjg.api.model.Goods;

public interface GoodsMapper {
	public void inserGoods(Goods goods);
	public void updateGoods(Goods goods);
	public void removeGoods(Goods goods);
	public Goods findOneGoods(Goods goods);
	public List<Goods> findAllGoods(Goods goods);
	public List<Goods> selectGoodsList(Map<String,Object> map);
	public int selectGoodsListcount(Map<String,Object> map);
}
