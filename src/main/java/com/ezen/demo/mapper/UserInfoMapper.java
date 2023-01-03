package com.ezen.demo.mapper;

import java.util.List;
import java.util.Map;

import com.ezen.demo.vo.UserInfoVO;

public interface UserInfoMapper {
	
	List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo);
	UserInfoVO selectUserInfoById(String uiId);
	UserInfoVO selectUserInfo(UserInfoVO userInfo); //로그인
	int insertUserInfo(UserInfoVO userInfo);
}
