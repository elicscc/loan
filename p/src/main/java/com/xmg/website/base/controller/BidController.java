package com.xmg.website.base.controller;

import com.xmg.website.base.util.JSONResult;
import com.xmg.website.business.service.IBidRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * 投标
 *
 * @author Administrator
 */
@Controller
public class BidController {

    @Autowired
    private IBidRequestService bidRequestService;

    ////@RequireLogin
    @RequestMapping("borrow_bid")
    @ResponseBody
    public JSONResult bid(Long bidRequestId, BigDecimal amount) {
        this.bidRequestService.bid(bidRequestId, amount);
        return new JSONResult();
    }

}
