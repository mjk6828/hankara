package com.han.pjt.dao;

import java.util.List;

import com.han.pjt.vo.MemberVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("MemberDAO")
public interface MemberDAO {

	List<MemberVO> memberlist() throws Exception;
}
