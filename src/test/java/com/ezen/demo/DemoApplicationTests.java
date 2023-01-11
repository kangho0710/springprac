package com.ezen.demo;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.demo.api.ApiBoxOffice;
import com.ezen.demo.mapper.BoxOfficeMapper;
import com.ezen.demo.vo.BoxOfficeVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
	
	@Autowired
	private ApiBoxOffice apiBoxOffice;
	
	@Autowired
	private BoxOfficeMapper boxOfficeMapper;
	
	@Test
	void contextLoads() {
//		List<BoxOfficeVO> boxOfficeList = apiBoxOffice.getBoxOfficeList();
//		assertThat(boxOfficeList.size()).isEqualTo(300);
//		BoxOfficeVO boxOffice = boxOfficeList.get(0);
//		int result = boxOfficeMapper.insertBoxOffices(boxOfficeList);
//		assertThat(result).isEqualTo(20);
	}

}
