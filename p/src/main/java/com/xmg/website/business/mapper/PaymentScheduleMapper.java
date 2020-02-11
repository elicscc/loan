package com.xmg.website.business.mapper;

import java.util.List;

import com.xmg.website.business.domain.PaymentSchedule;
import com.xmg.website.business.query.PaymentScheduleQueryObject;

public interface PaymentScheduleMapper {

	int insert(PaymentSchedule record);

	PaymentSchedule selectByPrimaryKey(Long id);

	int updateByPrimaryKey(PaymentSchedule record);

	int queryForCount(PaymentScheduleQueryObject qo);

	List<PaymentSchedule> query(PaymentScheduleQueryObject qo);
}