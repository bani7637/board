package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardAllList")
public class BoardListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceI boardService;

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardVO> boardList2 = boardService.selectAllBoard();
		request.setAttribute("boardList2", boardList2);
		request.getRequestDispatcher("/board/updateboard.jsp").forward(request, response);

	}
}