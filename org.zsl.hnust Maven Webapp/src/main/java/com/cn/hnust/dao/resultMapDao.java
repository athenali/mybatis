package com.cn.hnust.dao;

import com.cn.hnust.pojo.User;

public interface resultMapDao {
//resultMap的相关应用
	//查询一个人所对应的部门信息，总共有三种方法
   User	findDept(Integer id);
   //查找一个人所对应的部门信息
   User	findDept1(Integer id);
}
