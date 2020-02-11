package com.xmg.website.base.mapper;

import com.xmg.website.base.domain.MailVerify;

public interface MailVerifyMapper {

	int insert(MailVerify record);

	/**
	 * 根据UUID来查询对应的邮箱验证对象
	 * 
	 * @param uuid
	 * @return
	 */
	MailVerify selectByUUID(String uuid);

}