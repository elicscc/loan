package com.xmg.website.business.query;

import lombok.Getter;
import lombok.Setter;

import com.xmg.website.base.query.AuditQueryObject;

/**
 * 提现申请查询对象
 * 
 * @author Administrator
 * 
 */
@Getter
@Setter
public class MoneyWithdrawQueryObject extends AuditQueryObject {

	private Long applierId;
}
