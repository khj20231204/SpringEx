package myspring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myspring.model.Board;


public interface BoardDao {

	int insert(Board board);

	int getCount();

	Board getBoardList(int page);
	
	
}
