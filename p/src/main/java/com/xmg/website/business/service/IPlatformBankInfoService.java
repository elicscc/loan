package com.xmg.website.business.service;

import java.util.List;

import com.xmg.website.base.query.PageResult;
import com.xmg.website.business.domain.PlatformBankInfo;
import com.xmg.website.business.query.PlatformBankInfoQueryObject;

/**
 * 平台账户服务
 */
public interface IPlatformBankInfoService {

	PageResult query(PlatformBankInfoQueryObject qo);

	void saveOrUpdate(PlatformBankInfo bankInfo);

	List<PlatformBankInfo> listAll();
}
