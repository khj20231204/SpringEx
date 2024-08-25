package com.fastcampus.ch2;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws Exception {
		
		int n = (int)((Math.random()*6)+1);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice"+n+".jpg'>"); 
		out.println("</body>");
		out.println("</html>");
	}
}
