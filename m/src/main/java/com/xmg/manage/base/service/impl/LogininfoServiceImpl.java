package com.xmg.manage.base.service.impl;

import com.xmg.manage.base.domain.Account;
import com.xmg.manage.base.domain.Iplog;
import com.xmg.manage.base.domain.Logininfo;
import com.xmg.manage.base.domain.Userinfo;
import com.xmg.manage.base.mapper.IplogMapper;
import com.xmg.manage.base.mapper.LogininfoMapper;
import com.xmg.manage.base.service.IAccountService;
import com.xmg.manage.base.service.ILogininfoService;
import com.xmg.manage.base.service.IUserinfoService;
import com.xmg.manage.base.util.BidConst;
import com.xmg.manage.base.util.MD5;
import com.xmg.manage.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogininfoServiceImpl implements ILogininfoService {

	@Autowired
	private LogininfoMapper logininfoMapper;

	@Autowired
	private IUserinfoService userinfoService;

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IplogMapper iplogMapper;

	@Override
	public void register(String username, String password) {
		// 判断用户名是否存在
		int count = this.logininfoMapper.getCountByUsername(username);
		// 如果不存在,设值并保存这个对象
		if (count <= 0) {
			Logininfo li = new Logininfo();
			li.setUsername(username);
			li.setPassword(MD5.encode(password));
			li.setState(Logininfo.STATE_NORMAL);
			li.setUserType(Logininfo.USER_CLIENT);
			this.logininfoMapper.insert(li);

			// 初始化账户信息和userinfo
			Account account = new Account();
			account.setId(li.getId());
			this.accountService.add(account);

			Userinfo ui = new Userinfo();
			ui.setId(li.getId());
			this.userinfoService.add(ui);
		} else {
			// 如果存在,直接抛错
			throw new RuntimeException("用户名已经存在!");
		}
	}

	@Override
	public boolean checkUsername(String username) {
		return this.logininfoMapper.getCountByUsername(username) > 0;
	}

	@Override
	public Logininfo login(String username, String password, String ip,
                           int userType) {
		Logininfo current = logininfoMapper.login(username,
				MD5.encode(password), userType);
		Iplog iplog = new Iplog();
		iplog.setIp(ip);
		iplog.setLoginTime(new Date());
		iplog.setUserName(username);
		iplog.setUserType(userType);

		if (current != null) {
			// 放到UserContext
			UserContext.putCurrent(current);
			iplog.setState(Iplog.STATE_SUCCESS);
		} else {
			iplog.setState(Iplog.STATE_FAILED);
		}
		iplogMapper.insert(iplog);
		return current;
	}

	@Override
	public void initAdmin() {
		//查询当前是否有管理员;
		int count=this.logininfoMapper.countByUserType(Logininfo.USER_MANAGER);
		//如果没有就创建一个默认的管理员;
		if(count==0){
			Logininfo admin=new Logininfo();
			admin.setUsername(BidConst.DEFAULT_ADMIN_NAME);
			admin.setPassword(MD5.encode(BidConst.DEFAULT_ADMIN_PASSWORD));
			admin.setState(Logininfo.STATE_NORMAL);
			admin.setUserType(Logininfo.USER_MANAGER);
			this.logininfoMapper.insert(admin);
		}
	}

}
