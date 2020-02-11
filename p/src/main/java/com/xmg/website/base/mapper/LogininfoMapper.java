package com.xmg.website.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xmg.website.base.domain.Logininfo;

public interface LogininfoMapper {
	int insert(Logininfo record);

	Logininfo selectByPrimaryKey(Long id);

	List<Logininfo> selectAll();

	int updateByPrimaryKey(Logininfo record);

	/**
	 * 根据用户名查询用户数量
	 * 
	 * @param username
	 * @return
	 */
	int getCountByUsername(String username);

	/**
	 * 登陆
	 * 
	 * @param username
	 * @param encode
	 * @return
	 */
	Logininfo login(@Param("username") String username,
                    @Param("password") String encode, @Param("userType") int userType);

	/**
	 * 按照类型查询用户类型数量
	 * 
	 * @param userManager
	 * @return
	 */
	int countByUserType(int userType);
}