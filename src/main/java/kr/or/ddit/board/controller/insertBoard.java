package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/insertBoard")
public class insertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(insertBoard.class);
	private BoardServiceI boardService;

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/board/insertboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String board_name = request.getParameter("board_name");
		String mem_id = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			logger.debug("cookieName : {}, value : {}", cookie.getName(), cookie.getValue());
			mem_id = cookie.getValue();
		}
		String board_status = request.getParameter("board_status");
		logger.debug("board_s:{},{}",board_status,board_name);

		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_name(board_name);
		boardVO.setMem_id(mem_id);
		boardVO.setBoard_status(board_status);
		int res = boardService.insertBoard(boardVO);
		if (res == 1) {
			response.sendRedirect(request.getContextPath() + "/boardAllList");
		} else {
			doGet(request, response);
		}
	}

}
