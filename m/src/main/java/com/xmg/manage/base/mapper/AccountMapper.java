package com.xmg.manage.base.mapper;

import com.xmg.manage.base.domain.Account;

import java.util.List;

public interface AccountMapper {
	
	int insert(Account record);

	Account selectByPrimaryKey(Long id);

	int updateByPrimaryKey(Account record);
	
	List<Account> selectAll();
}