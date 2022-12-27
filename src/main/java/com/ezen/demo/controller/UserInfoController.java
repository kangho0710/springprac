package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.demo.service.UserInfoService;
import com.ezen.demo.vo.UserInfoVO;

@Controller
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
	public String getUserInfos(Model model){
		model.addAttribute("userList", userInfoService.getUserInfos());
		return "views/user-info/list";
	}
}
