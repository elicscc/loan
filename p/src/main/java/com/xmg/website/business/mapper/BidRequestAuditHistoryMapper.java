package com.xmg.website.business.mapper;

import java.util.List;

import com.xmg.website.business.domain.BidRequestAuditHistory;

public interface BidRequestAuditHistoryMapper {

	int insert(BidRequestAuditHistory record);

	BidRequestAuditHistory selectByPrimaryKey(Long id);

	/**
	 * 根据一个标查询该标的审核历史
	 * 
	 * @param id
	 * @return
	 */
	List<BidRequestAuditHistory> listByBidRequest(Long id);

}