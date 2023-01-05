package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.BoardInfoMapper;
import com.ezen.demo.vo.BoardInfoVO;
import com.ezen.demo.vo.UserInfoVO;

@Service
public class BoardInfoService { //Service역할
	
	@Autowired
	private BoardInfoMapper boardInfoMapper;
	
	public List<BoardInfoVO> getBoardInfoList(BoardInfoVO boardInfoVO){
		return boardInfoMapper.selectBoardInfoList(boardInfoVO);
	}
	
	public int insertBoardInfo(BoardInfoVO boardInfoVO) {
		return boardInfoMapper.insertBoardInfo(boardInfoVO);
	}
	
	public BoardInfoVO selectBoardInfo(int biNum) {
		return boardInfoMapper.selectBoardInfo(biNum);
	}
	
	public int updateBoardInfo(BoardInfoVO boardInfo) {
		return boardInfoMapper.updateBoardInfo(boardInfo);
	}
	
	public int updateBoardInfoActive(int biNum) { //active 0으로 바꿈
		return boardInfoMapper.updateBoardInfoActive(biNum);
	}
}
