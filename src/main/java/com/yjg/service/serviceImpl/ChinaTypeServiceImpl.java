package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.yjg.api.model.ChinaType;
import com.yjg.api.model.ChinaTypeD;
import com.yjg.api.service.ChinaTypeService;
import com.yjg.service.mapper.ChinaTypeDMapper;
import com.yjg.service.mapper.ChinaTypeMapper;
import com.yjg.util.MyException;

@Service
public class ChinaTypeServiceImpl implements ChinaTypeService{
	
	@Resource
	private ChinaTypeMapper chinaTypeMapper;
	@Resource
	private ChinaTypeDMapper chinaTypeDMapper;
	

	@Override
	public Map<String, Object> addChinaType(Map<String, Object> map) throws MyException{
		// TODO Auto-generated method stub
		ChinaType chinaType =(ChinaType) map.get("ChinaType");
		if(chinaType.getName()==null){
			throw new MyException("类别名不能为空！");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		chinaTypeMapper.inserChinaType(chinaType);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> addChinaTypeD(Map<String, Object> map) throws MyException{
		// TODO Auto-generated method stub
		ChinaTypeD chinaTypeD =(ChinaTypeD) map.get("ChinaTypeD");
		if(chinaTypeD.getTypeId()==null){
			throw new MyException("主类别ID不能为空！");
		}
		if(chinaTypeD.getName()==null){
			throw new MyException("类别名不能为空！");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		chinaTypeDMapper.inserChinaTypeD(chinaTypeD);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> updateChinaType(Map<String, Object> map) throws MyException{
		// TODO Auto-generated method stub
		ChinaType chinaType =(ChinaType) map.get("ChinaType");
		if(chinaType.getTypeId()==null){
			throw new MyException("类别ID不能为空！");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		chinaTypeMapper.updateChinaType(chinaType);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> updateChinaTypeD(Map<String, Object> map) throws MyException{
		ChinaTypeD chinaTypeD =(ChinaTypeD) map.get("ChinaTypeD");
		if(chinaTypeD.getTypeDid()==null){
			throw new MyException("类别ID不能为空！");
		}
		if(chinaTypeD.getTypeId()==null){
			throw new MyException("主类别ID不能为空！");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		chinaTypeDMapper.updateChinaTypeD(chinaTypeD);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectOneChinaType(Map<String, Object> map)throws MyException {
		if(map.get("ChinaType")==null){
			throw new MyException("ChinaType不能为空！");
		}
		ChinaType chinaType=(ChinaType) map.get("ChinaType");
		if(chinaType.getTypeId()==null){
			throw new MyException("typeId不能为空！");
		}
		ChinaType chinaType2 = chinaTypeMapper.selectOneChinaType(chinaType);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", chinaType2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectAllChinaType(Map<String, Object> map) throws MyException{
		ChinaType chinaType=(ChinaType) map.get("ChinaType");
		List<ChinaType> list = chinaTypeMapper.selectAllChinaType(chinaType);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectOneChinaTypeD(Map<String, Object> map) throws MyException{
		if(map.get("ChinaTypeD")==null){
			throw new MyException("ChinaTypeD不能为空！");
		}
		ChinaTypeD chinaTypeD=(ChinaTypeD) map.get("ChinaTypeD");
		if(chinaTypeD.getTypeDid()==null){
			throw new MyException("typeDid不能为空！");
		}
		ChinaTypeD chinaTypeD2 = chinaTypeDMapper.selectOneChinaTypeD(chinaTypeD);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", chinaTypeD2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectAllChinaTypeD(Map<String, Object> map) throws MyException{
		ChinaTypeD chinaTypeD=(ChinaTypeD) map.get("ChinaTypeD");
		List<ChinaTypeD> list = chinaTypeDMapper.findAllChinaTypeD(chinaTypeD);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectChinaTypeDByName(ChinaTypeD chinaTypeD) {
		ChinaTypeD chinaTypeD2 = chinaTypeDMapper.selectChinaTypeDByName(chinaTypeD);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", chinaTypeD2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> deletChinaType(Map<String, Object> map) {
		if(map.get("ChinaType")==null){
			throw new MyException("ChinaType不能为空！");
		}
		ChinaType chinaType=(ChinaType) map.get("ChinaType");
		if(chinaType.getTypeId()==null){
			throw new MyException("typeID不能为空！");
		}
		chinaTypeDMapper.removeChinaTypeD(chinaType.getTypeId());
		chinaTypeMapper.removeChinaType(chinaType);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}

	@Override
	public Map<String, Object> deletChinaTypeD(Map<String, Object> map) {
		if(map.get("ChinaTypeD")==null){
			throw new MyException("ChinaTypeD不能为空！");
		}
		ChinaTypeD ChinaTypeD=(ChinaTypeD) map.get("ChinaTypeD");
		if(ChinaTypeD.getTypeDid()==null){
			throw new MyException("typeDiD不能为空！");
		}
		chinaTypeDMapper.removeChinaTypeD2(ChinaTypeD);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}


}
