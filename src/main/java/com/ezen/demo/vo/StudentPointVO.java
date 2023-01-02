package com.ezen.demo.vo;

import java.util.List;

import lombok.Data;


@Data
public class StudentPointVO {
	private int spNum;
	private String spName;
	private int spKorPoint;
	private int spKorPoint1;
	private int spKorPoint2;
	
	private int spEngPoint;
	private int spEngPoint1;
	private int spEngPoint2;
	
	private int spMathPoint;
	private int spMathPoint1;
	private int spMathPoint2;
	
	private int spTotalPoint;
	private int spTotalPoint1;
	private int spTotalPoint2;
	
	private String spProfile;
	private List<Integer> spNums;
}
