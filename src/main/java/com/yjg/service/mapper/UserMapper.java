package com.yjg.service.mapper;

import java.util.List;
import java.util.Map;

import com.yjg.api.model.User;

public interface UserMapper {
	public void inserUser(User user);
	public void upDateUser(User user);
	public User findUserByName(User user);
	public User findUser(User user);
	public List<User> selectAllUser(User user);
	
	public List<User> selectUserList(Map<String,Object> map);
	public int selectUserListcount(Map<String,Object> map);
}
