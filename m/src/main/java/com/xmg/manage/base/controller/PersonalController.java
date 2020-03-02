package com.xmg.manage.base.controller;

import com.xmg.manage.base.domain.Logininfo;
import com.xmg.manage.base.service.IAccountService;
import com.xmg.manage.base.service.IUserinfoService;
import com.xmg.manage.base.util.JSONResult;
import com.xmg.manage.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个人中心
 * 
 * @author Administrator
 * 
 */
@Controller
public class PersonalController {

	@Autowired
	private IUserinfoService userinfoService;

	@Autowired
	private IAccountService accountService;

	//@RequireLogin
	@RequestMapping("personal")
	public String personalCenter(Model model) {
		Logininfo current = UserContext.getCurrent();
		model.addAttribute("userinfo", userinfoService.get(current.getId()));
		model.addAttribute("account", accountService.get(current.getId()));
		return "personal";
	}

	/**
	 * 绑定手机
	 * 
	 * @param phoneNumber
	 * @param verifyCode
	 * @return
	 */
	//@RequireLogin
	@RequestMapping("bindPhone")
	@ResponseBody
	public JSONResult bindPhone(String phoneNumber, String verifyCode) {
		JSONResult json = new JSONResult();
		try {
			this.userinfoService.bindPhone(phoneNumber, verifyCode);
		} catch (RuntimeException re) {
			json.setSuccess(false);
			json.setMsg(re.getMessage());
		}
		return json;
	}

	/**
	 * 发送绑定邮箱邮件
	 * 
	 * @param email
	 * @return
	 */
	//@RequireLogin
	@RequestMapping("sendEmail")
	@ResponseBody
	public JSONResult sendEmail(String email) {
		JSONResult json = new JSONResult();
		try {
			this.userinfoService.sendVerifyEmail(email);
		} catch (RuntimeException re) {
			json.setSuccess(false);
			json.setMsg(re.getMessage());
		}
		return json;
	}

	/**
	 * 执行邮箱绑定
	 */
	@RequestMapping("bindEmail")
	public String bindEmail(String key, Model model) {
		try {
			this.userinfoService.bindEmail(key);
			model.addAttribute("success", true);
		} catch (RuntimeException re) {
			model.addAttribute("success", false);
			//System.out.println(re.getMessage());
			model.addAttribute("msg", re.getMessage());
		}
		return "checkmail_result";
	}
}
