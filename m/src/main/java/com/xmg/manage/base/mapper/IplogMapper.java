package com.xmg.manage.base.mapper;

import com.xmg.manage.base.domain.Iplog;
import com.xmg.manage.base.query.IplogQueryObject;

import java.util.List;

public interface IplogMapper {

	int insert(Iplog record);

	/**
	 * 高级查询总数
	 * 
	 * @param qo
	 * @return
	 */
	int queryForCount(IplogQueryObject qo);

	/**
	 * 查询当前页数据
	 * 
	 * @param qo
	 * @return
	 */
	List<Iplog> query(IplogQueryObject qo);
}