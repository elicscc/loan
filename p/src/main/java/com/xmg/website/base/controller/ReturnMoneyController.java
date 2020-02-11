package com.xmg.website.base.controller;

import com.xmg.website.base.service.IAccountService;
import com.xmg.website.base.util.JSONResult;
import com.xmg.website.base.util.UserContext;
import com.xmg.website.business.query.PaymentScheduleQueryObject;
import com.xmg.website.business.service.IBidRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 还款
 * 
 * @author Administrator
 * 
 */
@Controller
public class ReturnMoneyController {

	@Autowired
	private IBidRequestService bidRequestService;

	@Autowired
	private IAccountService accountService;

	/**
	 * 还款列表
	 */
	//@RequireLogin
	@RequestMapping("borrowBidReturn_list")
	public String returnMoneyList(
			@ModelAttribute("qo") PaymentScheduleQueryObject qo, Model model) {
		qo.setUserid(UserContext.getCurrent().getId());
		model.addAttribute("account", this.accountService.getCurrent());
		model.addAttribute("pageResult",
				this.bidRequestService.queryPaymentSchedule(qo));
		return "returnmoney_list";
	}

	/**
	 * 立刻还款
	 */
	//@RequireLogin
	@RequestMapping("returnMoney")
	@ResponseBody
	public JSONResult returnMoney(Long id) {
		this.bidRequestService.doReturnMoney(id);
		return new JSONResult();
	}

}
