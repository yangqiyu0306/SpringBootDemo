package com.yqy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yqy.model.Menu;
import com.yqy.model.User;

public interface UserService {
	
	public List<User> getAll();
	
	public List<Menu> getMenu();
	
	public int addUser(User user);

}
