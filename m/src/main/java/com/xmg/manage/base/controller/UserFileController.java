package com.xmg.manage.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.manage.base.query.UserFileQueryObject;
import com.xmg.manage.base.service.IUserFileService;
import com.xmg.manage.base.util.JSONResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * 风控资料审核
 * 
 * @author Administrator
 * 
 */
@Controller
public class UserFileController {
	
	@Autowired
	private IUserFileService userFileService;
	
	@RequestMapping("userFileAuth")
	public String userFileAuthList(@ModelAttribute("qo")UserFileQueryObject qo,Model model){
		model.addAttribute("pageResult",this.userFileService.query(qo));
		return "userFileAuth/list";
	}
	
	/**
	 * 审核
	 */
	@RequestMapping("userFile_audit")
	@ResponseBody
	public JSONResult audit(Long id,int score,String remark,int state){
		this.userFileService.audit(id,score,remark,state);
		return new JSONResult();
	}

}
