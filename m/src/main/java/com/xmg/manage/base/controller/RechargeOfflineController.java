package com.xmg.manage.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.manage.base.util.JSONResult;


/**
 * 线下充值审核
 * 
 * @author Administrator
 * 
 */
@Controller
public class RechargeOfflineController {
	@Autowired
	private com.xmg.manage.business.service.IRechargeOfflineService rechargeOfflineService;

	@Autowired
	private com.xmg.manage.business.service.IPlatformBankInfoService platformBankInfoService;

	@RequestMapping("rechargeOffline")
	public String rechargeOffline(
			@ModelAttribute("qo") com.xmg.manage.business.query.RechargeOfflineQueryObject qo, Model model) {
		model.addAttribute("banks", this.platformBankInfoService.listAll());
		model.addAttribute("pageResult", this.rechargeOfflineService.query(qo));
		return "rechargeoffline/list";
	}

	/**
	 * 线下充值审核
	 */
	@RequestMapping("rechargeOffline_audit")
	@ResponseBody
	public JSONResult audit(Long id, String remark, int state) {
		this.rechargeOfflineService.audit(id, remark, state);
		return new JSONResult();
	}

}
