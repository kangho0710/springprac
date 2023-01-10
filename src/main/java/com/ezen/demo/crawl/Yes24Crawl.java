package com.ezen.demo.crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.ezen.demo.vo.BestSellerVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@PropertySource("classpath:env.properties")
public class Yes24Crawl {
	@Value("${yes24.url}")
	private String yes24Url;
	
	public List<BestSellerVO> crawlYes24() {
		
		List<BestSellerVO> bestSellerList = new ArrayList<>();
		for(int i=1; i<=5; i++) {
		try {
			Document document = Jsoup.connect(yes24Url+i).get();
//			log.debug("yes html=>{}", document.html());
			Elements els = document.select("#category_layout tr"); //document.querySelectorAll
			for(Element el : els) {
				Element imgEl =  el.selectFirst("td.image img"); //document.querylSelector 이미지
				if(imgEl!=null) { //두번째 tr에는 이미지 x
					Element numEl = el.selectFirst("td.num"); //번호
					Element titleEl =  el.selectFirst("td.goodsTxtInfo p a"); //document.querylSelector 제목
					Element pEl = el.selectFirst("td.goodsTxtInfo p"); //서브타이틀
					Element aupuEl = el.selectFirst("td.goodsTxtInfo>div.aupu");
//					log.debug("aupuEl=>{}", aupuEl);
					Element authorEl = el.selectFirst("td.goodsTxtInfo .aupu a");//작가
					
					Element dateEl =  el.selectFirst("td .aupu ");//발행일
					Element companyEl = (Element) el.selectFirst("td.goodsTxtInfo .aupu").childNode(3); //출판사
					Element linkEl = el.selectFirst("td.image a"); //링크
					Element secPEl = el.selectFirst("td.goodsTxtInfo p:nth-child(3)"); //가격
					
					BestSellerVO bsVO = new BestSellerVO();
					
					String num = numEl.text().replace(".", "").trim();
					bsVO.setBsNum(Integer.parseInt(num));
					
					String title = titleEl.text().trim();
					bsVO.setBsTitle(title);
					
					String subTitle = pEl.childNode(2).toString().trim();
					bsVO.setBsSubTitle(subTitle);
					
					String author = authorEl.text().trim();
					bsVO.setBsAuthor(author);
					
					String imgPath = imgEl.attr("src").trim();
					bsVO.setBsImg(imgPath);
					
					String publishing = companyEl.text().trim();
					bsVO.setBsPublisher(publishing);
					
					String str = dateEl.text();
					String[] day1 = str.split("\\|");
					String date = day1[2];
					bsVO.setBsDate(date);
					
					String price = secPEl.childNode(0).toString().replace("→", "").replace(",", "").replace("원", "").trim();
					bsVO.setBsPrice(Integer.parseInt(price));
					
					String url = "http://www.yes24.com" + titleEl.attr("href").trim();
					bsVO.setBsUrl(url);
//					log.debug("num=>{}",num);
//					log.debug("title=>{}",title);
//					log.debug("bbVO=>{}", bsVO);
//					log.debug("date=>{}",date);
					bestSellerList.add(bsVO);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //end of for(5)
	
	return bestSellerList;
	}
	
}
