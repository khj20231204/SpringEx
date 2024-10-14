package myspring.controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
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
		System.out.println(listcount);
		
		int startRow = (page-1)*limit + 1;
		int endRow = page * limit;
		
		//startRow, endRow로 게시판 목록 10개 구하기
		//List<Board> boardlist = service.getBoardList(startRow, endRow);
		//xml파일에 매개변수 2개를 전달 못함
		List<Board> boardlist = service.getBoardList(page); //page만 넘겨주기 때문에 limit=10으로 계산을 해야 한다.
		System.out.println(boardlist);
		
		int pageCount = listcount / limit + ((listcount%10 == 0) ? 0 : 1);
		
		int startPage = ((page - 1)/10) * limit + 1;
		int endPage = startPage + 10 - 1;
	
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/boardlist";
	}
	
	//글상세 : 조회수 1증가 + 상세정보 구하기
	@RequestMapping("boardcontent.do")
	public String boardcontent(@RequestParam("no") int no, 
								@RequestParam("page") String page,
								Model model) {
		
		//조회수 1증가 - update
		service.updatecount(no);  //조회수 1증가
		
		//상세정보 불러오기 - select
		Board board = service.getBoard(no); //상세 글 가져오기
		String content = board.getContent().replace("\n", "<br>");
		
		model.addAttribute("board", board);
		model.addAttribute("content", content);
		model.addAttribute("page", page);
		
		return "board/boardcontent";
	}
	
	//수정 폼
	@RequestMapping("boardupdateform.do")
	public String boardupdateform(@RequestParam("no") int no, @RequestParam("page") String page, Model model) {
		
		Board board = service.getBoard(no); //상세 글 가져오기
		
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		
		return "board/boardupdateform";
	}
	
	//수정
	@RequestMapping("boardupdate.do")
	public String boardupdate(@ModelAttribute Board board,
								@RequestParam("page") String page,
								Model model) {
		
		//비번을 비교하기 위해서 db를 가져온다.
		Board db = service.getBoard(board.getNo());
		
		System.out.println("db:"+db);
		
		int result = 0;
		//비번 비교
		if(db.getPasswd().equals(board.getPasswd())) { //비번 일치시
			result = service.update(board);  //update SQL문 실행
		}else {  //비번 불일치시
			result = -1;
		}

		model.addAttribute("result", result);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		
		return "board/updateresult";
	}
	
	//글삭제 폼
	@RequestMapping("boarddeleteform.do")
	public String boarddeleteform() {
		//서비스로 안 가로 바로 return
		/*원래는 여기서 Model model로 boarddeleteform.jsp에 page와 no를 넘겨야하는데
		 * boarddeleteform.jsp에서 바로 ${param.no}, ${param.page}로 바로 받는다
		 * */
		return "board/boarddeleteform";
	}
	
	//글 삭제
	@RequestMapping("boarddelete.do")
	public String boarddelete(@ModelAttribute Board board,
								@RequestParam("page") String page,
								Model model) {
	
		//no에 해당하는 board 불러오기
		Board db = service.getBoard(board.getNo()); //4번 사용
		
		int result = 0;
		
		//비번 비교
		if(db.getPasswd().equals(board.getPasswd())) {
			result = service.delete(board.getNo());  //delete SQL문 실행
		}else {
			result = -1;
		}
		
		model.addAttribute("page",page);
		model.addAttribute("result",result);
		
		return "";
	}
}
