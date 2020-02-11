package com.xmg.manage.business.mapper;

import com.xmg.manage.business.domain.UserBankinfo;

public interface UserBankinfoMapper {

	int insert(UserBankinfo record);

	UserBankinfo selectByUser(Long userid);

}