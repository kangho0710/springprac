package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.demo.service.KtRolsterService;
import com.ezen.demo.vo.KtRolsterVO;

@Controller
public class KtRolsterController {
	
	@Autowired
	private KtRolsterService ktRolsterService;
	
	@GetMapping("/kt-list")
	public String getKtList(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("ktList", ktRolsterService.getKtRolsterList(ktRolster));
		return "views/ktrolster/kt-list";
	}
	@GetMapping("/kt-list/select")
	public String getKt(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("kt", ktRolsterService.getKtRolster(ktRolster));
		return "views/ktrolster/kt-select";
	}
	
	@GetMapping("/kt-list/update")
	public String gettigKt(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("kt", ktRolsterService.getKtRolster(ktRolster));
		return "views/ktrolster/kt-update";
	}
	
	@PostMapping("/kt-list/update")
	public String updateKt(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("msg", "수정성공");
		model.addAttribute("url", "/kt-list");
		if(ktRolsterService.updateKt(ktRolster)!=1) {
			model.addAttribute("msg", "수정실패");
			model.addAttribute("url", "views/ktrolster/kt-update?ktNum="+ktRolster.getKtNum());
		}
		return "views/common/msg";
	}
	
	
	@PostMapping("/kt-list/insert")
	public String insertKt(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("msg", "등록성공");
		model.addAttribute("url", "/kt-list");
		if(ktRolsterService.insertKt(ktRolster)!=1) {
			model.addAttribute("msg", "등록실패");
			model.addAttribute("url", "views/ktrolster/kt-list");
		}
		return "views/common/msg";
	}
	
	@PostMapping("/kt-list/delete")
	public String deleteKt(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("msg", "삭제성공");
		model.addAttribute("url", "/kt-list");
		if(ktRolsterService.deleteKt(ktRolster.getKtNum())!=1) {
			model.addAttribute("msg", "삭제실패");
			model.addAttribute("url", "views/ktrolster/kt-update?ktNum="+ktRolster.getKtNum());
		}
		return "views/common/msg";
	}
}
