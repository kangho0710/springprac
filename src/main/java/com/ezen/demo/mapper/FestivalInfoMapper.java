package com.ezen.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.demo.vo.fetival.FestivalInformationVO;

public interface FestivalInfoMapper {
	int insertFestivalInfos(@Param("festivalList") List<FestivalInformationVO> festivalList);
	List<FestivalInformationVO> selectFestivalInfos(FestivalInformationVO festivalVO);
}
