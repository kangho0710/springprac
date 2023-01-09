package com.ezen.demo;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.demo.mapper.BoardInfoMapper;
import com.ezen.demo.mapper.StudentPointMapper;
import com.ezen.demo.vo.BoardInfoVO;
import com.ezen.demo.vo.StudentPointVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

	@Autowired
	private StudentPointMapper studentPointMapper;
	
	@Autowired
	private BoardInfoMapper boardInfoMapper;
	
	@Test
	void contextLoads() {
//		List<StudentPointVO> list = studentPointMapper.selectStudentPointList(null);
//		StudentPointVO sp = list.get(0);
//		assertThat(sp.getSpNum()).isEqualTo(0);
//		StudentPointVO sp2 = studentPointMapper.selectStudentPoint(sp.getSpNum());
//		assertThat(sp.toString().equals(sp2.toString())).isFalse();
//		StudentPointVO st = new StudentPointVO();
//		st.setSpName("김");
//		st.setSpKorPoint(75);
//		st.setSpEngPoint(75);
//		st.setSpMathPoint(75);
//		st.setSpProfile("뭐해");
//		int result = studentPointMapper.insertStudentPoint(st);
//		assertThat(result).isEqualTo(0);
//		int result = studentPointMapper.deleteStudentPoint(list.get(0));
		
//		log.info("boardInfoList=>{}", boardInfoMapper.selectBoardInfoList(null));
//		log.info("result =>{}", boardInfoMapper.updateBoardInfoActive(1));
//		BoardInfoVO board = new BoardInfoVO();
//		board.setBiTitle("단위테스트");
//		board.setBiContent("안녕");
//		board.setUiNum(8);
//		int result = boardInfoMapper.insertBoardInfo(board);
//		log.info("result=>{}", result);
		
	}

}
