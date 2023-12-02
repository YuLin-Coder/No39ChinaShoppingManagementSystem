package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjg.api.model.User;
import com.yjg.api.service.UserService;
import com.yjg.service.mapper.UserMapper;
import com.yjg.util.MyException;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;
	@Override
	public Map<String, Object> addUser(Map<String, Object> map)throws MyException {
		// TODO Auto-generated method stub
		User user =(User) map.get("User");
		if(user.getUserName()==null){
			throw new MyException("用户名不能为空！");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		userMapper.inserUser(user);
		returnMap.put("RetCode", "1");
		returnMap.put("userIdz", user.getUserId());
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}
	@Override
	public Map<String, Object> checkName(Map<String, Object> map) throws MyException{
		User user =(User) map.get("User");
		if(user.getUserName()==null){
			throw new MyException("用户名不能为空！");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		User userByName = userMapper.findUserByName(user);
		returnMap.put("RetData", userByName);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}
	@Override
	public Map<String, Object> checkLogin(Map<String, Object> map) throws MyException {
		User user =(User) map.get("User");
		if(user.getUserName()==null){
			throw new MyException("用户名不能为空！");
		}
		if(user.getPassword()==null){
			throw new MyException("密码不能为空！");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		User user2 = userMapper.findUser(user);
		returnMap.put("RetData", user2);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}
	@Override
	public Map<String, Object> updateUser(Map<String, Object> map) throws MyException{
		User user =(User) map.get("User");
		if(user.getUserId()==null){
			throw new MyException("用户Id不能为空！");
		}
		Map<String,Object> returnMap=new HashMap<String,Object>();
		userMapper.upDateUser(user);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}
	@Override
	public Map<String, Object> selectAllUser(Map<String, Object> map) throws MyException{
		User user =(User) map.get("User");
		Map<String,Object> returnMap=new HashMap<String,Object>();
		List<User> list = userMapper.selectAllUser(user);
		returnMap.put("RetData", list);
		returnMap.put("RetCode", "1");
		returnMap.put("RetMessage", "成功");
		return returnMap;
	}
	@Override
	public Map<String, Object> selectUserList(Map<String, Object> map) throws MyException {
		if(map.get("pageSize")==null){
			throw new MyException("pageSize不能为空！");
		}
		if(map.get("startPage")==null){
			throw new MyException("startPage不能为空！");
		}

		List<User> list = userMapper.selectUserList(map);
		int listcount = userMapper.selectUserListcount(map);
		Map<String,Object> map1=new HashMap<>();
		Map<String,Object> map2=new HashMap<>();
		map2.put("list", list);
		map2.put("size", listcount);
		map1.put("RetData", map2);
		map1.put("RetCode", "1");
		map1.put("RetMessage","成功");
		return map1;
	}

}
