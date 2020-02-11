package com.xmg.website.base.event;

import lombok.Getter;

import org.springframework.context.ApplicationEvent;

import com.xmg.website.business.domain.RechargeOffline;

@Getter
public class RechargeOfflineSuccessEvent extends ApplicationEvent {

	private RechargeOffline ro;

	public RechargeOfflineSuccessEvent(Object source, RechargeOffline ro) {
		super(source);
		this.ro = ro;
	}

}
