package org.zsl.testmybatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.DeptDao;
import com.cn.hnust.pojo.Dept;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class DeptMyBatisTest {
@Resource
private  DeptDao deptDao;

@Test
public void selectByIdPlus(){
	Dept dept = deptDao.selectByIdPlus(1);
	System.out.println(dept);
}
@Test
public  void  getUsers(){
	Dept dept = deptDao.getUsers(1);
	System.out.println(dept);
}

@Test
public void getdiscriminator(){
	Dept getdiscriminator = deptDao.getdiscriminator(1);
	System.out.println(getdiscriminator);
}
}
