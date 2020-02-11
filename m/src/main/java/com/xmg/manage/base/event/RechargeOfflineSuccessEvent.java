package com.xmg.manage.base.event;

import com.xmg.manage.business.domain.RechargeOffline;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class RechargeOfflineSuccessEvent extends ApplicationEvent {

	private RechargeOffline ro;

	public RechargeOfflineSuccessEvent(Object source, RechargeOffline ro) {
		super(source);
		this.ro = ro;
	}

}
