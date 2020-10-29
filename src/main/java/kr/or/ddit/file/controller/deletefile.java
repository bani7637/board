package kr.or.ddit.file.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.file.service.FileupService;
import kr.or.ddit.file.service.FileupServiceI;
import kr.or.ddit.post.model.postVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

@WebServlet("/deletefile")
public class deletefile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FileupServiceI fileupService;
    private PostServiceI postService;
    @Override
    public void init() throws ServletException {
    	fileupService = new FileupService();
    	postService = new PostService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int file_id= Integer.parseInt(request.getParameter("file_id"));
		int post_id= Integer.parseInt(request.getParameter("post_id"));
		int res = fileupService.deleteFile(file_id);
		if(res>=1) {

//			response.sendRedirect(request.getContextPath()+"/updatepost?post_id="+post_id+"");
		}
//		}else {
//			response.sendRedirect(request.getContextPath()+"/updatepost?post_id="+post_id+"");
		}
//	}


}
