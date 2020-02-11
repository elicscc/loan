package com.xmg.manage.base.service;

/**
 * 手机验证码相关服务
 * 
 * @author Administrator
 * 
 */
public interface IVerifyCodeService {

	/**
	 * 给指定的手机发送验证码
	 * 
	 * @param phoneNumber
	 */
	void sendVerifyCode(String phoneNumber);

	/**
	 * 验证手机验证码
	 * 
	 * @param phoneNumber
	 * @param verifyCode
	 * @return
	 */
	boolean verify(String phoneNumber, String verifyCode);
}
