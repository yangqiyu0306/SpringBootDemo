package com.yqy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yqy.model.Menu;


@Mapper
public interface MenuMapper {
	public List<Menu> findMenuInfo();
}
