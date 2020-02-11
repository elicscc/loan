package com.xmg.manage.business.service.impl;

import com.xmg.manage.base.domain.Userinfo;
import com.xmg.manage.base.service.IUserinfoService;
import com.xmg.manage.base.util.BitStatesUtils;
import com.xmg.manage.base.util.UserContext;
import com.xmg.manage.business.domain.UserBankinfo;
import com.xmg.manage.business.mapper.UserBankinfoMapper;
import com.xmg.manage.business.service.IUserBankinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBankinfoServiceImpl implements IUserBankinfoService {

	@Autowired
	private UserBankinfoMapper userBankinfoMapper;

	@Autowired
	private IUserinfoService userinfoService;

	@Override
	public UserBankinfo getByUser(Long id) {
		return this.userBankinfoMapper.selectByUser(id);
	}

	@Override
	public void bind(UserBankinfo bankInfo) {
		// 判断当前用户没有绑定;
		Userinfo current = this.userinfoService.getCurrent();
		if (!current.getIsBindBank() && current.getIsRealAuth()) {
			// 创建一个UserBankinfo,设置相关属性;
			UserBankinfo b = new UserBankinfo();
			b.setAccountName(current.getRealName());
			b.setAccountNumber(bankInfo.getAccountNumber());
			b.setBankForkName(bankInfo.getBankForkName());
			b.setBankName(bankInfo.getBankName());
			b.setLogininfo(UserContext.getCurrent());
			this.userBankinfoMapper.insert(b);
			// 修改用户状态码
			current.addState(BitStatesUtils.OP_BIND_BANKINFO);
			this.userinfoService.update(current);
		}
	}
	
	

}
