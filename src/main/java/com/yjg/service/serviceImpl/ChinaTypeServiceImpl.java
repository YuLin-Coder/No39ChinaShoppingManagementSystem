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
			throw new MyException("���������Ϊ�գ�");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		chinaTypeMapper.inserChinaType(chinaType);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> addChinaTypeD(Map<String, Object> map) throws MyException{
		// TODO Auto-generated method stub
		ChinaTypeD chinaTypeD =(ChinaTypeD) map.get("ChinaTypeD");
		if(chinaTypeD.getTypeId()==null){
			throw new MyException("�����ID����Ϊ�գ�");
		}
		if(chinaTypeD.getName()==null){
			throw new MyException("���������Ϊ�գ�");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		chinaTypeDMapper.inserChinaTypeD(chinaTypeD);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> updateChinaType(Map<String, Object> map) throws MyException{
		// TODO Auto-generated method stub
		ChinaType chinaType =(ChinaType) map.get("ChinaType");
		if(chinaType.getTypeId()==null){
			throw new MyException("���ID����Ϊ�գ�");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		chinaTypeMapper.updateChinaType(chinaType);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> updateChinaTypeD(Map<String, Object> map) throws MyException{
		ChinaTypeD chinaTypeD =(ChinaTypeD) map.get("ChinaTypeD");
		if(chinaTypeD.getTypeDid()==null){
			throw new MyException("���ID����Ϊ�գ�");
		}
		if(chinaTypeD.getTypeId()==null){
			throw new MyException("�����ID����Ϊ�գ�");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		chinaTypeDMapper.updateChinaTypeD(chinaTypeD);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectOneChinaType(Map<String, Object> map)throws MyException {
		if(map.get("ChinaType")==null){
			throw new MyException("ChinaType����Ϊ�գ�");
		}
		ChinaType chinaType=(ChinaType) map.get("ChinaType");
		if(chinaType.getTypeId()==null){
			throw new MyException("typeId����Ϊ�գ�");
		}
		ChinaType chinaType2 = chinaTypeMapper.selectOneChinaType(chinaType);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", chinaType2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectAllChinaType(Map<String, Object> map) throws MyException{
		ChinaType chinaType=(ChinaType) map.get("ChinaType");
		List<ChinaType> list = chinaTypeMapper.selectAllChinaType(chinaType);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectOneChinaTypeD(Map<String, Object> map) throws MyException{
		if(map.get("ChinaTypeD")==null){
			throw new MyException("ChinaTypeD����Ϊ�գ�");
		}
		ChinaTypeD chinaTypeD=(ChinaTypeD) map.get("ChinaTypeD");
		if(chinaTypeD.getTypeDid()==null){
			throw new MyException("typeDid����Ϊ�գ�");
		}
		ChinaTypeD chinaTypeD2 = chinaTypeDMapper.selectOneChinaTypeD(chinaTypeD);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", chinaTypeD2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectAllChinaTypeD(Map<String, Object> map) throws MyException{
		ChinaTypeD chinaTypeD=(ChinaTypeD) map.get("ChinaTypeD");
		List<ChinaTypeD> list = chinaTypeDMapper.findAllChinaTypeD(chinaTypeD);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectChinaTypeDByName(ChinaTypeD chinaTypeD) {
		ChinaTypeD chinaTypeD2 = chinaTypeDMapper.selectChinaTypeDByName(chinaTypeD);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", chinaTypeD2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> deletChinaType(Map<String, Object> map) {
		if(map.get("ChinaType")==null){
			throw new MyException("ChinaType����Ϊ�գ�");
		}
		ChinaType chinaType=(ChinaType) map.get("ChinaType");
		if(chinaType.getTypeId()==null){
			throw new MyException("typeID����Ϊ�գ�");
		}
		chinaTypeDMapper.removeChinaTypeD(chinaType.getTypeId());
		chinaTypeMapper.removeChinaType(chinaType);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> deletChinaTypeD(Map<String, Object> map) {
		if(map.get("ChinaTypeD")==null){
			throw new MyException("ChinaTypeD����Ϊ�գ�");
		}
		ChinaTypeD ChinaTypeD=(ChinaTypeD) map.get("ChinaTypeD");
		if(ChinaTypeD.getTypeDid()==null){
			throw new MyException("typeDiD����Ϊ�գ�");
		}
		chinaTypeDMapper.removeChinaTypeD2(ChinaTypeD);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}


}
