package com.xmg.manage.business.query;

import com.xmg.manage.base.query.AuditQueryObject;
import lombok.Getter;
import lombok.Setter;

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
