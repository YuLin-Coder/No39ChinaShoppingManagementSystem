package com.yjg.service.mapper;

import java.util.List;

import com.yjg.api.model.ChinaTypeD;


public interface ChinaTypeDMapper {
	public void inserChinaTypeD(ChinaTypeD chinaTypeD);
	public void updateChinaTypeD(ChinaTypeD chinaTypeD);
	public List<ChinaTypeD> findAllChinaTypeD(ChinaTypeD chinaTypeD);
	public ChinaTypeD selectOneChinaTypeD(ChinaTypeD chinaTypeD);
	public ChinaTypeD selectChinaTypeDByName(ChinaTypeD chinaTypeD);
	public void removeChinaTypeD(int typeDid);
	public void removeChinaTypeD2(ChinaTypeD chinaTypeD);
}
