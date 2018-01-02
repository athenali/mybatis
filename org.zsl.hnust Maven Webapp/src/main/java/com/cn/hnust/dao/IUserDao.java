package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.User;


public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);//插入数据

    int insertSelective(User record);//动态插入数据

    User selectByPrimaryKey(Integer id);//根据一个参数查询
    
    List<User> select(Integer id);//脏数据
  //根据两个参数查询
    public User selectByIdAndUserName(@Param("id")Integer id,@Param("userName") String userName);
  
    //传入多个参数，又不是pojo的属性值，除了可以用@Param("")外也可以用map，xml中就取map中的key即可
    public User selectByIdAndUserName(Map<String, Object> map);
  
    int updateByPrimaryKeySelective(User record);//动态更新

    int updateByPrimaryKey(User record);//所有字段都更新
    
    
    List<User> findByIds(List<Integer> ids);//传参为list，返回类型为list
    
    List<User> findBylike(String userName);//模糊查询，返回类型为list
    @MapKey("id") //map的键值，这里的list不会自动累加，获取的是userName相同的最后一条数据
    Map<String, List<User>>findByLikeReturnMap(String userName);//模糊查询，最后返回map
    
    List<User>  findDeptId(Integer  deptId);
  
}