package com.temp.service;

import java.util.List;

import com.temp.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberlist() throws Exception;
}
