package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.demo.service.KtRolsterService;
import com.ezen.demo.vo.KtRolsterVO;

@Controller
public class KtRolsterController {
	
	@Autowired
	private KtRolsterService ktRolsterService;
	
	@GetMapping("/kt-list")
	public String getKtList(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("ktList", ktRolsterService.getKtRolsterList(ktRolster));
		return "/views/ktrolster/kt-list";
	}
	
}
