package com.xmg.website.base.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import com.xmg.website.base.util.BidConst;
import com.xmg.website.base.util.MD5;

/**
 * 用户对应的账户信息
 * 
 * @author Administrator
 * 
 */
@Setter
@Getter
public class Account extends BaseDomain {

	private int version;
	private String tradePassword;
	private BigDecimal usableAmount = BidConst.ZERO;
	private BigDecimal freezedAmount = BidConst.ZERO;
	private BigDecimal unReceiveInterest = BidConst.ZERO;
	private BigDecimal unReceivePrincipal = BidConst.ZERO;
	private BigDecimal unReturnAmount = BidConst.ZERO;
	private BigDecimal remainBorrowLimit = BidConst.INIT_BORROW_LIMIT;
	private BigDecimal borrowLimit = BidConst.INIT_BORROW_LIMIT;

	private String verifyCode;// 做数据校验的

	public String getVerifyCode() {
		return MD5.encode(usableAmount.hashCode() + " "
				+ freezedAmount.hashCode());
	}

	public boolean checkVerifyCode() {
		return MD5.encode(
				usableAmount.hashCode() + " " + freezedAmount.hashCode())
				.equals(verifyCode);
	}

	public BigDecimal getTotalAmount() {
		return usableAmount.add(this.freezedAmount)
				.add(this.unReceivePrincipal);
	}

}
