package com.yjg.service.mapper;

import java.util.List;
import java.util.Map;

import com.yjg.api.model.Seller;

public interface SellerMapper {
	public void insertSeller(Seller seller);
	public void upDateSeller(Seller seller);
	public Seller findOneSeller(Seller seller);
	public List<Seller> findAllSeller(Seller seller);
	public void removeSeller(Seller seller);
	public List<Seller> selectSellerList(Map<String,Object> map);
	public int selectSellerListcount(Map<String,Object> map);
}
