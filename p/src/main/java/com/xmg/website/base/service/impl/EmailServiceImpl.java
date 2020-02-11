package com.xmg.website.base.service.impl;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.xmg.website.base.domain.RealAuth;
import com.xmg.website.base.event.RealAuthSuccessEvent;
import com.xmg.website.base.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService,
		ApplicationListener<RealAuthSuccessEvent> {

	@Override
	public void onApplicationEvent(RealAuthSuccessEvent event) {
		this.sendEmail(event.getRealAuth());
	}

	private void sendEmail(RealAuth realAuth) {
		System.out.println("用户" + realAuth.getApplier().getUsername()
				+ " 实名认证成功,发送邮件");
	}

}
