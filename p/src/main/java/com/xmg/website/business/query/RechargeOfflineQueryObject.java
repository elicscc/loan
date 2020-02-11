package com.xmg.website.business.query;

import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

import com.xmg.website.base.query.AuditQueryObject;

/**
 * 线下充值查询
 * 
 * @author Administrator
 * 
 */
@Getter
@Setter
public class RechargeOfflineQueryObject extends AuditQueryObject {

	private Long applierId;
	private long bankInfoId = -1;// 按照开户行查询
	private String tradeCode;

	public String getTradeCode() {
		return StringUtils.hasLength(tradeCode) ? tradeCode : null;
	}
}
