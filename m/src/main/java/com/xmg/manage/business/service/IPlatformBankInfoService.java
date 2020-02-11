package com.xmg.manage.business.service;

import com.xmg.manage.base.query.PageResult;
import com.xmg.manage.business.domain.PlatformBankInfo;
import com.xmg.manage.business.query.PlatformBankInfoQueryObject;

import java.util.List;

/**
 * 平台账户服务
 */
public interface IPlatformBankInfoService {

	PageResult query(PlatformBankInfoQueryObject qo);

	void saveOrUpdate(PlatformBankInfo bankInfo);

	List<PlatformBankInfo> listAll();
}
