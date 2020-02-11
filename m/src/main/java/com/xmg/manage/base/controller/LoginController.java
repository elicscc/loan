package com.xmg.manage.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.manage.base.domain.Logininfo;
import com.xmg.manage.base.service.ILogininfoService;
import com.xmg.manage.base.util.JSONResult;

/**
 * 后台登陆
 * 
 * @author Administrator
 * 
 */
@Controller
public class LoginController {

	@Autowired
	private ILogininfoService logininfoService;

	/**
	 * 后台登陆
	 * 
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public JSONResult login(String username, String password,
			HttpServletRequest request) {
		JSONResult json = new JSONResult();
		Logininfo current = this.logininfoService.login(username, password,
				request.getRemoteAddr(), Logininfo.USER_MANAGER);
		if (current == null) {
			json.setSuccess(false);
			json.setMsg("用户名或者密码错误!");
		}
		return json;
	}

	/**
	 * 后台首页
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "main";
	}
}
