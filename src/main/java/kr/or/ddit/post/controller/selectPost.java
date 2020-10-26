package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.postVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

@WebServlet("/selectPost")
public class selectPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostServiceI postService;
    private static final Logger logger = LoggerFactory.getLogger(selectPost.class);
    
    @Override
    public void init() throws ServletException {
    	postService = new PostService();
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int board_id = Integer.parseInt(request.getParameter("board_id"));
	logger.debug("board_id:{}",board_id);
	
	List<postVO> postList = postService.selectPost(board_id);
	
	request.setAttribute("postList", postList);
	request.getRequestDispatcher("/board/post.jsp").forward(request, response);
    }
	

}
