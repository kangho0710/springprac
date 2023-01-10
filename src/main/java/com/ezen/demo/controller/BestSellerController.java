package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.demo.service.BestSellerService;
import com.ezen.demo.vo.BestSellerVO;
import com.github.pagehelper.PageInfo;

@RestController
public class BestSellerController {
	@Autowired
	private BestSellerService bestSellerService;
	
	@GetMapping("/best-seller")
	public PageInfo<BestSellerVO> getBestSeller(BestSellerVO bestSeller){
		return bestSellerService.getBestSeller(bestSeller);
	}
}
