package myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myspring.model.Board;
import myspring.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	//글작성 폼
	@RequestMapping("boardform.do")
	public String boardform() {
		return "/board/boardform";
	}
	
	//글작성
	@RequestMapping("boardwrite.do")
	public String boardwrite(@ModelAttribute Board board, Model model ) { 
		//@ModelAttribute Board board : 필드명과 컬럼명이 같으면 자동 입력, board에 앞에서 넘오곤 값이 들어있다
		//Model - view페이지로 값을 가져갈 때 사용
		
		int result = service.insert(board);
		if(result == 1) System.out.println("글작성 성공");
		
		model.addAttribute("result", result);
		
		return "board/insertresult";
	}
	
	//글목록
	@RequestMapping("boardlist.do")
	public String boardlist(@RequestParam(value="page", defaultValue="1") int page, Model model) {
		//page에 값이 없으면 기본 값으로 1설정
		//int page = 1; <- 이 구문이 없어진다
		
		int limit = 10;
		int listcount = service.getCount();
		System.out.println("listcount:"+listcount);
		Board list = service.getBoardList(page);
		System.out.println(list);
		return "";
	}
}
