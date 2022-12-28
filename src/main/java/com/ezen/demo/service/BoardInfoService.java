package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.BoardInfoMapper;
import com.ezen.demo.vo.BoardInfoVO;

@Service
public class BoardInfoService { //Service역할
	
	@Autowired
	private BoardInfoMapper boardInfoMapper;
	
	public List<BoardInfoVO> getBoardInfoList(BoardInfoVO boardInfoVO){
		return boardInfoMapper.selectBoardInfoList(boardInfoVO);
	}
	
	public BoardInfoVO getBoardInfo(BoardInfoVO boardInfoVO) {
		return boardInfoMapper.selectBoardInfo(boardInfoVO);
	}
	public int insertBoardInfo(BoardInfoVO boardInfoVO) {
		return boardInfoMapper.insertBoardInfo(boardInfoVO);
	}
	
	public int updateBoardInfo(BoardInfoVO boardInfoVO) {
		return boardInfoMapper.updateBoardInfo(boardInfoVO);
	}
	
	public int deleteBoardInfo(int biNum) {
		return boardInfoMapper.deleteBoardInfo(biNum);
	}
}
