package com.xmg.manage.base.mapper;

import com.xmg.manage.base.domain.MailVerify;

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