package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.demo.api.ApiFestivalInfo;
import com.ezen.demo.mapper.FestivalInfoMapper;
import com.ezen.demo.vo.fetival.FestivalInformationVO;

public class FestivalInfoService {
	@Autowired
	private FestivalInfoMapper festivalInfoMapper;
	
	@Autowired
	private ApiFestivalInfo apiFestivalInfo;
	
	public int insertFestival(List<FestivalInformationVO> festivalList) {
		return festivalInfoMapper.insertFestivalInfos(festivalList);
	}
	
	
}
