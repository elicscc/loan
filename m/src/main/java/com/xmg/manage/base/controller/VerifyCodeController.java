package com.xmg.manage.base.controller;

import com.xmg.manage.base.service.IVerifyCodeService;
import com.xmg.manage.base.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验证码相关的controller
 * 
 * @author Administrator
 * 
 */
//@Controller
public class VerifyCodeController {

	@Autowired
	private IVerifyCodeService verifyCodeService;

	@RequestMapping("sendVerifyCode")
	@ResponseBody
	public JSONResult sendVerifyCode(String phoneNumber) {
		JSONResult json = new JSONResult();
		try {
			verifyCodeService.sendVerifyCode(phoneNumber);
		} catch (RuntimeException re) {
			json.setMsg(re.getMessage());
			json.setSuccess(false);
		}
		return json;
	}

}
