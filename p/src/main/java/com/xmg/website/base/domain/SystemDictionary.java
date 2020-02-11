package com.xmg.website.base.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import com.alibaba.fastjson.JSONObject;

/**
 * 数据字典分类
 * @author Administrator
 *
 */
@Setter
@Getter
public class SystemDictionary extends BaseDomain{
	private String sn;
	private String title;
	
	/**
	 * 返回当前的json字符串
	 * @return
	 */
	public String getJsonString(){
		Map<String,Object> json=new HashMap<>();
		json.put("id",id);
		json.put("sn", sn);
		json.put("title", title);
		return JSONObject.toJSONString(json);
	}
}
