package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.AddressVO;
import com.ezen.demo.vo.DongVO;
import com.ezen.demo.vo.GugunVO;
import com.ezen.demo.vo.SidoVO;

public interface AddressMapper {
	List<SidoVO> selectSidoList(SidoVO sido);
	List<GugunVO> selectGugunList(GugunVO gugun);
	List<DongVO> selectDongList(DongVO dong);
	List<AddressVO> addressList(AddressVO address);
}
