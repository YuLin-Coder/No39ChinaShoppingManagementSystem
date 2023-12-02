package com.yjg.service.mapper;

import java.util.List;

import com.yjg.api.model.GoodsMessage;

public interface GoodsMessageMapper {
	public void inserGoodsMessage(GoodsMessage goodsMessage);
	public List<GoodsMessage> selectAllGoodsMessage(GoodsMessage goodsMessage);
	public void deletGoodsMessage(GoodsMessage goodsMessage);
}
