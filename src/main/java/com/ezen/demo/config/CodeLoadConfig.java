package com.ezen.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ezen.demo.mapper.AddressMapper;
import com.ezen.demo.vo.AddressVO;
import com.ezen.demo.vo.DongVO;
import com.ezen.demo.vo.GugunVO;
import com.ezen.demo.vo.SidoVO;

@Configuration
public class CodeLoadConfig {
	@Autowired
	private AddressMapper addressMapper;
	
	
	@Bean
	List<SidoVO> sidoList(){
		return addressMapper.selectSidoList(null);
	}
	
	@Bean
	List<GugunVO> gugunList(){
		return addressMapper.selectGugunList(null);
	}
	
	@Bean
	List<DongVO> dongList(){
		return addressMapper.selectDongList(null);
	}
	
	@Bean
	List<AddressVO> addressList(){
		return addressMapper.addressList(null);
	}
}
