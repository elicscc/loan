package com.xmg.website.base.controller;

import com.xmg.website.base.util.JSONResult;
import com.xmg.website.base.util.UserContext;
import com.xmg.website.business.domain.RechargeOffline;
import com.xmg.website.business.query.RechargeOfflineQueryObject;
import com.xmg.website.business.service.IPlatformBankInfoService;
import com.xmg.website.business.service.IRechargeOfflineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前台的线下充值
 * 
 * @author Administrator
 * 
 */
@Controller
public class RechargeOfflineController {

	@Autowired
	private IPlatformBankInfoService platformBankInfoService;

	@Autowired
	private IRechargeOfflineService rechargeOfflineService;

	/**
	 * 导向到线下充值页面
	 * 
	 * @param model
	 * @return
	 */
	//@RequireLogin
	@RequestMapping("recharge")
	public String recharge(Model model) {
		model.addAttribute("banks", this.platformBankInfoService.listAll());
		return "recharge";
	}

	//@RequireLogin
	@RequestMapping("recharge_list")
	public String rechargeList(
			@ModelAttribute("qo") RechargeOfflineQueryObject qo, Model model) {
		qo.setApplierId(UserContext.getCurrent().getId());
		model.addAttribute("pageResult", this.rechargeOfflineService.query(qo));
		return "recharge_list";
	}

	/**
	 * 提交线下充值单
	 * 
	 * @return
	 */
	//@RequireLogin
	@RequestMapping("recharge_save")
	@ResponseBody
	public JSONResult rechargeApply(RechargeOffline recharge) {
		this.rechargeOfflineService.apply(recharge);
		return new JSONResult();
	}
}
