package com.yjg.service.mapper;

import java.util.List;

import com.yjg.api.model.ChinaType;

public interface ChinaTypeMapper {
	public void inserChinaType(ChinaType chinaType);
	public void updateChinaType(ChinaType chinaType);
	public List<ChinaType> selectAllChinaType(ChinaType chinaType);
	public ChinaType selectOneChinaType(ChinaType chinaType);
	public void removeChinaType(ChinaType chinaType);
}
