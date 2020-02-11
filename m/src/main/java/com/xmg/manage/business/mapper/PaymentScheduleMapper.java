package com.xmg.manage.business.mapper;

import com.xmg.manage.business.domain.PaymentSchedule;
import com.xmg.manage.business.query.PaymentScheduleQueryObject;

import java.util.List;

public interface PaymentScheduleMapper {

	int insert(PaymentSchedule record);

	PaymentSchedule selectByPrimaryKey(Long id);

	int updateByPrimaryKey(PaymentSchedule record);

	int queryForCount(PaymentScheduleQueryObject qo);

	List<PaymentSchedule> query(PaymentScheduleQueryObject qo);
}