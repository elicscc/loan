package com.xmg.manage.base.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 存放验证码相关内容,这个对象是放在session中的
 * 
 * @author Administrator
 * 
 */
@Getter
@Setter
public class VerifyCodeVO {
	
	private String verifyCode;//验证码
	private String phoneNumber;//发送验证码的手机号
	private Date lastSendTime;//最近成功发送时间

}
