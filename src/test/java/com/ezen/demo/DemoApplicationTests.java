package com.ezen.demo;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import com.ezen.demo.api.ApiFestivalInfo;
import com.ezen.demo.mapper.FestivalInfoMapper;
import com.ezen.demo.vo.fetival.FestivalInformationVO;
import com.ezen.demo.vo.fetival.FestivalResultVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@PropertySource("classpath:env.properties")
class DemoApplicationTests {
	@Value("${data.url}")
	private String dataUrl;
	
	@Autowired
	private ApiFestivalInfo apiFestivalInfo;
	
	@Autowired
	private FestivalInfoMapper festivalMapper;
	
	@Test
	void contextLoads() {
		String searchFestivalUrl ="/searchFestival?serviceKey=ifyooOA8kX%2FOJ%2Ffq7znyZl%2BNNJQ%2BFvCQa%2F4fthZxvSapzlVyNcCw4mo4DZeynG1SiBhS7GlFA5ZiJaI%2FK4U%2F1w%3D%3D&numOfRows=1000&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&eventStartDate=20220601";
		FestivalResultVO festivalResult = apiFestivalInfo.getData(dataUrl + searchFestivalUrl, FestivalResultVO.class);
//		log.info("festival=>{}",festivalResult);
		List<FestivalInformationVO> festivalInformationList = festivalResult.getResponse().getBody().getItems().getItem();
		int result = festivalMapper.insertFestivalInfos(festivalInformationList);
		log.debug("result=>{}",result);
	}

}
