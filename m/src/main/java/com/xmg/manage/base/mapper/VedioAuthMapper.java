package com.xmg.manage.base.mapper;

import com.xmg.manage.base.domain.VedioAuth;
import com.xmg.manage.base.query.VedioAuthQueryObject;

import java.util.List;

public interface VedioAuthMapper {

	int insert(VedioAuth record);

	VedioAuth selectByPrimaryKey(Long id);

	/**
	 * 查询相关
	 */
	int queryForCount(VedioAuthQueryObject qo);

	List<VedioAuth> query(VedioAuthQueryObject qo);

}