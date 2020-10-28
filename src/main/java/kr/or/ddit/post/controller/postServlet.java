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

import kr.or.ddit.file.model.fileVO;
import kr.or.ddit.file.service.FileupService;
import kr.or.ddit.file.service.FileupServiceI;
import kr.or.ddit.post.model.postVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;
import kr.or.ddit.replys.model.replyVO;
import kr.or.ddit.replys.service.replyService;
import kr.or.ddit.replys.service.replySeviceI;

@WebServlet("/post")
public class postServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostServiceI postService;
	private FileupServiceI fileService;
	private replySeviceI replySevice;
	private static final Logger logger = LoggerFactory.getLogger(postServlet.class);
       
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
		fileService = new FileupService();
		replySevice = new replyService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		logger.debug("post_id :{}",post_id);
			postVO postVO = postService.getPost(post_id);
			request.setAttribute("postVO", postVO);
			List<fileVO> fileList = fileService.getFile(post_id);
			List<replyVO> replyList = replySevice.selectPost(post_id);
			
			
			logger.debug("replyList:{}", replyList);
			request.setAttribute("fileList", fileList);	
			request.setAttribute("replyList", replyList);
			request.getRequestDispatcher("/post/postIn.jsp").forward(request, response);
		
	}


}
