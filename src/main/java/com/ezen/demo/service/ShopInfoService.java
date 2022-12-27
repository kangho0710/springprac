package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.ShopInfoMapper;
import com.ezen.demo.vo.ShopInfoVO;
@Service
public class ShopInfoService {
	
	@Autowired
	private ShopInfoMapper shopInfoMapper;

	public List<ShopInfoVO> getShopInfoList(ShopInfoVO shopInfoVO){
		return shopInfoMapper.selectShopInfoList(shopInfoVO);
	}
}
