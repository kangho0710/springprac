package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.demo.service.BoardInfoService;
import com.ezen.demo.vo.BoardInfoVO;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class BoardInfoController { //서블렛 역할
	
	@Autowired
	private BoardInfoService boardInfoService;
	
	@GetMapping("/board-info")
	public String getBoardInfoList(Model model, BoardInfoVO boardInfoVO) {
		model.addAttribute("boardList", boardInfoService.getBoardInfoList(boardInfoVO));
		return "views/board-info/boardinfolist";
	}
	
	@GetMapping("/board-info/select")
	public String getBoardInfo(Model model, BoardInfoVO boardInfoVO) {
		model.addAttribute("boardInfo", boardInfoService.getBoardInfo(boardInfoVO));
		return "views/board-info/boardview";
	}
	
	
	@GetMapping("/board-info/update") //수정용화면
	public String gettingBoardInfo(Model model, BoardInfoVO boardInfoVO) {
		model.addAttribute("boardInfo", boardInfoService.getBoardInfo(boardInfoVO));
		return "views/board-info/boardinfoupdate";
	}
	
	@PostMapping("/board-info/insert")
	public String insertBoardInfo(Model model, BoardInfoVO boardInfoVO){
		model.addAttribute("msg", "등록성공");
		model.addAttribute("url", "/board-info");
		if(boardInfoService.insertBoardInfo(boardInfoVO)!=1) {
			model.addAttribute("msg", "등록실패");
			model.addAttribute("url", "views/board-info/boardinsert");
		}
		return "views/common/msg";
	}
	
	@PostMapping("/board-infos/update") //수정
	public String updateBoardInfo(Model model, BoardInfoVO boardInfoVO) {
		model.addAttribute("msg","수정 성공");
		model.addAttribute("url", "/board-info");
		if(boardInfoService.updateBoardInfo(boardInfoVO)!=1) {
			model.addAttribute("msg","수정 실패");
			model.addAttribute("url", "views/board-info/boardinfoupdate?biNum="+boardInfoVO.getBiNum());
		}
		return "views/common/msg";
	}
	
	@PostMapping("/board-info/delete")
	public String deleteBoardInfo(Model model, BoardInfoVO boardInfoVO) {
		model.addAttribute("msg","삭제 성공");
		model.addAttribute("url", "/board-info");
		if(boardInfoService.deleteBoardInfo(boardInfoVO.getBiNum())!=1) {
			model.addAttribute("msg","삭제 실패");
			model.addAttribute("url", "views/board-info/boardinfoupdate?biNum="+boardInfoVO.getBiNum());
		}
		return "views/common/msg";
	}
}
