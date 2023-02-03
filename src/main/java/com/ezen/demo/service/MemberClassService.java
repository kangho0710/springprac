package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.MemberClassMapper;
import com.ezen.demo.vo.ClassInfoVO;
import com.ezen.demo.vo.MemberInfoClassInfoMapVO;
import com.ezen.demo.vo.MemberInfoVO;

@Service
public class MemberClassService {
	
	@Autowired
	private MemberClassMapper memberClassMapper;
	
	public List<MemberInfoVO> selectMemberInfo(MemberInfoVO memberInfo){
		return memberClassMapper.selectMemberInfo(memberInfo);
	}
	
	public List<ClassInfoVO> selectClassInfo(ClassInfoVO classInfo){
		return memberClassMapper.selectClassInfo(classInfo);
	}
	
	public List<MemberInfoClassInfoMapVO> selectMemberInfoClassInfoMap(MemberInfoClassInfoMapVO memberInfoClssInfoMap){
		return memberClassMapper.selectMemberInfoClassInfoMap(memberInfoClssInfoMap);
	}
	
	public int insertMemberInfo(List<MemberInfoVO> memberInfos) {
		int result = 0;
		for(MemberInfoVO memberInfo : memberInfos) {
			if(memberClassMapper.selectMemberInfoByMiNum(memberInfo)!=null) {
				throw new RuntimeException("멤버가 중복되었습니다");
			}
			result+= memberClassMapper.insertMemberInfo(memberInfo);
		}
		return result;
	}
	
	public int inserClassInfo(List<ClassInfoVO> classInfos) {
		int result = 0;
		for(ClassInfoVO classInfo : classInfos) {
			if(memberClassMapper.selectClassInfoByCiNum(classInfo)!=null) {
				throw new RuntimeException("멤버가 중복되었습니다");
			}
			result+= memberClassMapper.inserClassInfo(classInfo);
		}
		return result;
	}
	
	public int insertMemberInfoClassInfoMap(MemberInfoClassInfoMapVO memberInfoClssInfoMap) {
		return memberClassMapper.insertMemberInfoClassInfoMap(memberInfoClssInfoMap);
	}
}
