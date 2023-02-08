package com.ezen.demo.controller.study;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.demo.service.MemberClassService;
import com.ezen.demo.vo.ClassInfoVO;
import com.ezen.demo.vo.MemberInfoClassInfoMapVO;
import com.ezen.demo.vo.MemberInfoVO;

@RestController
public class MemberClassController {
	@Autowired
	private MemberClassService memberClassService;
	
	@GetMapping("/member-list")
	public List<MemberInfoVO> selectMemberInfo(MemberInfoVO memberInfo){
		return memberClassService.selectMemberInfo(memberInfo);
	}
	
	@GetMapping("/class-list")
	public List<ClassInfoVO> selectClassInfo(ClassInfoVO classInfo){
		return memberClassService.selectClassInfo(classInfo);
	}
	
	@GetMapping("/member-class-info-list")
	public List<MemberInfoClassInfoMapVO> selectMemberInfoClassInfoMap(MemberInfoClassInfoMapVO memberInfoClssInfoMap){
		return memberClassService.selectMemberInfoClassInfoMap(memberInfoClssInfoMap);
	}
	
	@PostMapping("/member-insert")
	public int insertMemberInfo(@RequestBody List<MemberInfoVO> memberInfo) {
		return memberClassService.insertMemberInfo(memberInfo);
	}
	
	@PostMapping("/class-insert")
	public int inserClassInfo(@RequestBody List<ClassInfoVO> classInfo) {
		return memberClassService.inserClassInfo(classInfo);
	}
	
	@PostMapping("/member-class-info-insert")
	public int insertMemberInfoClassInfoMap(@RequestBody List<MemberInfoClassInfoMapVO> memberInfoClassInfoMap) {
		return memberClassService.insertMemberInfoClassInfoMap(memberInfoClassInfoMap);
	}
}
