package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
}
