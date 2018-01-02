package com.cn.hnust.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Dept;

public interface DeptDao {
	//获取一个部门的信息，里面没有用户的信息
public Dept	selectByPrimaryKey(Integer id);
    //级联查询获取部门和用户信息，里面穿的参数为一个，
    //如果参数为多个，可以用Map封装
public Dept selectByIdPlus(Integer id);
    //分布查询获取部门和用户的信息
public  Dept getUsers(Integer id);
   //使用鉴别器
public Dept getdiscriminator(Integer id);

/*---------------DynamicDeptMapper.xml  动态查询-----------------------*/

//if判断
public  List<Dept>getDynamic(String message);
//trim对前缀和后缀的操作
public List<Dept> getDynamicTrim(@Param("id")Integer id,@Param("deptName")String deptName);
//choose  when  otherwise
public  List<Dept>getDynamicChoose(Dept dept);

public List<Dept>getDynamicForeach(@Param("ids")List<Integer> ids);
//批量保存
public  void saveList(@Param("depts")List<Dept> depts);
//
}
