package com.ezen.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.demo.vo.AddressVO;
import com.ezen.demo.vo.DongVO;
import com.ezen.demo.vo.GugunVO;
import com.ezen.demo.vo.SidoVO;

@RestController
public class AddressController {
	@Autowired
	private List<SidoVO> sidoList;
	@Autowired
	private List<GugunVO> gugunList;
	@Autowired
	private List<DongVO> dongList;
	
	@GetMapping("/sido")
	public List<SidoVO> getSidoList(){
		return sidoList;
	}
	
	@GetMapping("/gugun/{siNum}")
	public List<GugunVO> getGugunList(@PathVariable int siNum){
		List<GugunVO> tmpGugunList = new ArrayList<>();
		for(GugunVO gugun : gugunList) {
			if(gugun.getSiNum() == siNum) {
				tmpGugunList.add(gugun);
			}
		}
		return tmpGugunList;
	}
	
	@GetMapping("/dong/{guNum}")
	public List<DongVO> getDongList(@PathVariable int guNum){
		List<DongVO> tmpDongList = new ArrayList<>();
		for(DongVO dong : dongList) {
			if(dong.getGuNum() == guNum) {
				tmpDongList.add(dong);
			}
		}
		return tmpDongList;
	}
	
	@GetMapping("/address")
	public AddressVO getAddressList(AddressVO addressVO){
		addressVO.setDongList(dongList);
		addressVO.setGugunList(gugunList);
		addressVO.setSidoList(sidoList);
		return addressVO;
	}
	
}
