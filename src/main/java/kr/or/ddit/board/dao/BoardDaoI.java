package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

public interface BoardDaoI {

	List<BoardVO> selectBoard();
	List<BoardVO> selectAllBoard();
	int insertBoard(BoardVO boardVO);
	int updateBoard(BoardVO boardVO);
}
