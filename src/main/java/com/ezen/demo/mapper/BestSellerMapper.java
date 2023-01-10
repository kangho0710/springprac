package com.ezen.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;

import com.ezen.demo.vo.BestSellerVO;

public interface BestSellerMapper {
	
	int insertBestSeller(@Param("bestSellerList")List<BestSellerVO> bestSellerList);
	//@param = 다수의 파라미터 전달
	/*1. 서비스에서 for문 100번
	2. foreach
	*/
	List<BestSellerVO> selectBestSellerList();
	
	
}
