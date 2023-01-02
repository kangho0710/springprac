package com.ezen.demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class SoccerGalleryVO {
	private int soNum;
	private String soId;
	private String soTitle;
	private String soContent;
	private String soTeam;
	private int soCnt;
	private String credat;
	private String moddat;
	
	private List<Integer> soNums;
}
