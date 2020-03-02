package com.xmg.website.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.xmg.website.base.domain.RealAuth;
import com.xmg.website.base.domain.Userinfo;
import com.xmg.website.base.event.RealAuthSuccessEvent;
import com.xmg.website.base.mapper.RealAuthMapper;
import com.xmg.website.base.query.PageResult;
import com.xmg.website.base.query.RealAuthQueryObject;
import com.xmg.website.base.service.IRealAuthService;
import com.xmg.website.base.service.IUserinfoService;
import com.xmg.website.base.util.BitStatesUtils;
import com.xmg.website.base.util.UserContext;

@Service
public class RealAuthServiceImpl implements IRealAuthService {

	@Autowired
	private RealAuthMapper realAuthMapper;

	@Autowired
	private IUserinfoService userinfoService;

	@Autowired
	private ApplicationContext ctx;
	
	@Value("${db.timeout}")
	private String key;

	@Override
	public RealAuth get(Long id) {
		return realAuthMapper.selectByPrimaryKey(id,key);
	}

	@Override
	public PageResult query(RealAuthQueryObject qo) {
		int count = this.realAuthMapper.queryForCount(qo,key);
		if (count > 0) {
			List<RealAuth> list = this.realAuthMapper.query(qo,key);
			return new PageResult(list, count, qo.getCurrentPage(),
					qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}

	@Override
	public void apply(RealAuth realAuth) {
		Userinfo current = this.userinfoService.getCurrent();
		// 判断当前用户没有实名认证并且当前用户不处于待审核状态
		if (!current.getIsRealAuth() && current.getRealAuthId() == null) {
			// 保存一个实名认证对象;
			realAuth.setState(RealAuth.STATE_NORMAL);
			realAuth.setApplier(UserContext.getCurrent());
			realAuth.setApplyTime(new Date());
			 
			this.realAuthMapper.insert(realAuth,key);
			// 把实名认证的id设置给userinfo
			current.setRealAuthId(realAuth.getId());
			////System.err.println(realAuth.getId());
			this.userinfoService.update(current);
		}
	}

	@Override
	public void audit(Long id, String remark, int state) {
		// 根据id得到实名认证对象
		RealAuth ra = this.get(id);
		// 如果对象存在,并且对象处于待审核状态
		if (ra != null && ra.getState() == RealAuth.STATE_NORMAL) {
			// 1,设置通用属性;
			ra.setAuditor(UserContext.getCurrent());
			ra.setAuditTime(new Date());
			ra.setState(state);
			Userinfo applier = this.userinfoService
					.get(ra.getApplier().getId());
			if (state == RealAuth.STATE_AUDIT) {
				// 3,如果状态是审核通过;
				// 1,保证用户处于未审核状态;
				if (!applier.getIsRealAuth()) {
					// 2,添加审核的状态码;设置userinfo上面的冗余数据;重新realauthid;
					applier.addState(BitStatesUtils.OP_REAL_AUTH);
					applier.setRealName(ra.getRealName());
					applier.setIdNumber(ra.getIdNumber());
					applier.setRealAuthId(ra.getId());
				}
				// 发布一个实名认证审核通过的消息
				ctx.publishEvent(new RealAuthSuccessEvent(this, ra));
				// 2,如果状态是审核拒绝;
			} else {
				// 1,userinfo中的realauthid设置为空
				applier.setRealAuthId(null);
			}
			this.userinfoService.update(applier);
			this.realAuthMapper.updateByPrimaryKey(ra);
		}
	}

}
