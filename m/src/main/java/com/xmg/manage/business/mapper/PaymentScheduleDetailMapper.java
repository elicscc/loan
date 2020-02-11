package com.xmg.manage.business.mapper;

import com.xmg.manage.business.domain.PaymentScheduleDetail;

public interface PaymentScheduleDetailMapper {

    int insert(PaymentScheduleDetail record);

    PaymentScheduleDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PaymentScheduleDetail record);
}