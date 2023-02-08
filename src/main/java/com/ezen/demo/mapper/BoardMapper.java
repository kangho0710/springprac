package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> selectBoardList(BoardVO board);
	BoardVO selectBoard(int boardNo);
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
}
