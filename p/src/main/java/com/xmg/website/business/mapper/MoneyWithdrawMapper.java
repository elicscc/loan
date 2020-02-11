package com.xmg.website.business.mapper;

import java.util.List;

import com.xmg.website.business.domain.MoneyWithdraw;
import com.xmg.website.business.query.MoneyWithdrawQueryObject;

public interface MoneyWithdrawMapper {

	int insert(MoneyWithdraw record);

	MoneyWithdraw selectByPrimaryKey(Long id);

	int updateByPrimaryKey(MoneyWithdraw record);

	int queryForCount(MoneyWithdrawQueryObject qo);

	List<MoneyWithdraw> query(MoneyWithdrawQueryObject qo);
}