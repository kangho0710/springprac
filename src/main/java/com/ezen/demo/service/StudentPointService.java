package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.StudentPointMapper;
import com.ezen.demo.vo.StudentPointVO;

@Service
public class StudentPointService {
	
	@Autowired
	private StudentPointMapper studentPointMapper;
	
	public List<StudentPointVO> getStudentPointList(StudentPointVO studentPointVO){
		return studentPointMapper.selectStudentPointList(studentPointVO);
	}
	
	public StudentPointVO getStudentPoint(int spNum) {
		return studentPointMapper.selectStudentPoint(spNum);
	}
	
	public int insertStudentPoint(StudentPointVO studentPointVO) {
		return studentPointMapper.insertStudentPoint(studentPointVO);
	}
	
	public int updateStudentPoint(StudentPointVO studentPointVO) {
		return studentPointMapper.updateStudentPoint(studentPointVO);
	}
	
	public int deleteStudentPoint(StudentPointVO studentPointVO) {
		return studentPointMapper.deleteStudentPoint(studentPointVO);
	}
}
