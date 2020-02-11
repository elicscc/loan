package com.xmg.website.business.query;

import lombok.Getter;
import lombok.Setter;

import com.xmg.website.base.query.QueryObject;

/**
 * 查询借款
 * 
 * @author Administrator
 * 
 */
@Setter
@Getter
public class BidRequestQueryObject extends QueryObject {

	private int bidRequestState = -1;// 借款状态
	private int[] bidRequestStates;// 要查询的多个结狂状态

	private String orderBy;// 按照哪个列排序
	private String orderType;// 按照什么顺序排序

}
