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
}
