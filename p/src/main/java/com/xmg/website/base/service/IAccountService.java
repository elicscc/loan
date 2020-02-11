package com.xmg.website.base.service;

import com.xmg.website.base.domain.Account;

/**
 * 账户相关服务
 * 
 * @author Administrator
 * 
 */
public interface IAccountService {

	/**
	 * 记住,写完mapper之后立刻写service,因为这个update是支持乐观锁的
	 * 
	 * @param account
	 */
	void update(Account account);

	void add(Account account);

	Account get(Long id);

	/**
	 * 得到当前登陆用户对应的账户信息
	 * 
	 * @return
	 */
	Account getCurrent();

	/**
	 * 定时检查账户篡改
	 */
	void checkAccounts();
}
