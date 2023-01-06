package com.ezen.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.api.ApiPapagoTranslate;
import com.ezen.demo.vo.MessageVO;
import com.ezen.demo.vo.PapagoParamVO;
import com.ezen.demo.vo.PapagoTranslateVO;
import com.ezen.demo.vo.PapagoVO;
import com.ezen.demo.vo.ResultVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class TranslateService {
	
	@Autowired
	private PapagoTranslateService papagoTranService;
	@Autowired
	private ApiPapagoTranslate apiPapagoTranslate;
	
	public PapagoVO translate(PapagoParamVO papagoParam) throws JsonMappingException, JsonProcessingException {
		PapagoVO papago = new PapagoVO(); //파파고vo생성
		PapagoTranslateVO pt = new PapagoTranslateVO();//db와 연결된 파파고 생성
		
		pt.setPtSource(papagoParam.getSource()); //db source세팅
		pt.setPtTarget(papagoParam.getTarget()); //db target세팅
		pt.setPtText(papagoParam.getText()); //db text세팅
		
		PapagoTranslateVO resultPt = papagoTranService.selectPapagoTranslate(pt); //resultPt는 select된 것
		
		if(resultPt==null) { //select가 되지 않았다면
			papago = apiPapagoTranslate.translate(papagoParam);//일반 파파고vo 번역
			pt.setPtResult(papago.getMessage().getResult().getTranslatedText()); //db와 연결된 파파고에 번역된 언어 세팅 
			papagoTranService.insertPapagoTranslate(pt); //db에 번역된 언어 삽입
			return papago;
		}
		//select가 되었다면(db에 있는것이라면)
		MessageVO message = new MessageVO();
		ResultVO result = new ResultVO();
		result.setTranslatedText(resultPt.getPtResult()); //db에 있는것에서 가져온다
		message.setResult(result);
		papago.setMessage(message);
		return papago;
	}
}
