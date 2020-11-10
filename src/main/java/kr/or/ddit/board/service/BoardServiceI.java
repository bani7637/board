package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;


public interface BoardServiceI {
	// 게시판가져오는 메서드
	List<BoardVO> selectBoard();
	List<BoardVO> selectAllBoard();
	
	// 게시판 생성하는 메서드
	int insertBoard(BoardVO boardVO);
	
	// 게시판 수정하는 메서드
	int updateBoard(BoardVO boardVO);
}
