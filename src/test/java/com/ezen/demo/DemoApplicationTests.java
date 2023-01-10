package com.ezen.demo;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.demo.crawl.Yes24Crawl;
import com.ezen.demo.mapper.BestSellerMapper;
import com.ezen.demo.vo.BestSellerVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

	@Autowired 
	private Yes24Crawl yes24;
	
	@Autowired
	private BestSellerMapper bestSellerMapper;
	@Test
	void contextLoads() {
//		List<BestSellerVO> bestSellerList = yes24.crawlYes24();
		PageHelper.startPage(1,10);
		List<BestSellerVO> bestSellerList = bestSellerMapper.selectBestSellerList();
		PageInfo<BestSellerVO> pageList = PageInfo.of(bestSellerList);
		log.info("pageList=>{}",pageList);
		
//		int result = bestSellerMapper.insertBestSeller(bestSellerList);
//		log.info("result=>{}",result);
		for(BestSellerVO bestSeller : bestSellerList) {
			log.info("num=>{}",bestSeller.getBsNum());
		}
	}

}
