package com.xmg.manage.business.service;

import com.xmg.manage.base.query.PageResult;
import com.xmg.manage.business.domain.BidRequest;
import com.xmg.manage.business.domain.BidRequestAuditHistory;
import com.xmg.manage.business.query.BidRequestQueryObject;
import com.xmg.manage.business.query.PaymentScheduleQueryObject;

import java.math.BigDecimal;
import java.util.List;

/**
 * 借款相关
 * 
 * @author Administrator
 * 
 */
public interface IBidRequestService {

	void update(BidRequest bidRequest);

	BidRequest get(Long id);

	/**
	 * 判断用户是否具有申请借款的权利
	 * 
	 * @return
	 */
	boolean canApplyBidRequeset(Long logininfoId);

	/**
	 * 申请借款
	 * 
	 * @param bidRequest
	 */
	void apply(BidRequest bidRequest);

	/**
	 * 根据一个标查询该标的审核历史
	 * 
	 * @param id
	 * @return
	 */
	List<BidRequestAuditHistory> listAuditHistoryByBidRequest(Long id);

	PageResult query(BidRequestQueryObject qo);

	/**
	 * 发标前审核
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 */
	void publishAudit(Long id, String remark, int state);

	/**
	 * 查询首页借款列表
	 * 
	 * @return
	 */
	List<BidRequest> listIndex(int size);

	/**
	 * 投标
	 * 
	 * @param bidRequestId
	 * @param amount
	 */
	void bid(Long bidRequestId, BigDecimal amount);

	/**
	 * 满标一审
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 */
	void fullAudit1(Long id, String remark, int state);

	/**
	 * 满标二审
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 */
	void fullAudit2(Long id, String remark, int state);

	PageResult queryPaymentSchedule(PaymentScheduleQueryObject qo);

	/**
	 * 借款人还钱
	 * 
	 * @param id
	 */
	void doReturnMoney(Long id);
}
