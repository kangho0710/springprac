package com.ezen.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.demo.vo.SoccerGalleryVO;

public interface SoccerGalleryMapper {
	List<SoccerGalleryVO> selectSoccerGalleryList(SoccerGalleryVO soccerGallery);
	SoccerGalleryVO selectSoccerGallery(int soNum);
	int insertSoccerGallery(SoccerGalleryVO soccerGallery);
	int updateSoccerGallery(SoccerGalleryVO soccerGallery);
	int deleteSoccerGallery(int soNum);
	
	int deleteSoccerGalleries(@Param("soNums") List<Integer> soNums);
	
}
