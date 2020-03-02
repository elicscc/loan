package com.xmg.manage.base.controller;

import com.xmg.manage.base.domain.Logininfo;
import com.xmg.manage.base.domain.Userinfo;
import com.xmg.manage.base.query.UserFileQueryObject;
import com.xmg.manage.base.service.IAccountService;
import com.xmg.manage.base.service.IRealAuthService;
import com.xmg.manage.base.service.IUserFileService;
import com.xmg.manage.base.service.IUserinfoService;
import com.xmg.manage.base.util.BidConst;
import com.xmg.manage.base.util.UserContext;
import com.xmg.manage.business.domain.BidRequest;
import com.xmg.manage.business.service.IBidRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 借款申请相关的控制器
 * 
 * @author Administrator
 * 
 */
@Controller
public class BorrowController {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IUserinfoService userinfoService;

	@Autowired
	private IBidRequestService bidRequestService;

	@Autowired
	private IRealAuthService realAuthService;

	@Autowired
	private IUserFileService userFileService;

	/**
	 * 导向到我要借款首页
	 * 
	 * @return
	 */
	@RequestMapping("borrow")
	public String borrowIndex(Model model) {
		Logininfo current = UserContext.getCurrent();
		// 如果没有登陆,直接返回到borrow.html静态页面
		if (current == null) {
			return "redirect:borrow.html";
		} else {
			model.addAttribute("account", this.accountService.getCurrent());
			model.addAttribute("userinfo", this.userinfoService.getCurrent());
			model.addAttribute("creditBorrowScore", BidConst.BASE_BORROW_SCORE);
			return "borrow";
		}
	}

	/**
	 * 导向到借款申请页面
	 */
	@RequestMapping("borrowInfo")
	public String borrowInfo(Model model) {
		Long id = UserContext.getCurrent().getId();
		if (bidRequestService.canApplyBidRequeset(id)) {
			// 能够申请借款
			model.addAttribute("minBidRequestAmount",
					BidConst.SMALLEST_BIDREQUEST_AMOUNT);// 最小借款金额
			model.addAttribute("minBidAmount", BidConst.SMALLEST_BID_AMOUNT);// 系统规定的最小投标金额
			model.addAttribute("account", this.accountService.getCurrent());
			return "borrow_apply";
		} else {
			return "borrow_apply_result";
		}
	}

	/**
	 * 借款申请
	 */
	@RequestMapping("borrow_apply")
	public String borrowApply(BidRequest bidRequest) {
		this.bidRequestService.apply(bidRequest);
		return "redirect:/borrowInfo.do";
	}

	/**
	 * 前端借款明细
	 */
	@RequestMapping("borrow_info")
	public String borrowInfoDetail(Long id, Model model) {
		// bidRequest;
		BidRequest bidRequest = this.bidRequestService.get(id);
		if (bidRequest != null) {
			// userInfo
			Userinfo applier = this.userinfoService.get(bidRequest
					.getCreateUser().getId());
			// realAuth:借款人实名认证信息
			model.addAttribute("realAuth",
					this.realAuthService.get(applier.getRealAuthId()));
			// userFiles:借款人风控材料
			UserFileQueryObject qo = new UserFileQueryObject();
			qo.setApplierId(applier.getId());
			qo.setPageSize(-1);
			qo.setCurrentPage(1);
			model.addAttribute("userFiles",
					this.userFileService.queryForList(qo));

			model.addAttribute("bidRequest", bidRequest);
			model.addAttribute("userInfo", applier);

			if (UserContext.getCurrent() != null) {
				// self:当前用户是否是借款人自己
				if (UserContext.getCurrent().getId().equals(applier.getId())) {
					model.addAttribute("self", true);
				} else {
					// account
					model.addAttribute("self", false);
					model.addAttribute("account",
							this.accountService.getCurrent());
				}
			} else {
				model.addAttribute("self", false);
			}
		}
		return "borrow_info";
	}
}
