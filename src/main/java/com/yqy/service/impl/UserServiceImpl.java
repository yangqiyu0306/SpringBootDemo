package com.yqy.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqy.mapper.MenuMapper;
import com.yqy.mapper.UserMapper;
import com.yqy.model.Menu;
import com.yqy.model.User;
import com.yqy.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<User> getAll() {
		
		List<User> list = userMapper.getAll();
		
//		Stream<User> stream = list.stream();
//		stream.filter(s->s.getUserName() == "yqy").forEach(s->s.setUserName("ccc"));
//		list = stream.collect(Collectors.toList());
//		System.out.println("------------------------------------------------------------");
//		System.out.println(list.size());
//		
		list.forEach(o ->{System.out.println(o);});
		
		return list;
	}

	@Override
	public List<Menu> getMenu() {
		return menuMapper.findMenuInfo();
	}

	@Override
	@Transactional(value="txManager")
	public int addUser(User user) {
		
		int i = userMapper.addUser(user);
//		int j = i/0;
		return i;
	}

}
