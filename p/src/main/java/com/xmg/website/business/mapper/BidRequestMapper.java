package com.xmg.website.business.mapper;

import java.util.List;

import com.xmg.website.business.domain.BidRequest;
import com.xmg.website.business.query.BidRequestQueryObject;

public interface BidRequestMapper {

	int insert(BidRequest record);

	BidRequest selectByPrimaryKey(Long id);

	int updateByPrimaryKey(BidRequest record);

	int queryForCount(BidRequestQueryObject qo);

	List<BidRequest> query(BidRequestQueryObject qo);
}