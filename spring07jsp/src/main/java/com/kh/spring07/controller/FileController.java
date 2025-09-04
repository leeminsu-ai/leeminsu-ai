package com.kh.spring07.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring07.dao.AttachmentDao;
import com.kh.spring07.dto.AttachmentDto;

@Controller
@RequestMapping("/file")
public class FileController {
	@Autowired
	private AttachmentDao attachmentDao;
	@RequestMapping("/test01")
	public String test01() {
		return "/WEB-INF/views/file/test01.jsp";
	}
	
	@GetMapping("/test02")
	public String test02(@RequestParam String uploader,@RequestParam String attach) {
		System.out.println("attach="+attach);
		return "redirect:test01";
	}
	
	@PostMapping("/test03")
	public String test03(@RequestParam String uploader,@RequestParam String attach) {
		System.out.println("attach="+attach);
		return "redirect:test01";
	}
	
	//Multipart 방식을 전송되는 데이터를 수신
	//-기존 정보는 기존방법그대로 수신가능
	//파일정보는 MultipartFile 클래스로 한번에 수신가능
	@PostMapping("/test04")
	public String test04(@RequestParam String uploader,@RequestParam MultipartFile attach) throws  IOException {
		System.out.println("uploader="+uploader);
		//System.out.println(attach.getName());
		System.out.println(attach.getOriginalFilename());
		System.out.println(attach.getSize());
		System.out.println(attach.getContentType());
		
		
		if(attach.isEmpty()==false) {//attach가 비어있지 않다면(=있다면)
			int attachmentNo=attachmentDao.sequence();
			File home = new File(System.getProperty("user.home")); //사용자의 기본폴더
			File upload=new File(home,"upload"); //업로드할 폴더
			if(upload.exists()==false) {
				upload.mkdirs();
			}
			File target = new File(upload,String.valueOf(attachmentNo)); //저장할 파일의 인스턴스
			attach.transferTo(target); //저장하세요!
		
		//파일을 저장하려면 파일 인스턴스가 필요
		//
		
		AttachmentDto attachmentDto=new AttachmentDto();
		attachmentDto.setAttachmentNo(attachmentNo);
	
		attachmentDto.setAttachmentName(attach.getOriginalFilename());
		attachmentDto.setAttachmentType(attach.getContentType());
		attachmentDto.setAttachmentSize(attach.getSize());
		
		attachmentDao.insert(attachmentDto);
		
		
		
		
	

}
		return "redirect:test01";
}
}