package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.mapper.BoardMapper;
import com.ezen.demo.vo.BoardVO;


@Controller
public class BoardController {
	@Autowired
	private BoardMapper boardMapper;
	
	@GetMapping("/board-list")
	@ResponseBody
	public List<BoardVO> getBoardList(BoardVO board){
		return boardMapper.selectBoardList(board);
	}
	
	@GetMapping("/board/{boardNo}")
	@ResponseBody
	public BoardVO getBoard(@PathVariable int boardNo) {
		return boardMapper.selectBoard(boardNo);
	}
	
	@PostMapping("/board-insert")
	@ResponseBody
	public int insertBoard(@RequestBody BoardVO board) {
		return boardMapper.insertBoard(board);
	}
	
	@PatchMapping("/board-update/{boardNo}")
	@ResponseBody
	public int updateBoard(@RequestBody BoardVO board, @PathVariable int boardNo) {
		board.setBoardNo(boardNo);
		return boardMapper.updateBoard(board);
	}
	
	@DeleteMapping("/board-delete/{boardNo}")
	@ResponseBody
	public int deleteBoard(@PathVariable int boardNo) {
		return boardMapper.deleteBoard(boardNo);
	}
	
}
