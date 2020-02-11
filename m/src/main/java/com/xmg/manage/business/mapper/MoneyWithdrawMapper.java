package com.xmg.manage.business.mapper;

import com.xmg.manage.business.domain.MoneyWithdraw;
import com.xmg.manage.business.query.MoneyWithdrawQueryObject;

import java.util.List;

public interface MoneyWithdrawMapper {

	int insert(MoneyWithdraw record);

	MoneyWithdraw selectByPrimaryKey(Long id);

	int updateByPrimaryKey(MoneyWithdraw record);

	int queryForCount(MoneyWithdrawQueryObject qo);

	List<MoneyWithdraw> query(MoneyWithdrawQueryObject qo);
}