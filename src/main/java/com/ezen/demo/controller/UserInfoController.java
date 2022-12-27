package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.demo.service.UserInfoService;
import com.ezen.demo.vo.UserInfoVO;

@RestController
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
	public List<UserInfoVO> getUserInfos(){
		return userInfoService.getUserInfos();
	}
}
