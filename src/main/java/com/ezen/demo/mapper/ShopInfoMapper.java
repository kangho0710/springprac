package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.ShopInfoVO;

public interface ShopInfoMapper {

	List<ShopInfoVO> selectShopInfoList(ShopInfoVO shopInfoVO);
	String insertShopInfo(ShopInfoVO shopInfo);
	ShopInfoVO selectShopInfo(ShopInfoVO shopInfoVO);
}
