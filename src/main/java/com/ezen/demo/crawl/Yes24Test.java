package com.ezen.demo.crawl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Yes24Test {
	private final static String URL = "http://www.yes24.com/24/Category/BestSeller?CategoryNumber=001&sumgb=06";
	
	public static void main(String[] args) {
		try {
			Document document = Jsoup.connect(URL).get();
			log.debug("yes html=>{}", document.html());
			Elements els = document.select("#category_layout tr"); //document.querySelectorAll
			for(Element el : els) {
				Element imgEl =  el.selectFirst("td.image img"); //document.querylSelector 이미지
				if(imgEl!=null) { //두번째 tr에는 이미지 x
					Element titleEl =  el.selectFirst("td.goodsTxtInfo p a"); //document.querylSelector 제목
//					log.debug("titleEl=>{}", titleEl.text());  
//					log.debug("img src=>{}", imgEl.attr("src")); 
					Element pEl = el.selectFirst("td.goodsTxtInfo p");
//					log.debug("sub title=>{}", pEl.childNode(2)); //서브타이틀
					Element writeEl = el.selectFirst("td.goodsTxtInfo .aupu a");//작가
//					log.debug("writer =>{}", writeEl.text());
					Element dateEl = el.selectFirst("td.goodsTxtInfo .aupu");//발행일
//					log.debug("date =>{}", dateEl.childNode(4));
					Element companyEl = (Element) el.selectFirst("td.goodsTxtInfo .aupu").childNode(3); //출판사
//					log.debug("company=>{}",companyEl.text());
					Element numEl = el.selectFirst("td.num"); //번호
//					log.debug("num=>{}", numEl.text());
					Element linkEl = el.selectFirst("td.image a"); //링크
//					log.debug("link=>{}","htttp://www.yes24.com"+linkEl.attr("href"));
					Element secPEl = el.selectFirst("td.goodsTxtInfo p:nth-child(3)"); //가격
//					log.debug("lastPel=>{}",secPEl.childNode(0).toString().replace("->",""));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
