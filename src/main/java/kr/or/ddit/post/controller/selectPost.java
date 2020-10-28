package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.pagingVO;
import kr.or.ddit.post.model.postVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;
import kr.or.ddit.replys.controller.replyinsert;
import kr.or.ddit.replys.model.replyVO;
import kr.or.ddit.replys.service.replyService;
import kr.or.ddit.replys.service.replySeviceI;

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
    	String board_name = request.getParameter("board_name");
    	int board_id = Integer.parseInt(request.getParameter("board_id"));
    	
    	logger.debug("board_name : {}",board_name );
    	logger.debug("board_id : {}",board_id );

    	String page_str = request.getParameter("page");
    	int page = page_str == null ? 1 : Integer.parseInt(page_str);
    	request.setAttribute("page", page);
    	
    	String page_size = request.getParameter("pageSize");
		int pageSize = page_size == null ? 10 : Integer.parseInt(page_size);
		request.setAttribute("pageSize", pageSize);
    	
    	pagingVO pv = new pagingVO();
    	pv.setPage(page);
    	pv.setPageSize(pageSize);
    	pv.setBoard_id(board_id);
    	
    	 
    	Map<String, Object> map = postService.selectPostList(pv);
    	
    	request.setAttribute("postList", map.get("postList"));
    	request.setAttribute("pages", map.get("pages"));
    	request.setAttribute("pageSize", map.get("pageSize"));
    	request.setAttribute("board_name", board_name);
    	request.setAttribute("board_id", board_id);
    	request.getRequestDispatcher("/board/post.jsp").forward(request, response);
	
	

    
    }
	

}
