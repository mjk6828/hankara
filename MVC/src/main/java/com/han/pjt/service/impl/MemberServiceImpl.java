package com.han.pjt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.han.pjt.dao.MemberDAO;
import com.han.pjt.service.MemberService;
import com.han.pjt.vo.MemberVO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="MemberDAO")
	private MemberDAO memberDAO;
	
	
	@Override
	public List<MemberVO> memberlist() throws Exception {
	
		return memberDAO.memberlist();
	}

}
