package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/updateBoard")
public class updateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(updateBoard.class);
	private BoardServiceI boardService;

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/updateboard.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String board_name = request.getParameter("board_name");
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String board_status = request.getParameter("board_status");
		logger.debug("board : {},{},{}", board_name, board_status, board_id);
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_id(board_id);
		boardVO.setBoard_name(board_name);
		boardVO.setBoard_status(board_status);
		int res = boardService.updateBoard(boardVO);

		if (res == 1) {
			response.sendRedirect(request.getContextPath() + "/boardAllList");
		} else {
			// 화면요청
			doGet(request, response);
		}
	}
}