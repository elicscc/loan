package com.xmg.website.base.query;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

import com.xmg.website.base.util.DateUtil;

/**
 * 基本的审核查询对象
 * 
 * @author Administrator
 * 
 */
@Setter
@Getter
public class AuditQueryObject extends QueryObject {
	private int state = -1;
	private Date beginDate;
	private Date endDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate == null ? null : DateUtil.endOfDay(endDate);
	}
}
