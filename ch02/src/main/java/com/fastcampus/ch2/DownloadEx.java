package com.fastcampus.ch2;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadEx {
	
	@RequestMapping("/download")
	public String downLoad(HttpServletRequest request, @RequestParam(required=false, defaultValue="")String type) {
		List<User> userList = getUserList();
		request.setAttribute("data", userList);
		
		if(type.equals("pdf")) {
			return "forward:/pdfView";
		}else if(type.equals("csv")) {
			return "forward:/csvView";
		}else {
			return "forward:/txtView";
		}
	}
	
	public List<User> getUserList(){
		List<User> list = new ArrayList<User>();
		return list;
	}
}
