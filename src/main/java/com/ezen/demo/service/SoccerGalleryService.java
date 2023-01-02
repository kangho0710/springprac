package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.SoccerGalleryMapper;
import com.ezen.demo.vo.SoccerGalleryVO;

@Service
public class SoccerGalleryService {
	@Autowired
	SoccerGalleryMapper soccerGalleryMapper;
	
	List<SoccerGalleryVO> selectSoccerGalleryList(SoccerGalleryVO soccerGallery){
		return soccerGalleryMapper.selectSoccerGalleryList(soccerGallery);
	}
	SoccerGalleryVO selectSoccerGallery(int soNum) {
		return soccerGalleryMapper.selectSoccerGallery(soNum);
	}
	
	public int insertSoccerGallery(SoccerGalleryVO soccerGallery) {
		return soccerGalleryMapper.insertSoccerGallery(soccerGallery);
	}
	public int updateSoccerGallery(SoccerGalleryVO soccerGallery) {
		return soccerGalleryMapper.updateSoccerGallery(soccerGallery);
	}
	
	public int deleteSoccerGallery(int soNum) {
		return soccerGalleryMapper.deleteSoccerGallery(soNum);
	}
}
