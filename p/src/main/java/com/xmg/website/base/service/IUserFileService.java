package com.xmg.website.base.service;

import java.util.List;

import com.xmg.website.base.domain.UserFile;
import com.xmg.website.base.query.PageResult;
import com.xmg.website.base.query.UserFileQueryObject;

/**
 * 风控资料服务
 * 
 * @author Administrator
 * 
 */
public interface IUserFileService {

	/**
	 * 上传一个风控资料对象
	 * 
	 * @param fileName
	 */
	void apply(String fileName);

	/**
	 * 列出一个用户风控资料对象 hasType:如果为true,选择有类型的,如果为false,选择没有类型的
	 * 
	 * @param id
	 * @return
	 */
	List<UserFile> listFilesByHasType(Long logininfoId, boolean hasType);

	/**
	 * 批量的处理用户风控资料类型的选择
	 * 
	 * @param id
	 * @param fileType
	 */
	void batchUpdateFileType(Long[] ids, Long[] fileTypes);

	PageResult query(UserFileQueryObject qo);

	List<UserFile> queryForList(UserFileQueryObject qo);

	/**
	 * 审核
	 * 
	 * @param id
	 * @param score
	 * @param remark
	 * @param state
	 */
	void audit(Long id, int score, String remark, int state);

}
