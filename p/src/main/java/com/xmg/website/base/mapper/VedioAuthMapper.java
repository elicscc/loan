package com.xmg.website.base.mapper;

import java.util.List;

import com.xmg.website.base.domain.VedioAuth;
import com.xmg.website.base.query.VedioAuthQueryObject;

public interface VedioAuthMapper {

	int insert(VedioAuth record);

	VedioAuth selectByPrimaryKey(Long id);

	/**
	 * 查询相关
	 */
	int queryForCount(VedioAuthQueryObject qo);

	List<VedioAuth> query(VedioAuthQueryObject qo);

}