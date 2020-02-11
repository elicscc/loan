package com.xmg.website.business.mapper;

import com.xmg.website.business.domain.Bid;
import java.util.List;

public interface BidMapper {

	int insert(Bid record);

	Bid selectByPrimaryKey(Long id);

	List<Bid> selectAll();

}