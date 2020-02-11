package com.xmg.website.base.service;

import com.xmg.website.base.query.PageResult;
import com.xmg.website.base.query.VedioAuthQueryObject;

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
