package com.ezen.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.BestSellerMapper;
import com.ezen.demo.vo.BestSellerVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BestSellerService {
	@Autowired
	private BestSellerMapper bestSellerMapper;
	
	public PageInfo<BestSellerVO> getBestSeller(BestSellerVO bestSeller){
		PageHelper.startPage(bestSeller.getPage(), bestSeller.getRows());
		return PageInfo.of(bestSellerMapper.selectBestSellerList());
	}
}
