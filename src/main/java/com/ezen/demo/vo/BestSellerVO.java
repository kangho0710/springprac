package com.ezen.demo.vo;

import lombok.Data;

@Data
public class BestSellerVO {
	private int bsNum;
	private String bsImg;
	private String bsTitle;
	private String bsSubTitle;
	private String bsAuthor;
	private String bsPublisher;
	private String bsDate;
	private int bsPrice;
	private String bsUrl;
	private String bsCredat;
	private int page;
	private int rows;
}
