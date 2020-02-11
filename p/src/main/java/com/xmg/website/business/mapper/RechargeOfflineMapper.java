package com.xmg.website.business.mapper;

import java.util.List;

import com.xmg.website.business.domain.RechargeOffline;
import com.xmg.website.business.query.RechargeOfflineQueryObject;

public interface RechargeOfflineMapper {
	int insert(RechargeOffline record);

	RechargeOffline selectByPrimaryKey(Long id);

	int updateByPrimaryKey(RechargeOffline record);

	int queryForCount(RechargeOfflineQueryObject qo);

	List<RechargeOffline> query(RechargeOfflineQueryObject qo);
}