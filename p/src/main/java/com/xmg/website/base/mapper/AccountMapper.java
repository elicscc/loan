package com.xmg.website.base.mapper;

import java.util.List;

import com.xmg.website.base.domain.Account;

public interface AccountMapper {
	
	int insert(Account record);

	Account selectByPrimaryKey(Long id);

	int updateByPrimaryKey(Account record);
	
	List<Account> selectAll();
}