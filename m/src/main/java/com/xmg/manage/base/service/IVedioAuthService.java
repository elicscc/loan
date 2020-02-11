package com.xmg.manage.base.service;

import com.xmg.manage.base.query.PageResult;
import com.xmg.manage.base.query.VedioAuthQueryObject;

/**
 * 视频认证服务
 * 
 * @author Administrator
 * 
 */
public interface IVedioAuthService {

	PageResult query(VedioAuthQueryObject qo);

	/**
	 * 视频审核逻辑
	 * @param loginInfoValue
	 * @param remark
	 * @param state
	 */
	void audit(Long loginInfoValue, String remark, int state);

}
