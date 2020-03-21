package com.temp.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.service.MemberService;
import com.temp.vo.MemberVO;

@Controller
public class MainController {

	@Resource(name="MemberService")
	private MemberService memberService;
	
	@RequestMapping(value="/Memberlist.do")
	public String memberlist(Model model) throws Exception{
		
		List<MemberVO> vo = memberService.memberlist();
		model.addAttribute("vo",vo);
		
		
		return "member/Memberlist";
	}
	
	@RequestMapping("/Main.do")
	public String Main() throws Exception{
		
		return "Main";
	}
	
}
