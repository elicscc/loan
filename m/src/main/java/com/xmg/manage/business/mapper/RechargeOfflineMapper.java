package com.xmg.manage.business.mapper;

import com.xmg.manage.business.domain.RechargeOffline;
import com.xmg.manage.business.query.RechargeOfflineQueryObject;

import java.util.List;

public interface RechargeOfflineMapper {
	int insert(RechargeOffline record);

	RechargeOffline selectByPrimaryKey(Long id);

	int updateByPrimaryKey(RechargeOffline record);

	int queryForCount(RechargeOfflineQueryObject qo);

	List<RechargeOffline> query(RechargeOfflineQueryObject qo);
}