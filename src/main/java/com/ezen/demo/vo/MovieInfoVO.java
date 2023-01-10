package com.ezen.demo.vo;

import lombok.Data;

@Data
public class MovieInfoVO {
	private int miNum;
	private String miTitle;
	private String miDate;
	private int miOutput;
	private int miCrowd;
	private int miScreen;
	private String miCredat;
	
	private int page;
	private int rows;
}
