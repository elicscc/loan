package com.xmg.website.base.controller;

import com.xmg.website.base.domain.RealAuth;
import com.xmg.website.base.domain.Userinfo;
import com.xmg.website.base.service.IRealAuthService;
import com.xmg.website.base.service.IUserinfoService;
import com.xmg.website.base.util.JSONResult;
import com.xmg.website.base.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

/**
 * 实名认证控制
 * 
 * @author Administrator
 * 
 */
@Controller
public class RealAuthController {

	@Autowired
	private IUserinfoService userinfoService;

	@Autowired
	private IRealAuthService realAuthService;

	@Autowired
	private ServletContext servletContext;

	//@RequireLogin
	@RequestMapping("realAuth")
	public String realAuth(Model model) {
		// 1,得到当前Userinfo
		Userinfo current = this.userinfoService.getCurrent();
		// 2,如果用户已经实名认证,
		if (current.getIsRealAuth()) {
			// 根据userinfo上的realAuthId得到实名认证对象,并放到model;
			RealAuth ra = this.realAuthService.get(current.getRealAuthId());
			System.out.println(ra.getRealName());
			System.out.println(ra.getIdNumber());
			model.addAttribute("realAuth", ra);
			// auditing=false
			model.addAttribute("auditing", false);
			model.addAttribute("userinfo", this.userinfoService.getCurrent());
			return "realAuth_result";
		} else {
			// 3,如果用户没有实名认证,
			if (current.getRealAuthId() != null) {
				model.addAttribute("auditing", true);
				return "realAuth_result";
			} else {
				return "realAuth";
			}
		}
	}

	/**
	 * 千万不要加requiredLogin
	 * 
	 * @param file
	 */
	@RequestMapping("realAuthUpload")
	@ResponseBody
	public String realAuthUpload(MultipartFile file) {
		// 先得到basepath
		String basePath = servletContext.getRealPath("/upload");
		String fileName = UploadUtil.upload(file, basePath);
		return "/upload/" + fileName;
	}

	/**
	 * 申请实名认证
	 */
	//@RequireLogin
	@RequestMapping("realAuth_save")
	@ResponseBody
	public JSONResult realAuthSave(RealAuth realAuth) {
		this.realAuthService.apply(realAuth);
		return new JSONResult();
	}

}
