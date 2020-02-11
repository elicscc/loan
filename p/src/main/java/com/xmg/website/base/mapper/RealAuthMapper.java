package com.xmg.website.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xmg.website.base.domain.RealAuth;
import com.xmg.website.base.query.RealAuthQueryObject;

public interface RealAuthMapper {
	int insert(@Param("ra") RealAuth record, @Param("key") String key);

	RealAuth selectByPrimaryKey(@Param("id") Long id, @Param("key") String key);

	int updateByPrimaryKey(RealAuth record);

	/**
	 * 后台审核分页查询相关
	 */
	int queryForCount(@Param("qo") RealAuthQueryObject qo, @Param("key") String key);

	List<RealAuth> query(@Param("qo") RealAuthQueryObject qo, @Param("key") String key);
}