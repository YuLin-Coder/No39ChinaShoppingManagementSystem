package com.yjg.service.mapper;

import java.util.List;

import com.yjg.api.model.Collect;


public interface CollectMapper {
	public void inserCollect(Collect collect);
	public void removeCollect(Collect collect);
	public List<Collect> findAllCollect(Collect collect);
}
