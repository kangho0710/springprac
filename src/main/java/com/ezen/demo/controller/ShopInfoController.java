package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.demo.service.ShopInfoService;
import com.ezen.demo.vo.ShopInfoVO;

@Controller
public class ShopInfoController {
	
	@Autowired
	private ShopInfoService shopinfoService;
	
	@GetMapping("/shop-list")
	public String getShopList(Model model, ShopInfoVO shopInfoVo) {
		model.addAttribute("shopList", shopinfoService.getShopInfoList(shopInfoVo));
		return "views/shop-info/shoplist";
	}
	
}
