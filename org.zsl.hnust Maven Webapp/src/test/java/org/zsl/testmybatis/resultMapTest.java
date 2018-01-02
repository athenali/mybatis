package org.zsl.testmybatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.DeptDao;
import com.cn.hnust.dao.resultMapDao;
import com.cn.hnust.pojo.Dept;
import com.cn.hnust.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class resultMapTest {
@Resource
private resultMapDao resultMapDao;
@Resource
private DeptDao deptDao;
@Test  
public void findDept(){
	User findDept = resultMapDao.findDept(2);
	System.out.println(findDept);
  }

@Test
public void  selectByPrimaryKey (){
	Dept dept = deptDao.selectByPrimaryKey(1);
	System.out.println(dept);
	System.out.println(dept.getId()+"++++++++++++"+dept.getDeptName());
}

@Test
public  void  	findDept1(){
	User user = resultMapDao.findDept1(1);
	System.out.println(user);
}


}
