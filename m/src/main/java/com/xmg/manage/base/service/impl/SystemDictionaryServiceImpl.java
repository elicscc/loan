package com.xmg.manage.base.service.impl;

import com.xmg.manage.base.domain.SystemDictionary;
import com.xmg.manage.base.domain.SystemDictionaryItem;
import com.xmg.manage.base.mapper.SystemDictionaryItemMapper;
import com.xmg.manage.base.mapper.SystemDictionaryMapper;
import com.xmg.manage.base.query.PageResult;
import com.xmg.manage.base.query.SystemDictionaryQueryObject;
import com.xmg.manage.base.service.ISystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemDictionaryServiceImpl implements ISystemDictionaryService {

	@Autowired
	private SystemDictionaryMapper systemDictionaryMapper;

	@Autowired
	private SystemDictionaryItemMapper systemDictionaryItemMapper;

	@Override
	public PageResult queryDics(SystemDictionaryQueryObject qo) {
		int count = this.systemDictionaryMapper.queryForCount(qo);
		if (count > 0) {
			List<SystemDictionary> list = this.systemDictionaryMapper.query(qo);
			return new PageResult(list, count, qo.getCurrentPage(),
					qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}

	@Override
	public PageResult queryItems(SystemDictionaryQueryObject qo) {
		int count = this.systemDictionaryItemMapper.queryForCount(qo);
		if (count > 0) {
			List<SystemDictionaryItem> list = this.systemDictionaryItemMapper
					.query(qo);
			return new PageResult(list, count, qo.getCurrentPage(),
					qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}

	@Override
	public void saveOrUpdateItem(SystemDictionaryItem item) {
		if (item.getId() != null) {
			this.systemDictionaryItemMapper.updateByPrimaryKey(item);
		} else {
			this.systemDictionaryItemMapper.insert(item);
		}
	}

	@Override
	public void saveOrUpdateDic(SystemDictionary dictionary) {
		if (dictionary.getId() != null) {
			this.systemDictionaryMapper.updateByPrimaryKey(dictionary);
		} else {
			this.systemDictionaryMapper.insert(dictionary);
		}
	}

	@Override
	public List<SystemDictionary> listAllDics() {
		return this.systemDictionaryMapper.selectAll();
	}

	@Override
	public List<SystemDictionaryItem> listByParentSn(String sn) {
		return this.systemDictionaryItemMapper.listByParentSn(sn);
	}

}
