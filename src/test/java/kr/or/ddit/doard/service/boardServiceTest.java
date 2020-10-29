package kr.or.ddit.doard.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

public class boardServiceTest {
	BoardServiceI boardService;
	
	@Before
	public void setup() {
		/*** Given ***/
		boardService = new BoardService();
	}
	
	@Test
	public void selectBoardTest() {
		/*** Given ***/

		/*** When ***/
		List<BoardVO> boList = boardService.selectAllBoard();
		/*** Then ***/
		 assertEquals(6, boList.size());
	}

	@Test
	public void insertBoardTest() {
		/*** Given ***/

		/*** When ***/
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_name("테스트코드진행(게시판생성2)");
		boardVO.setBoard_status("0");
		boardVO.setMem_id("bani");
		int res = boardService.insertBoard(boardVO);
		/*** Then ***/
		assertEquals(1, res);
	}

	@Test
	public void updateBoardTest() {
		/*** Given ***/

		/*** When ***/
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_name("테스트코드진행중(게시판수정dd2)");
		boardVO.setBoard_status("1");
		boardVO.setBoard_id(75);
		int res = boardService.updateBoard(boardVO);
		/*** Then ***/
		assertEquals(1, res);
	}

}
