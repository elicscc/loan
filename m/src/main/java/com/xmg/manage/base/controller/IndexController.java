package com.xmg.manage.base.controller;

import com.xmg.manage.base.util.BidConst;
import com.xmg.manage.business.query.BidRequestQueryObject;
import com.xmg.manage.business.service.IBidRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网站首页
 * 
 * @author Administrator
 * 
 */
@Controller
public class IndexController {

	@Autowired
	private IBidRequestService bidRequestService;

	//@RequestMapping("index")
	public String index(Model model) {
		// bidRequests
		model.addAttribute("bidRequests", this.bidRequestService.listIndex(5));
		return "main";
	}

	/**
	 * 投资列表的框框
	 */
	@RequestMapping("invest")
	public String investIndex() {
		return "invest";
	}

	/**
	 * 投资列表明细
	 */
	@RequestMapping("invest_list")
	public String investList(BidRequestQueryObject qo, Model model) {
		if (qo.getBidRequestState() == -1) {
			qo.setBidRequestStates(new int[] {
					BidConst.BIDREQUEST_STATE_BIDDING,
					BidConst.BIDREQUEST_STATE_PAYING_BACK,
					BidConst.BIDREQUEST_STATE_COMPLETE_PAY_BACK });
		}
		model.addAttribute("pageResult", this.bidRequestService.query(qo));
		return "invest_list";
	}

}
