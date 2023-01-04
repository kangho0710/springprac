package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.TestInfoService;
import com.ezen.demo.vo.TestInfoVO;

@Controller
public class TestInfoController {
	@Autowired
	private TestInfoService testInfoService;
	
	@GetMapping("/test-info/list")
	@ResponseBody
	public List<TestInfoVO> getTestInfoList(TestInfoVO testInfo){
		return testInfoService.getTestsInfoList(testInfo);
	}
	
	@GetMapping("/test-info/select")
	@ResponseBody
	public TestInfoVO getTestInfo(TestInfoVO testInfo) {
		return testInfoService.getTestInfo(testInfo);
	}
	
	@GetMapping("/test/{cnt}")
	@ResponseBody
	public String sleepTest(@PathVariable("cnt") int cnt) throws InterruptedException {
		Thread.sleep(cnt*1000);
		return "니가보낸 cnt" + cnt;
	}
}
