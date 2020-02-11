package com.xmg.manage.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.manage.base.util.JSONResult;


/**
 * 提现申请审核
 * 
 * @author Administrator
 * 
 */
@Controller
public class MoneyWithdrawController {

	@Autowired
	private com.xmg.manage.business.service.IMoneyWithdrawService moneyWithdrawService;

	@RequestMapping("moneyWithdraw")
	public String moneyWithdrawList(
			@ModelAttribute("qo") com.xmg.manage.business.query.MoneyWithdrawQueryObject qo, Model model) {
		model.addAttribute("pageResult", this.moneyWithdrawService.query(qo));
		return "moneywithdraw/list";
	}

	@RequestMapping("moneyWithdraw_audit")
	@ResponseBody
	public JSONResult audit(Long id, String remark, int state) {
		this.moneyWithdrawService.audit(id, remark, state);
		return new JSONResult();
	}

}
