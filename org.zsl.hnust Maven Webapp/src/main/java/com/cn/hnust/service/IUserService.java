package com.cn.hnust.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.cn.hnust.pojo.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public int intset(User user);
	
	public int delete(int id);
	
	
	public int insertSelect(User user);
	public User select(int id);
	
	
	public int  updateSelect(User user);
	
	         
	public List<User> fingByIds(List<Integer> ids);
	
	
	public List<User> fingBylike(String name);
}
