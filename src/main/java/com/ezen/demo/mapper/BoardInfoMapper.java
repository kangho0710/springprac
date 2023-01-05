package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.BoardInfoVO;

public interface BoardInfoMapper { //DAO역할
	
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO boardInfo);
	int insertBoardInfo(BoardInfoVO boardInfo);
	BoardInfoVO selectBoardInfo(int biNum);
	int updateBoardInfoActive(int biNum); //액티브 1로바꿈
	int updateBoardInfo(BoardInfoVO boardInfo);
}
