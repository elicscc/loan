package com.xmg.manage.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.manage.base.query.RealAuthQueryObject;
import com.xmg.manage.base.service.IRealAuthService;
import com.xmg.manage.base.util.JSONResult;

/**
 * 实名认证审核相关
 * 
 * @author Administrator
 * 
 */
@Controller
public class RealAuthController {

	@Autowired
	private IRealAuthService realAuthService;

	@RequestMapping("realAuth")
	public String realAuth(@ModelAttribute("qo") RealAuthQueryObject qo,
			Model model) {
		model.addAttribute("pageResult", this.realAuthService.query(qo));
		return "realAuth/list";
	}
	
	/**
	 * 实名认证审核
	 */
	@RequestMapping("realAuth_audit")
	@ResponseBody
	public JSONResult realAuthAudit(Long id,String remark,int state){
		this.realAuthService.audit(id,remark,state);
		return new JSONResult();
	}
}
