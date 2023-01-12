package com.ezen.demo.vo.fetival;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyVO {
	private ItemsVO items;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
}
