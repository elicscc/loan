package com.xmg.manage.business.mapper;

import com.xmg.manage.business.domain.Bid;

import java.util.List;

public interface BidMapper {

	int insert(Bid record);

	Bid selectByPrimaryKey(Long id);

	List<Bid> selectAll();

}