package com.xmg.website.base.service.impl;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.xmg.website.base.domain.RealAuth;
import com.xmg.website.base.event.RealAuthSuccessEvent;
import com.xmg.website.base.event.RechargeOfflineSuccessEvent;
import com.xmg.website.base.service.ISmsService;
import com.xmg.website.business.domain.RechargeOffline;

@Service
public class SmsServiceImpl implements ISmsService,
		ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof RealAuthSuccessEvent) {
			RealAuthSuccessEvent e = (RealAuthSuccessEvent) event;
			this.sendSms(e.getRealAuth());
		} else if (event instanceof RechargeOfflineSuccessEvent) {
			RechargeOfflineSuccessEvent e = (RechargeOfflineSuccessEvent) event;
			this.sendSms(e.getRo());
		}
	}

	private void sendSms(RechargeOffline ro) {
		System.out.println("充值成功发送短信");
	}

	private void sendSms(RealAuth realAuth) {
		System.out.println("用户" + realAuth.getApplier().getUsername()
				+ " 实名认证成功,发送短信");
	}

}
