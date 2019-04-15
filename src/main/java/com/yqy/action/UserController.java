package com.yqy.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yqy.model.Menu;
import com.yqy.model.User;
import com.yqy.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("getAll")
	private List<User> getAll(){
		return userService.getAll();
	}
	
	@RequestMapping("getAll2")
	private List<User> getAll2(){
		return userService.getAll();
	}
	
	@RequestMapping("getMenu")
	private List<Menu> getMenu(){
		return userService.getMenu();
	}
	
	@RequestMapping("addUser")
	private int addUser(){
		
		User user = new User();
		
		user.setUserName("yqy");
		user.setUserPass("ccc");
		user.setUserPass("ccc");
		user.setUserPass("ccc");
		user.setUserPass("ccc");
		user.setUserPass("ccc");
		
		return userService.addUser(user);
	}

}
