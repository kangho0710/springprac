package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.StudentPointService;
import com.ezen.demo.vo.StudentPointVO;

@Controller
public class StudentPointController {
	
	@Autowired
	private StudentPointService studentPointService;
	
	@GetMapping("/student-points")
	@ResponseBody //자동으로 json
	public List<StudentPointVO> getStudentPoints(StudentPointVO studentPoint){
		return studentPointService.getStudentPointList(studentPoint);
	}
	
	@GetMapping("/student-points/view")
	@ResponseBody
	public StudentPointVO getStudentPoint(int spNum) {
		return studentPointService.getStudentPoint(spNum);
	}
	
	@GetMapping("/student-points/update") //업데이트화면
	@ResponseBody
	public StudentPointVO getStudentPoint2(int spNum) {
		return studentPointService.getStudentPoint(spNum);
	}
	
	@PostMapping("/student-points")
	@ResponseBody
	public int insertStudentPoint(@RequestBody StudentPointVO studentPoint) {
		return studentPointService.insertStudentPoint(studentPoint);
	}
	
	@PatchMapping("/student-points/update/{spNum}")
	@ResponseBody
	public int updateStudentPoint(@RequestBody StudentPointVO studentPoint, @RequestBody @PathVariable("spNum") int spNum){
		studentPoint.setSpNum(spNum);
		
		return studentPointService.updateStudentPoint(studentPoint);
	}
	
	@DeleteMapping("/student-points/delete/{spNum}")
	@ResponseBody
	public int deletStudentPoint(@RequestBody @PathVariable("spNum") int spNum) {
		return studentPointService.deleteStudentPoint(spNum);
	}
}
