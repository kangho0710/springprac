package com.ezen.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.UserInfoService;
import com.ezen.demo.vo.UserInfoVO;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	
	@PostMapping("/user-infos/insert")
	@ResponseBody
	public int insertUserInfo(@RequestBody UserInfoVO userInfo) {
		return userInfoService.insertUserInfo(userInfo);
	}
	
	@GetMapping("/user-infos/check/{uiId}")
	@ResponseBody
	public boolean existUserInfoId(@PathVariable("uiId") String uiId) {
		return userInfoService.existUserInfoId(uiId);
	}
	
	@GetMapping("/user-infos/logout")
	@ResponseBody
	public boolean logOut(HttpSession session) {
		session.invalidate();
		return true;
	}
	
	@PostMapping("/user-infos/login")
	@ResponseBody
	public UserInfoVO loginUserInfo(@RequestBody UserInfoVO userInfo, HttpSession session) {
		UserInfoVO loginUserInfo = userInfoService.login(userInfo);
		if(loginUserInfo != null) {
			session.setAttribute("userInfo", loginUserInfo);
			loginUserInfo.setUiPwd(null);
		}
		return loginUserInfo;
	}
	
	
	@PostMapping("/user-infos/{uiNum}")
	@ResponseBody
	public boolean checkPassword(@RequestBody UserInfoVO userInfo, @PathVariable("uiNum") int uiNum) {
		return userInfoService.checkPassword(userInfo, uiNum);
	}
	
	
	@DeleteMapping("/user-infos/{uiNum}")
	@ResponseBody
	public boolean deleteUserInfo(@RequestBody UserInfoVO userInfo, @PathVariable("uiNum") int uiNum) {
		return userInfoService.deleteUserInfo(userInfo, uiNum);
	}
	
	@PatchMapping("/user-infos/{uiNum}")
	public @ResponseBody boolean modifyUserInfo(@RequestBody UserInfoVO userInfo, @PathVariable("uiNum") int uiNum, HttpSession session) {
		UserInfoVO sessioUserInfo = (UserInfoVO) session.getAttribute("userInfo");
		if(sessioUserInfo==null || sessioUserInfo.getUiNum()!=uiNum) {
			throw new RuntimeException("잘못 정보 수정 입니다.");
		}
		userInfo.setUiNum(uiNum);
		return userInfoService.updateUserInfo(userInfo);
	}
	

	
}
