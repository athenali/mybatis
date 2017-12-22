package com.cn.hnust.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import com.cn.hnust.pojo.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public int intset(User user);
	
	public int insertSelect(User user);
	
	public int delete(int id);
	
    List<User> select(Integer id);
    
    public User selectByIdAndUserName(Integer id,String userName);
    
    public User selectByIdAndUserName(Map<String, Object> map);
    
	public User select(int id);
	
	
	public int  updateSelect(User user);
	public int update(User user);
	         
	public List<User> fingByIds(List<Integer> ids);
	
	
	public List<User> fingBylike(String name);
}
