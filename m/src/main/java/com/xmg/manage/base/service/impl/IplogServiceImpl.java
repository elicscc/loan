package com.xmg.manage.base.service.impl;

import com.xmg.manage.base.domain.Iplog;
import com.xmg.manage.base.mapper.IplogMapper;
import com.xmg.manage.base.query.IplogQueryObject;
import com.xmg.manage.base.query.PageResult;
import com.xmg.manage.base.service.IIplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IplogServiceImpl implements IIplogService {

	@Autowired
	private IplogMapper iplogMapper;

	@Override
	public PageResult query(IplogQueryObject qo) {
		int count = this.iplogMapper.queryForCount(qo);
		if (count > 0) {
			List<Iplog> list = this.iplogMapper.query(qo);
			return new PageResult(list, count, qo.getCurrentPage(),
					qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}

}
