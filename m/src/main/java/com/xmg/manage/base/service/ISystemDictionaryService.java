package com.xmg.manage.base.service;

import com.xmg.manage.base.domain.SystemDictionary;
import com.xmg.manage.base.domain.SystemDictionaryItem;
import com.xmg.manage.base.query.PageResult;
import com.xmg.manage.base.query.SystemDictionaryQueryObject;

import java.util.List;

/**
 * 数据字典相关服务
 * 
 * @author Administrator
 * 
 */
public interface ISystemDictionaryService {

	/**
	 * 数据字典分类分页查询
	 * 
	 * @return
	 */
	PageResult queryDics(SystemDictionaryQueryObject qo);

	/**
	 * 查询所有的数据字典明细
	 */
	List<SystemDictionary> listAllDics();

	/**
	 * 根据数据字典分类sn查询明细
	 * 
	 * @param sn
	 * @return
	 */
	List<SystemDictionaryItem> listByParentSn(String sn);

	/**
	 * 修改或者保存数据字典分类
	 * 
	 * @param dictionary
	 */
	void saveOrUpdateDic(SystemDictionary dictionary);

	/**
	 * 数据字典明细的分页查询
	 */
	PageResult queryItems(SystemDictionaryQueryObject qo);

	/**
	 * 修改或者保存数据字典明细
	 * 
	 * @param item
	 */
	void saveOrUpdateItem(SystemDictionaryItem item);
}
