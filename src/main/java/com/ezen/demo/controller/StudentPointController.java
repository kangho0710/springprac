package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/student-points")
	@ResponseBody
	public int insertStudentPoint(@RequestBody StudentPointVO studentPoint) {
		return studentPointService.insertStudentPoint(studentPoint);
	}
}
