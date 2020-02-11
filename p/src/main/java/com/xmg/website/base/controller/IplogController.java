package com.xmg.website.base.controller;

import com.xmg.website.base.query.IplogQueryObject;
import com.xmg.website.base.service.IIplogService;
import com.xmg.website.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆日志
 * 
 * @author Administrator
 * 
 */
@Controller
public class IplogController {

	@Autowired
	private IIplogService iplogService;

	/**
	 * 个人用户登陆记录列表
	 * @param qo
	 * @param model
	 * @return
	 */
	//@RequireLogin
	@RequestMapping("ipLog")
	public String iplogList(@ModelAttribute("qo")IplogQueryObject qo, Model model) {
		qo.setUsername(UserContext.getCurrent().getUsername());
		model.addAttribute("pageResult",this.iplogService.query(qo));
		return "iplog_list";
	}

}
