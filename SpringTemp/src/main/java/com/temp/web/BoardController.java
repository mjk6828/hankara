package com.temp.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.temp.service.Impl.FileUploadService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class BoardController {

	@RequestMapping("/file.do")
	public String file() {
		return "fileupload/fileupload";
	}
	
	@RequestMapping(value = "/fileupload.do", method = RequestMethod.POST)
	public void boardwrite(MultipartFile uploadfile, Model model) throws Exception{
		
	log.info("upload() POST 호출");
	log.info("파일 이름: {}",uploadfile.getOriginalFilename());
	log.info("파일 크기: {}",uploadfile.getSize());
	
	String result = saveFile(uploadfile);
	if(result != null) {//파일 저장 성공
		model.addAttribute("result",result);
	}else {//파일 저장 실패
		model.addAttribute("resoult","fail");
	}
	}
	//저장경로
	private static final String UPLOAD_PATH = "D:\\fileupload";
	
	private String saveFile(MultipartFile file) {

		//파일 이름 변경
		UUID uuid = UUID.randomUUID();
		String saveName = uuid + "_" + file.getOriginalFilename();
		log.info("saveName: {}",saveName);
		
		//저장할 file 객체를 생성(껍데기 파일)
		File saveFile = new File(UPLOAD_PATH,saveName);
		
		try {
			file.transferTo(saveFile);
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return saveName;
	}
}
