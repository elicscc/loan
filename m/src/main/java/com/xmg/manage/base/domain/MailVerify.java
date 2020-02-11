package com.xmg.manage.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 邮箱验证对象
 * 
 * @author Administrator
 * 
 */
@Getter
@Setter
public class MailVerify extends BaseDomain {

	private Long userinfoId;// 谁在发送绑定邮箱邮件
	private String email;//
	private String uuid;
	private Date sendDate;// 发送邮件的时间
}
