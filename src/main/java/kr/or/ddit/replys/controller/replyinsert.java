package kr.or.ddit.replys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.replys.model.replyVO;
import kr.or.ddit.replys.service.replyService;
import kr.or.ddit.replys.service.replySeviceI;

@WebServlet("/replyinsert")
public class replyinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(replyinsert.class);
    private replySeviceI replySevice;
    
    @Override
	public void init() throws ServletException {
    	replySevice = new replyService();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String reply_content  = request.getParameter("reply_content");
		String mem_id = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			logger.debug("cookieName : {}, value : {}", cookie.getName(), cookie.getValue());
			mem_id = cookie.getValue();
		}
		replyVO replyVO = new replyVO();
		replyVO.setPost_id(post_id);
		replyVO.setReply_content(reply_content);
		replyVO.setMem_id(mem_id);
		int res = replySevice.insertReply(replyVO);
		if(res == 1) {
			response.sendRedirect(request.getContextPath() + "/post?post_id=" + post_id + "");
		} else {
			response.sendRedirect(request.getContextPath() + "/post?post_id=" + post_id + "");
		}
	}

}
