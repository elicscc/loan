package com.xmg.website.business.mapper;

import com.xmg.website.business.domain.PlatformBankInfo;
import com.xmg.website.business.query.PlatformBankInfoQueryObject;

import java.util.List;

public interface PlatformBankInfoMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PlatformBankInfo record);

	PlatformBankInfo selectByPrimaryKey(Long id);

	List<PlatformBankInfo> selectAll();

	int updateByPrimaryKey(PlatformBankInfo record);

	int queryForCount(PlatformBankInfoQueryObject qo);

	List<PlatformBankInfo> query(PlatformBankInfoQueryObject qo);
}