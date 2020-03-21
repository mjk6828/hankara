package com.temp.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.temp.dao.MemberMapper;
import com.temp.service.MemberService;
import com.temp.vo.MemberVO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="MemberMapper")
	private MemberMapper memberMapper;
	
	
	@Override
	public List<MemberVO> memberlist() throws Exception {
	
		return memberMapper.memberlist();
	}

}
