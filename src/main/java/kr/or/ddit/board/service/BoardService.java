package kr.or.ddit.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVO;

public class BoardService implements BoardServiceI{
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	private BoardDaoI boardDao;
	
	public BoardService() {
		boardDao = new BoardDao();
	}

	@Override
	public List<BoardVO> selectBoard() {
		return boardDao.selectBoard();
	}
	@Override
	public List<BoardVO> selectAllBoard() {
		return boardDao.selectAllBoard();
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardDao.insertBoard(boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardDao.updateBoard(boardVO);
	}

	

	
}
