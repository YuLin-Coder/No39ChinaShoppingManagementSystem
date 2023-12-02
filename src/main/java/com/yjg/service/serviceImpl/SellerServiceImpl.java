package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjg.api.model.Seller;
import com.yjg.api.service.SellerService;
import com.yjg.service.mapper.SellerMapper;
import com.yjg.util.MyException;

@Service
public class SellerServiceImpl implements SellerService{
	
	@Resource
	private SellerMapper sellerMapper;

	@Override
	public Map<String, Object> addSeller(Map<String, Object> map)throws MyException {
		// TODO Auto-generated method stub
		Seller seller =(Seller) map.get("Seller");
		if(seller.getUserId()==null){
			throw new MyException("�û�id����Ϊ�գ�");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		sellerMapper.insertSeller(seller);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> upDateSeller(Map<String, Object> map)throws MyException {
		Seller seller =(Seller) map.get("Seller");
		if(seller.getSellerId()==null){
			throw new MyException("����ID����Ϊ�գ�");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		sellerMapper.upDateSeller(seller);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectOneSeller(Map<String, Object> map) throws MyException{
		if(map.get("Seller")==null){
			throw new MyException("Seller����Ϊ�գ�");
		}
		Seller seller=(Seller) map.get("Seller");
		Seller seller2 = sellerMapper.findOneSeller(seller);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", seller2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectAllSeller(Map<String, Object> map) throws MyException{
		if(map.get("Seller")==null){
			throw new MyException("Seller����Ϊ�գ�");
		}
		Seller seller=(Seller) map.get("Seller");
		List<Seller> list = sellerMapper.findAllSeller(seller);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

	@Override
	public Map<String, Object> selectSellerList(Map<String, Object> map)throws MyException {
		if(map.get("pageSize")==null){
			throw new MyException("pageSize����Ϊ�գ�");
		}
		if(map.get("startPage")==null){
			throw new MyException("startPage����Ϊ�գ�");
		}

		List<Seller> list = sellerMapper.selectSellerList(map);
		int listcount = sellerMapper.selectSellerListcount(map);
		Map<String,Object> map1=new HashMap<>();
		Map<String,Object> map2=new HashMap<>();
		map2.put("list", list);
		map2.put("size", listcount);
		map1.put("RetData", map2);
		map1.put("RetCode", "1");
		map1.put("RetMessage","�ɹ�");
		return map1;
	}

	@Override
	public Map<String, Object> deletSeller(Map<String, Object> map) throws MyException{
		if(map.get("Seller")==null){
			throw new MyException("Seller����Ϊ�գ�");
		}
		Seller seller=(Seller) map.get("Seller");
		if(seller.getSellerId()==null){
			throw new MyException("sellerId����Ϊ�գ�");
		}
		sellerMapper.removeSeller(seller);
		Map<String,Object> returnMap=new HashMap<String,Object>();
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "�ɹ�");
		return returnMap;
	}

}
