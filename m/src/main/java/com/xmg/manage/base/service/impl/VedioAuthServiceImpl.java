package com.xmg.manage.base.service.impl;

import com.xmg.manage.base.domain.Logininfo;
import com.xmg.manage.base.domain.Userinfo;
import com.xmg.manage.base.domain.VedioAuth;
import com.xmg.manage.base.mapper.VedioAuthMapper;
import com.xmg.manage.base.query.PageResult;
import com.xmg.manage.base.query.VedioAuthQueryObject;
import com.xmg.manage.base.service.IUserinfoService;
import com.xmg.manage.base.service.IVedioAuthService;
import com.xmg.manage.base.util.BitStatesUtils;
import com.xmg.manage.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VedioAuthServiceImpl implements IVedioAuthService {

	@Autowired
	private VedioAuthMapper vedioAuthMapper;

	@Autowired
	private IUserinfoService userinfoService;

	@Override
	public PageResult query(VedioAuthQueryObject qo) {
		int count = this.vedioAuthMapper.queryForCount(qo);
		if (count > 0) {
			List<VedioAuth> list = this.vedioAuthMapper.query(qo);
			return new PageResult(list, count, qo.getCurrentPage(),
					qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}

	@Override
	public void audit(Long loginInfoValue, String remark, int state) {
		// 判断用户没有视频认证
		Userinfo user = this.userinfoService.get(loginInfoValue);
		if (user != null && !user.getIsVedioAuth()) {
			// 添加一个视频认证对象,设置相关属性
			VedioAuth va = new VedioAuth();

			Logininfo applier = new Logininfo();
			applier.setId(loginInfoValue);
			va.setApplier(applier);
			va.setApplyTime(new Date());
			va.setAuditor(UserContext.getCurrent());
			va.setAuditTime(new Date());
			va.setRemark(remark);
			va.setState(state);
			this.vedioAuthMapper.insert(va);

			if (state == VedioAuth.STATE_AUDIT) {
				// 如果状态审核通过,修改用户状态码
				user.addState(BitStatesUtils.OP_VEDIO_AUTH);
				this.userinfoService.update(user);
			}
		}
	}

}
