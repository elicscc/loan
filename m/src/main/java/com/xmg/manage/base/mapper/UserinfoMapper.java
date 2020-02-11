package com.xmg.manage.base.mapper;


import com.xmg.manage.base.domain.Userinfo;

import java.util.List;
import java.util.Map;

public interface UserinfoMapper {

	int insert(Userinfo record);

	Userinfo selectByPrimaryKey(Long id);

	int updateByPrimaryKey(Userinfo record);

	List<Map<String, Object>> autocomplate(String keyword);
}