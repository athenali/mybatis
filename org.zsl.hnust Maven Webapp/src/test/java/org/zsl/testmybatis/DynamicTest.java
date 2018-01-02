package org.zsl.testmybatis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.DeptDao;
import com.cn.hnust.pojo.Dept;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class DynamicTest {
@Resource
private DeptDao deptDao;


@Test
public void getdiscriminator(){
	String message="yes";
	List<Dept> dynamic = deptDao.getDynamic(message);
	System.out.println(dynamic);
}

@Test
public void getDynamicTrim(){
	Integer id=1;
	String deptName="001";
	List<Dept> dynamicTrim = deptDao.getDynamicTrim(id, deptName);
	System.out.println(dynamicTrim);
}
@Test
public  void getDynamicChoose(){
	Dept dept=new Dept();
//	dept.setId(3);
	dept.setDeptName("003");
	List<Dept> dynamicChoose = deptDao.getDynamicChoose(dept);
	System.out.println(dynamicChoose);
}
@Test
public void getDynamicForeach (){
	List<Integer> ids=new ArrayList<>();
	ids.add(1);
	ids.add(2);
	List<Dept> dynamicForeach = deptDao.getDynamicForeach(ids);
	System.out.println(dynamicForeach);
}

@Test
public void saveList(){
	List<Dept> depts=new ArrayList<>();
	Dept   dept=new Dept(null, "004", null);
	depts.add(dept);
	Dept   dept1=new Dept(null, "005", null);
	depts.add(dept1);
	deptDao.saveList(depts);
	
}
}
