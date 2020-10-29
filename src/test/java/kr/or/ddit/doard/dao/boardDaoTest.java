package kr.or.ddit.doard.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVO;

public class boardDaoTest {
	BoardDaoI boardDao;

	@Before
	public void setup() {
		/*** Given ***/
		boardDao = new BoardDao();

	}

	@Test
	public void selectBoardTest() {
		/*** Given ***/

		/*** When ***/
		List<BoardVO> boList = boardDao.selectAllBoard();
		/*** Then ***/
		// assertEquals(5, boList.size());
	}

	@Test
	public void insertBoardTest() {
		/*** Given ***/

		/*** When ***/
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_name("테스트코드진행(게시판생성)");
		boardVO.setBoard_status("0");
		boardVO.setMem_id("bani");
		int res = boardDao.insertBoard(boardVO);
		/*** Then ***/
		assertEquals(1, res);
	}

	@Test
	public void updateBoardTest() {
		/*** Given ***/

		/*** When ***/
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_name("테스트코드진행중(게시판수정dd)");
		boardVO.setBoard_status("0");
		boardVO.setBoard_id(74);
		int res = boardDao.updateBoard(boardVO);
		/*** Then ***/
		assertEquals(1, res);
	}

}
