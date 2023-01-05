package com.ezen.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.BoardInfoService;
import com.ezen.demo.vo.BoardInfoVO;
import com.ezen.demo.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class BoardInfoController { //서블렛 역할
	
	@Autowired
	private BoardInfoService boardInfoService;
	
	@GetMapping("/board-infos")
	@ResponseBody
	public List<BoardInfoVO> getBoardInfoList(@ModelAttribute BoardInfoVO boardInfo, Model model) {
		return boardInfoService.getBoardInfoList(boardInfo);
	}
	
	@PostMapping("/board-infos")
	@ResponseBody
	public int insertBoardInfo(@RequestBody BoardInfoVO boardInfo, HttpSession session) {
		UserInfoVO userInfo = (UserInfoVO) session.getAttribute("userInfo");
		if(userInfo == null) {
			throw new RuntimeException("로그인해줘");
		}
		boardInfo.setUiNum(userInfo.getUiNum());
		return boardInfoService.insertBoardInfo(boardInfo);
	}
	
	@GetMapping("/board-infos/{biNum}")
	@ResponseBody
	public BoardInfoVO selectBoardInfo(@PathVariable("biNum") int biNum) {
		return boardInfoService.selectBoardInfo(biNum);
	}
	
	
	@DeleteMapping("/board-infos/{biNum}")
	@ResponseBody
	public int deleteBoardInfo(@PathVariable("biNum") int biNum) {
		return boardInfoService.updateBoardInfoActive(biNum);
	}
	
	@PatchMapping("/board-infos/{biNum}")
	@ResponseBody
	public int updateBoardinfo(@RequestBody BoardInfoVO boardInfo, @PathVariable("biNum") int biNum) {
		boardInfo.setBiNum(biNum);
		return boardInfoService.updateBoardInfo(boardInfo);
	}
}
