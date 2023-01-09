package com.ezen.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestScheduler {
	
	@Scheduled(cron="0/10 * * * * *") //10초마다
	public void test() {
		log.debug("schedule test");
	}
}
