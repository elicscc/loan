package com.xmg.manage.business.mapper;

import com.xmg.manage.business.domain.BidRequestAuditHistory;

import java.util.List;

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