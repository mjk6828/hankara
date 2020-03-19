package com.han.pjt.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.han.pjt.service.MemberService;
import com.han.pjt.vo.MemberVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MainController {

	@Resource(name="MemberService")
	private MemberService memberService;
	
	
	@RequestMapping("/member.do")
	public String member(Model model) throws Exception{
		
		List<MemberVO> vo = memberService.memberlist();
		model.addAttribute("vo",vo);
		
		return "member/member";
	}
	
	@RequestMapping("/Main.do")
	public String Main() throws Exception{
		log.info("Main Page");
		return "Main";
	}
	@RequestMapping("/Login.do")
	public String Login(Model model, MemberVO vo) {
		
		return "member/member";
	}
}
