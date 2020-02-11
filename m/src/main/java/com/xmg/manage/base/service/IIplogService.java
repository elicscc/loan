package com.xmg.manage.base.service;

import com.xmg.manage.base.query.IplogQueryObject;
import com.xmg.manage.base.query.PageResult;

public interface IIplogService {

	/**
	 * 分页查询
	 * 
	 * @param qo
	 * @return
	 */
	PageResult query(IplogQueryObject qo);
}
