package org.zsl.testmybatis;

import java.io.IOException;
import java.io.InputStream;import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableServer.IdAssignmentPolicy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;
	@Resource
	private IUserDao userDao;
	@Test
	public void test1() throws IOException {
      List<Integer> ids=new ArrayList<>();
      ids.add(2);
      List<User> findByIds = userService.fingByIds(ids);
      System.out.println(findByIds.get(0).getUserName());
	}
	@Test
	public void save(){
		User user=new User();
		user.setAge(20);
		user.setPassword("34");
		user.setUserName("34");
		userService.intset(user);
		System.out.println("save  success");
	}
	
	@Test
	public void updateByPrimaryKey(){
		User user=new User();
		user.setAge(30);
		user.setId(2);
		user.setPassword("223");
		userService.updateSelect(user);
	}
	@Test
	public  void selectByIdAndUserName(){
		String userName="34";
		Integer id=2;
		User user = userService.selectByIdAndUserName(id, userName);
		System.out.println(user.getPassword()+user.getUserName());
	}
	@Test
	public  void selectByIdAndUserName1(){
	Map<String, Object> map=new HashMap<>();
	map.put("id", 2);
	map.put("userName", "34");
	map.put("userInfo", "userInfo");
	User user = userService.selectByIdAndUserName(map);
	System.out.println(user.getPassword()+"==========="+user.getUserName());
	}
	@Test
	public void findBylike(){
		String userName="%3%";
		List<User> findBylike = userDao.findBylike(userName);
		System.out.println(findBylike);
	}
	@Test
    public  void findByLikeReturnMap(){
		String userName="%3%";
		Map<String, List<User>> findByLikeReturnMap = userDao.findByLikeReturnMap(userName);
		System.out.println(findByLikeReturnMap);
	}
	
	@Test
	public  void findDeptId(){
		List<User> findDeptId = userDao.findDeptId(1);
		System.out.println(findDeptId);
	}
	
	@Test
	public void findByIds(){
		List<Integer> ids=new ArrayList<>();
		ids.add(2);
		ids.add(3);
		List<User> findByIds = userDao.findByIds(ids);
		System.out.println(findByIds);
	}
}
