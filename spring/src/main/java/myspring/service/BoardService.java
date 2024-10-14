package myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.dao.BoardDao;
import myspring.model.Board;

@Service
public class BoardService {
	
	@Autowired 
	private BoardDao dao;

	public int insert(Board board) {
		return dao.insert(board);
	}

	public int getCount() {
		return dao.getCount();
	}

	public List<Board> getBoardList(int page) {
		// TODO Auto-generated method stub
		return dao.getBoardList(page);
	}

	public void updatecount(int no) {
		dao.updatecount(no);
	}

	public Board getBoard(int no) {
		// TODO Auto-generated method stub
		return dao.getBoard(no);
	}

	public int update(Board board) {
		// TODO Auto-generated method stub
		return dao.update(board);
	}

	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.delete(no);
	}
}
