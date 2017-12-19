package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	
	
	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}
	
	
	
	@Override
	public int intset(User user) {
	return this.userDao.insert(user);
	}



	@Override
	public int delete(int id) {

		return  this.userDao.deleteByPrimaryKey(id);
	}



	@Override
	public int insertSelect(User user) {
	
		return  this.userDao.insertSelective(user);
	}



	@Override
	public int updateSelect(User user) {
		
		return this.userDao.updateByPrimaryKeySelective(user);
	}



	@Override
	public User select(int id) {
		
		return this.userDao.selectByPrimaryKey(id);
	}



	@Override
	public List<User> fingByIds(List<Integer> ids) {
		
		return this.userDao.findByIds(ids);
	}



	@Override
	public List<User> fingBylike(String name) {
		
		return this.userDao.findBylike(name);
	}

}
