package com.xmg.website.base.mapper;

import java.util.List;

import com.xmg.website.base.domain.SystemDictionary;
import com.xmg.website.base.query.SystemDictionaryQueryObject;

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