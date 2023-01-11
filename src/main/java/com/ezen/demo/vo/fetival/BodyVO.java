package com.ezen.demo.vo.fetival;

import lombok.Data;

@Data
public class BodyVO {
	private ItemsVO itmes;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
}
