package com.xmg.manage.base.service;

import com.xmg.manage.base.domain.Logininfo;

/**
 * 登陆相关服务
 * 
 * @author Administrator
 * 
 */
public interface ILogininfoService {

	/**
	 * 用户注册
	 * 
	 * @param username
	 * @param password
	 */
	void register(String username, String password);

	/**
	 * 检查用户名是否存在 如果存在,返回true 如果不存在,返回false
	 * 
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);

	/**
	 * 用户登陆
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	Logininfo login(String username, String password, String ip, int userType);

	/**
	 * 初始化第一个管理员
	 */
	void initAdmin();
}
