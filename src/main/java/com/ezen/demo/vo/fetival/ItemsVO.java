package com.ezen.demo.vo.fetival;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class ItemsVO {
	private List<FestivalInformationVO> item;
}
