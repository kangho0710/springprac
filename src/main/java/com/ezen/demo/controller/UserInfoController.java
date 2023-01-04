package com.ezen.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.UserInfoService;
import com.ezen.demo.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j //로그
public class UserInfoController {

/*
 * Controller, RestController
 * Configuration
 * Service, Repository, Component
 * Bean
 */
	
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/user-infos")
	public String getUserInfos(Model model, @ModelAttribute UserInfoVO userInfo){ //@ModelAttribute = 리퀘스트와 userinfoVO자동생성
		
		log.info("userInfo=>{}", userInfo);
		model.addAttribute("userList", userInfoService.getUserInfos(userInfo));
		return "views/user-info/list";
	}
	
	@GetMapping("/user-infos/check/{uiId}")
	@ResponseBody
	public boolean existUserId(@PathVariable("uiId") String uiId) {
		return userInfoService.existsUserId(uiId);
	}
	
	@PostMapping("/login")
	public @ResponseBody UserInfoVO login(@RequestBody UserInfoVO userInfo, HttpSession session) {
		UserInfoVO loginUserInfo = userInfoService.login(userInfo);
		if(loginUserInfo !=null) {
			session.setAttribute("userInfo", loginUserInfo);
			loginUserInfo.setUiPwd(null);
		}
		return loginUserInfo;
	}
	
	@PostMapping("/user-infos/insert")
	@ResponseBody
	public int insertUserId(@RequestBody UserInfoVO userInfo) {
		return userInfoService.insertUserId(userInfo);
	}
	
	@PostMapping("/user-infos/{uiNum}")
	public @ResponseBody boolean checkPassword(@RequestBody UserInfoVO userInfo, @PathVariable("uiNum") int uiNum) {
		return userInfoService.checkPassword(userInfo, uiNum);
	}
	
	@DeleteMapping("/user-infos/{uiNum}")
	public @ResponseBody boolean removeUserInfo(@RequestBody UserInfoVO userInfo, @PathVariable("uiNum") int uiNum) {
		return userInfoService.removeUserInfo(userInfo, uiNum);
	}
	
}
