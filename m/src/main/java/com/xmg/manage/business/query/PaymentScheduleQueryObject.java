package com.xmg.manage.business.query;

import com.xmg.manage.base.query.AuditQueryObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 还款对象查询对象
 * 
 * @author Administrator
 * 
 */
@Setter
@Getter
public class PaymentScheduleQueryObject extends AuditQueryObject {

	private Long userid;// 查看指定用户的还款

	private Long bidRequestId;// 所属的借款

}
