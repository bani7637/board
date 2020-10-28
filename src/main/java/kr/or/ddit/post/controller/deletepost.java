package kr.or.ddit.post.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

@WebServlet("/deletepost")

public class deletepost extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(deletepost.class);
    private PostServiceI postService;
    
    @Override
    public void init() throws ServletException {
    	postService = new PostService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int post_id= Integer.parseInt(request.getParameter("post_id"));
		int board_id= Integer.parseInt(request.getParameter("board_id"));
		int res = postService.deletePost(post_id);
		logger.debug("postId : {}",post_id);
		if(res>=1) {
			response.sendRedirect(request.getContextPath() + "/selectPost?board_id=" + board_id + "");
		}else {
			request.getRequestDispatcher("/post/postIn.jsp").forward(request, response);
		}
	}

}
