package com.cn.hnust.pojo;

import java.util.List;

public class Dept {
	private Integer id;
	private String deptName;
    private  List<User> users;
    
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(Integer id, String deptName, List<User> users) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", users=" + users + "]";
	}

}
