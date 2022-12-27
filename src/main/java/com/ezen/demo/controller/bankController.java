package com.ezen.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class bankController {
	
	@GetMapping("/bank/money") // /views를 탈 필요 없음
	public String goMoney(Model model) {
		model.addAttribute("money", "백만원"); //money.jsp의 ${money} requestScope에 들어감
		return "views/bank/money";
	}
	
	@GetMapping("/banks")
	public String goBanks(Model model) {
		List<String> bankList = new ArrayList<>();
		bankList.add("신한");
		bankList.add("국민");
		bankList.add("신협");
		bankList.add("수협");
		model.addAttribute("bankList", bankList);
		
		return "views/bank/list";
	}
}
