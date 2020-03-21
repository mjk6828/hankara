package com.temp.dao;

import java.util.List;

import com.temp.vo.MemberVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;


@Mapper("MemberMapper")
public interface MemberMapper {

	
	List<MemberVO> memberlist() throws Exception;
}
