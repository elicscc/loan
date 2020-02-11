package com.xmg.manage.base.mapper;

import com.xmg.manage.base.domain.SystemDictionary;
import com.xmg.manage.base.query.SystemDictionaryQueryObject;

import java.util.List;

public interface SystemDictionaryMapper {

	int insert(SystemDictionary record);

	SystemDictionary selectByPrimaryKey(Long id);

	List<SystemDictionary> selectAll();
	
	/**
	 * 分页的方法
	 * @param record
	 * @return
	 */
	int queryForCount(SystemDictionaryQueryObject qo);
	List<SystemDictionary> query(SystemDictionaryQueryObject qo);

	int updateByPrimaryKey(SystemDictionary record);
}