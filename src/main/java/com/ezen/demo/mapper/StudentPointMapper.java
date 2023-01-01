package com.ezen.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.demo.vo.StudentPointVO;
//안적어도 됨
@Mapper
public interface StudentPointMapper {
	
	List<StudentPointVO> selectStudentPointList(StudentPointVO studentPointVO);
	StudentPointVO selectStudentPoint(int spNum);
	int insertStudentPoint(StudentPointVO studentPointVO);
	int updateStudentPoint(StudentPointVO studentPointVO);
	int deleteStudentPoint(int spNum);
}
