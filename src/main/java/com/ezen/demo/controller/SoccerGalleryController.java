package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.SoccerGalleryService;
import com.ezen.demo.vo.SoccerGalleryVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SoccerGalleryController {
	@Autowired
	private SoccerGalleryService soccerGalleryService;
	
	@GetMapping("/soccergallery")
	@ResponseBody
	public List<SoccerGalleryVO> selectSoccerGalleryList(SoccerGalleryVO soccerGallery){
		return soccerGalleryService.selectSoccerGalleryList(soccerGallery);
	}
	
	@GetMapping("/soccergallery/select")
	@ResponseBody
	public SoccerGalleryVO selectSoccereGallery(int soNum) {
		return soccerGalleryService.selectSoccerGallery(soNum);
	}
	
	@GetMapping("/soccergallery/update")
	@ResponseBody
	public SoccerGalleryVO selectSoccereGallery2(int soNum) { //업뎃용 화면
		return soccerGalleryService.selectSoccerGallery(soNum);
	}
	
	@PostMapping("/soccergallery/insert")
	@ResponseBody
	public int insertSoccerGallery(@RequestBody SoccerGalleryVO soccerGallery) {
		return soccerGalleryService.insertSoccerGallery(soccerGallery);
	}
	
	@DeleteMapping("/soccergallery/delete/{soNum}")
	@ResponseBody
	public int deleteSoccerGallery(@PathVariable("soNum") int soNum) {
		return soccerGalleryService.deleteSoccerGallery(soNum);
	}
	
	
	@DeleteMapping("/soccergallery/deletes")
	@ResponseBody
	public int deleteSoccerGalleries(@RequestBody SoccerGalleryVO soccerGallery) {
		return soccerGalleryService.deleteSoccerGalleries(soccerGallery.getSoNums());
	}
	
	@PatchMapping("/soccergallery/update/{soNum}")
	@ResponseBody
	public int updateSoccerGallery(@RequestBody SoccerGalleryVO soccerGallery,  @PathVariable("soNum") int soNum) {
		soccerGallery.setSoNum(soNum);
		return soccerGalleryService.updateSoccerGallery(soccerGallery);
	}
}
