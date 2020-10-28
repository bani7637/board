package kr.or.ddit.replys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.replys.service.replyService;
import kr.or.ddit.replys.service.replySeviceI;

@WebServlet("/deleteReply")
public class deleteReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private replySeviceI replySevice;
	@Override
	public void init() throws ServletException {
    	replySevice = new replyService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int reply_id =Integer.parseInt(request.getParameter("reply_id"));
		int post_id =Integer.parseInt(request.getParameter("post_id"));
		int res = replySevice.updateReply(reply_id);
		if(res == 1) {
			response.sendRedirect(request.getContextPath() + "/post?post_id=" + post_id + "");
		} else {
			response.sendRedirect(request.getContextPath() + "/post?post_id=" + post_id + "");
		}
	}

}