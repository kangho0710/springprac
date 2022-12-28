package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.demo.service.ShopInfoService;
import com.ezen.demo.vo.ShopInfoVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ShopInfoController {
	
	@Autowired
	private ShopInfoService shopinfoService;
	
	@GetMapping("/shop-infos")
	public String getShopList(Model model, ShopInfoVO shopInfoVo) {
		model.addAttribute("shopList", shopinfoService.getShopInfoList(shopInfoVo));
		return "views/shop-info/shoplist";
	}
	
	@PostMapping("/shop-infos/insert")
	public String insertShopInfo(Model model,@ModelAttribute ShopInfoVO shopInfo) {
		
		model.addAttribute("msg","상품등록 완료");
		model.addAttribute("url","/shop-infos");
		if(shopinfoService.insertShopInfo(shopInfo)!=1) {
			model.addAttribute("msg","상품등록 실패");
			model.addAttribute("url","/views/shop-info/shopinsert");
		}
		return "views/common/msg";
	}
	
	@GetMapping("/shop-info")
	public String getShopInfo(Model model, @ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("shopInfo",shopinfoService.selectShopInfo(shopInfo));
		return "views/shop-info/shopview";
	}
	
	@GetMapping("/shop-info/update") //업데이트 화면으로
	public String getShopInfo2(Model model, @ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("shopInfo",shopinfoService.selectShopInfo(shopInfo));
		return "views/shop-info/shopupdate";
	}
	
	
	@PostMapping("/shop-infos/update")
	public String updateShopInfo(Model model,@ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("msg","업데이트 완료");
		model.addAttribute("url","/shop-infos");
		if(shopinfoService.updateShopInfo(shopInfo)!=1) {
			model.addAttribute("msg","업데이트 실패");
			model.addAttribute("url","/views/shop-info/shopupdate?siNum="+shopInfo.getSiNum());
		}
		return "views/common/msg";
	}
	
	@PostMapping("/shop-infos/delete")
	public String deleteShopInfo(Model model,@ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("msg","삭제성공");
		model.addAttribute("url","/shop-infos");
		if(shopinfoService.deleteShopInfo(shopInfo.getSiNum())!=1) {
			model.addAttribute("msg","삭제 실패");
			model.addAttribute("url","/views/shop-info/shopupdate?siNum="+shopInfo.getSiNum());
		}
		return "views/common/msg";
	}
	
}
