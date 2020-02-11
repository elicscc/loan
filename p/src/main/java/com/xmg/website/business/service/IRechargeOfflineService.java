package com.xmg.website.business.service;

import com.xmg.website.base.query.PageResult;
import com.xmg.website.business.domain.RechargeOffline;
import com.xmg.website.business.query.RechargeOfflineQueryObject;

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
