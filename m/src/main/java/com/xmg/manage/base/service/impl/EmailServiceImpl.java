package com.xmg.manage.base.service.impl;

import com.xmg.manage.base.domain.RealAuth;
import com.xmg.manage.base.event.RealAuthSuccessEvent;
import com.xmg.manage.base.service.IEmailService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService,
		ApplicationListener<RealAuthSuccessEvent> {

	@Override
	public void onApplicationEvent(RealAuthSuccessEvent event) {
		this.sendEmail(event.getRealAuth());
	}

	private void sendEmail(RealAuth realAuth) {
		//System.out.println("用户" + realAuth.getApplier().getUsername()+ " 实名认证成功,发送邮件");
	}

}
