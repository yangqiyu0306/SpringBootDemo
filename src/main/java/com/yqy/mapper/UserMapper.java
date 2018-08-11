package com.yqy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yqy.model.User;

@Mapper
public interface UserMapper {
	
	public List<User> getAll();
	
	public int addUser(User user);

}
