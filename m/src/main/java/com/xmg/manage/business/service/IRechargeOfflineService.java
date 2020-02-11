package com.xmg.manage.business.service;

import com.xmg.manage.base.query.PageResult;
import com.xmg.manage.business.domain.RechargeOffline;
import com.xmg.manage.business.query.RechargeOfflineQueryObject;

/**
 * 线下充值服务
 * 
 * @author Administrator
 * 
 */
public interface IRechargeOfflineService {

	/**
	 * 提交线下充值单申请
	 * 
	 * @param recharge
	 */
	void apply(RechargeOffline recharge);

	PageResult query(RechargeOfflineQueryObject qo);

	/**
	 * 审核
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 */
	void audit(Long id, String remark, int state);

}
