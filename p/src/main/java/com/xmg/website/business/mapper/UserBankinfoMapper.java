package com.xmg.website.business.mapper;

import com.xmg.website.business.domain.UserBankinfo;

public interface UserBankinfoMapper {

	int insert(UserBankinfo record);

	UserBankinfo selectByUser(Long userid);

}