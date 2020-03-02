package com.xmg.manage.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 平台账户管理
 * 
 * @author Administrator
 * 
 */
@Controller
public class PlatformBankinfoController {

	@Autowired
	private com.xmg.manage.business.service.IPlatformBankInfoService platformBankInfoService;

	@RequestMapping("companyBank_list")
	public String platformBankinfoList(
			@ModelAttribute("qo") com.xmg.manage.business.query.PlatformBankInfoQueryObject qo, Model model) {
		model.addAttribute("pageResult", this.platformBankInfoService.query(qo));
		return "platformbankinfo/list";
	}

	/**
	 * 修改或保存
	 */
	@RequestMapping("companyBank_update")
	public String update(com.xmg.manage.business.domain.PlatformBankInfo bankInfo) {
		this.platformBankInfoService.saveOrUpdate(bankInfo);
		return "redirect:/companyBank_list.do";
	}

}
