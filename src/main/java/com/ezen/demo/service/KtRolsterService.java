package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.KtRolsterMapper;
import com.ezen.demo.vo.KtRolsterVO;

@Service
public class KtRolsterService {
	
	@Autowired
	private KtRolsterMapper ktRolsterMapper;
	
	public List<KtRolsterVO> getKtRolsterList(KtRolsterVO ktRolster){
		return ktRolsterMapper.selectKtList(ktRolster);
	}
	
	public KtRolsterVO getKtRolster(KtRolsterVO ktRolster) {
		return ktRolsterMapper.selectKt(ktRolster);
	}
	
	public int insertKt(KtRolsterVO ktRolster) {
		return ktRolsterMapper.insertKt(ktRolster);
	}
	
	public int updateKt(KtRolsterVO ktRolster) {
		return ktRolsterMapper.updateKt(ktRolster);
	}
	
	public int deleteKt(int ktNum) {
		return ktRolsterMapper.deleteKt(ktNum);
	}
}
