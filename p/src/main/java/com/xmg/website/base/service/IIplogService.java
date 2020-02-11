package com.xmg.website.base.service;

import com.xmg.website.base.query.IplogQueryObject;
import com.xmg.website.base.query.PageResult;

public interface IIplogService {

	/**
	 * 分页查询
	 * 
	 * @param qo
	 * @return
	 */
	PageResult query(IplogQueryObject qo);
}
