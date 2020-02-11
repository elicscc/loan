package com.xmg.manage.business.mapper;

import com.xmg.manage.business.domain.BidRequest;
import com.xmg.manage.business.query.BidRequestQueryObject;

import java.util.List;

public interface BidRequestMapper {

	int insert(BidRequest record);

	BidRequest selectByPrimaryKey(Long id);

	int updateByPrimaryKey(BidRequest record);

	int queryForCount(BidRequestQueryObject qo);

	List<BidRequest> query(BidRequestQueryObject qo);
}