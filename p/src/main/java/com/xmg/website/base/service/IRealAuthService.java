package com.xmg.website.base.service;

import com.xmg.website.base.domain.RealAuth;
import com.xmg.website.base.query.PageResult;
import com.xmg.website.base.query.RealAuthQueryObject;

/**
 * 实名认证对象服务
 * 
 * @author Administrator
 * 
 */
public interface IRealAuthService {

	RealAuth get(Long id);

	/**
	 * 实名认证申请
	 * 
	 * @param realAuth
	 */
	void apply(RealAuth realAuth);

	PageResult query(RealAuthQueryObject qo);

	/**
	 * 实名认证审核
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 */
	void audit(Long id, String remark, int state);

}
