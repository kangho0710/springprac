package com.ezen.demo.mapper;

import com.ezen.demo.vo.UserInfoVO;

public interface UserInfoMapper {
	
	UserInfoVO selectUserInfoByIdAndPwd(UserInfoVO userInfo); //로그인 매퍼
	UserInfoVO selectUserInfoById(String uiId); //id중복확인 매퍼
	int insertUserInfo(UserInfoVO userInfo); //회원가입 매퍼
	
	UserInfoVO selectUserInfoByNum(int uiNum); //
	int deleteUserInfo(int uiNum); //회원탈퇴
}
