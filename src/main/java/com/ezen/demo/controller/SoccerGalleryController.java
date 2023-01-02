package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.mapper.SoccerGalleryMapper;
import com.ezen.demo.vo.SoccerGalleryVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SoccerGalleryController {
	@Autowired
	SoccerGalleryMapper soccerGalleryMapper;
	
	@GetMapping("/soccergallery")
	@ResponseBody
	public List<SoccerGalleryVO> selectSoccerGalleryList(SoccerGalleryVO soccerGallery){
		return soccerGalleryMapper.selectSoccerGalleryList(soccerGallery);
	}
	
	@GetMapping("/soccergallery/select")
	@ResponseBody
	public SoccerGalleryVO selectSoccereGallery(int soNum) {
		return soccerGalleryMapper.selectSoccerGallery(soNum);
	}
}
