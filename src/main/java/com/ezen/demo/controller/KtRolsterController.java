package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/kt-list/select") //상세보기
	public String getKt(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("kt", ktRolsterService.getKtRolster(ktRolster));
		return "views/ktrolster/kt-select";
	}
	
	@GetMapping("/kt-list/update") //업데이트 화면
	public String getKt2(Model model, KtRolsterVO ktRolster) {
		model.addAttribute("kt", ktRolsterService.getKtRolster(ktRolster));
		return "views/ktrolster/kt-update";
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
	
	@PatchMapping("/kt-list/update/{ktNum}")
	@ResponseBody
	public int updateKtRolster(@RequestBody KtRolsterVO ktRolster, @RequestBody @PathVariable("ktNum") int ktNum) {
		ktRolster.setKtNum(ktNum);
		return ktRolsterService.updateKt(ktRolster);
	}
	
	
	
	@DeleteMapping("/kt-list/delete/{ktNum}")
	@ResponseBody
	public int deleteKtRolster(@PathVariable("ktNum") int ktNum) {
		return ktRolsterService.deleteKt(ktNum);
	}
}
