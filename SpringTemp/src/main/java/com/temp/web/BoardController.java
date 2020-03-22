package com.temp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String boardwrite(Model model) throws Exception{
		
		return "board/writeForm";
	}
}
