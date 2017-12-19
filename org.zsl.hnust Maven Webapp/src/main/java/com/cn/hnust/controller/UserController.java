package com.cn.hnust.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.QueryHint;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		// int userId = Integer.parseInt(request.getParameter("id"));
		int userId = 1;
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/insert")
	public void toInsert(HttpServletRequest request, Model model) {
		User user = new User();
		user.setAge(78);
		user.setUserName("lixiaonan");
		user.setId(2);
		this.userService.intset(user);
	}

	@RequestMapping("/insertSelect")
	public String insertSelect() {
		User user = new User();
		user.setId(3);
		user.setUserName("lixiaonan");
		this.userService.insertSelect(user);
		return "showUser";
	}

	@RequestMapping("/delete")
	public void toDelete() {
		int id = 2;
		this.userService.delete(id);
	}

	@RequestMapping("/update")
	public String update() {
		int id = 1;
		User user = this.userService.select(id);
		user.setAge(78788);
		this.userService.updateSelect(user);
		return "showUser";
	}

	@RequestMapping("findByIds")
	public void findByIds() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		List<User> users = this.userService.fingByIds(ids);
		for (User user : users) {
			System.out.println(user.getUserName());
		}
	}
	
	@RequestMapping("findBylike")
	public void findBylike() {
		
		String name="%li%";
	List<User> users=	this.userService.fingBylike(name);
	for (User user : users) {
		System.out.println(user.getId());
	}
		
	}
	
}
