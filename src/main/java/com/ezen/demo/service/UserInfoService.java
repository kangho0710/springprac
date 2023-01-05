package com.ezen.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ezen.demo.mapper.UserInfoMapper;
import com.ezen.demo.util.SHA256;
import com.ezen.demo.vo.UserInfoVO;

@Controller
public class UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public int insertUserInfo(UserInfoVO userInfo) { //회원가입
		userInfo.setUiPwd(SHA256.encode(userInfo.getUiPwd()));
		return userInfoMapper.insertUserInfo(userInfo);
	}
	
	public boolean existUserInfoId(String uiId) { //id중복확인
		if(userInfoMapper.selectUserInfoById(uiId)==null) {
			return false;
		}
		return true;
	}
	
	public UserInfoVO login(UserInfoVO userInfo) { //로그인
		userInfo.setUiPwd(SHA256.encode(userInfo.getUiPwd()));
		return userInfoMapper.selectUserInfoByIdAndPwd(userInfo);
	}
	
	public boolean checkPassword(UserInfoVO userInfo, int uiNum) {
		UserInfoVO tempUserInfo = userInfoMapper.selectUserInfoByNum(uiNum);
		if(tempUserInfo !=null) {
			if(SHA256.encode(userInfo.getUiPwd()).equals(tempUserInfo.getUiPwd())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteUserInfo(UserInfoVO userInfo, int uiNum) {
		if(checkPassword(userInfo, uiNum)) {
			if(userInfoMapper.deleteUserInfo(uiNum)==1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean updateUserInfo(UserInfoVO userInfo, HttpSession session) {
		if(userInfoMapper.updateUserInfo(userInfo)==1) {
			UserInfoVO tmpUserInfo = userInfoMapper.selectUserInfoByNum(userInfo.getUiNum());
			session.setAttribute("userInfo", tmpUserInfo);
			return true;
		}
		return false;
	}
	
}
