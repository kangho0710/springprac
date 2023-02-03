package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.ClassInfoVO;
import com.ezen.demo.vo.MemberInfoClassInfoMapVO;
import com.ezen.demo.vo.MemberInfoVO;

public interface MemberClassMapper {
	List<MemberInfoVO> selectMemberInfo(MemberInfoVO memberInfo);
	List<ClassInfoVO> selectClassInfo(ClassInfoVO classInfo);
	List<MemberInfoClassInfoMapVO> selectMemberInfoClassInfoMap(MemberInfoClassInfoMapVO memberInfoClssInfoMap);
	
	MemberInfoVO selectMemberInfoByMiNum(MemberInfoVO memberInfo);
	ClassInfoVO selectClassInfoByCiNum(ClassInfoVO classInfo);
	
	int insertMemberInfo(MemberInfoVO memberInfo);
	int inserClassInfo(ClassInfoVO classInfo);
	int insertMemberInfoClassInfoMap(MemberInfoClassInfoMapVO memberInfoClssInfoMap);
	
}
