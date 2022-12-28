package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.KtRolsterVO;

public interface KtRolsterMapper {
	List<KtRolsterVO> selectKtList(KtRolsterVO ktRolster);
	KtRolsterVO selectKt(KtRolsterVO ktRolster);
	int insertKt(KtRolsterVO ktRolster);
	int updateKt(KtRolsterVO ktRolster);
	int deleteKt(int ktNum);
}
