package com.xmg.manage.base.service.impl;

import com.xmg.manage.base.domain.Account;
import com.xmg.manage.base.mapper.AccountMapper;
import com.xmg.manage.base.service.IAccountService;
import com.xmg.manage.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public void update(Account account) {
		int ret = this.accountMapper.updateByPrimaryKey(account);
		if (ret == 0) {
			throw new RuntimeException("乐观锁失败,Account:" + account.getId());
		}
	}

	@Override
	public void add(Account account) {
		this.accountMapper.insert(account);
	}

	@Override
	public Account get(Long id) {
		Account account = this.accountMapper.selectByPrimaryKey(id);
		if (!account.checkVerifyCode()) {
			throw new RuntimeException("账户 :" + id + " 资金数据异常,阻止业务继续进行");
		}
		return account;
	}

	@Override
	public Account getCurrent() {
		return this.get(UserContext.getCurrent().getId());
	}

	@Override
	public void checkAccounts() {
		List<Account> accounts = this.accountMapper.selectAll();
		for (Account account : accounts) {
			if (!account.checkVerifyCode()) {
				System.out.println("账户:" + account.getId() + " 资金异常!");
			}
		}
	}

}
