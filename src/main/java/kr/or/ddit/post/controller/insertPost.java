package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.file.model.fileVO;
import kr.or.ddit.file.service.FileupService;
import kr.or.ddit.file.service.FileupServiceI;
import kr.or.ddit.fileupload.FileUploadUtil;
import kr.or.ddit.post.model.postVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

@WebServlet("/insertPost")
@MultipartConfig
public class insertPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(insertPost.class);
	private PostServiceI poService;
	private String fileName;
	private String realFilename;
	private FileupServiceI fileService;
	

	@Override
	public void init() throws ServletException {
		poService = new PostService();
		fileService = new FileupService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String mem_id = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			logger.debug("cookieName : {}, value : {}", cookie.getName(), cookie.getValue());
			mem_id = cookie.getValue();
		}
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		postVO postVO = new postVO();
		postVO.setMem_id(mem_id);
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		postVO.setBoard_id(board_id);
		int res = poService.insertPost(postVO);

		int post_id = postVO.getPost_id();


		if (request.getPart("realFilename1") != null) {
			Part postfile = request.getPart("realFilename1");

			realFilename = FileUploadUtil.getFilename(postfile.getHeader("Content-Disposition"));
			fileName = UUID.randomUUID().toString();
			String filePath = "";
			String ext = FileUploadUtil.getExtenstion(realFilename);

			if (postfile.getSize() > 0) {
				filePath = "D:\\postfile\\" + fileName + "." + ext;
				postfile.write(filePath);
				fileVO fileVO = new fileVO();
				fileVO.setFile_name(filePath);
				fileVO.setFile_realname(realFilename);
				fileVO.setPost_id(post_id);
				int res2 = fileService.insertFile(fileVO);
				logger.debug("file저장: {}",res2);
			}
		}

		if (request.getPart("realFilename2") != null) {
			Part postfile = request.getPart("realFilename2");

			realFilename = FileUploadUtil.getFilename(postfile.getHeader("Content-Disposition"));
			fileName = UUID.randomUUID().toString();
			String filePath = "";
			String ext = FileUploadUtil.getExtenstion(realFilename);

			if (postfile.getSize() > 0) {
				filePath = "D:\\postfile\\" + fileName + "." + ext;
				postfile.write(filePath);
				fileVO fileVO = new fileVO();
				fileVO.setFile_name(filePath);
				fileVO.setFile_realname(realFilename);
				fileVO.setPost_id(post_id);
				int res2 = fileService.insertFile(fileVO);
			}
		}
		if (request.getPart("realFilename3") != null) {
			Part postfile = request.getPart("realFilename3");

			realFilename = FileUploadUtil.getFilename(postfile.getHeader("Content-Disposition"));
			fileName = UUID.randomUUID().toString();
			String filePath = "";
			String ext = FileUploadUtil.getExtenstion(realFilename);

			if (postfile.getSize() > 0) {
				filePath = "D:\\postfile\\" + fileName + "." + ext;
				postfile.write(filePath);
				fileVO fileVO = new fileVO();
				fileVO.setFile_name(filePath);
				fileVO.setFile_realname(realFilename);
				fileVO.setPost_id(post_id);
				int res2 = fileService.insertFile(fileVO);
			}
		}
		if (request.getPart("realFilename4") != null) {
			Part postfile = request.getPart("realFilename4");

			String realFilename = FileUploadUtil.getFilename(postfile.getHeader("Content-Disposition"));
			String fileName = UUID.randomUUID().toString();
			String filePath = "";
			String ext = FileUploadUtil.getExtenstion(realFilename);

			if (postfile.getSize() > 0) {
				filePath = "D:\\postfile\\" + fileName + "." + ext;
				postfile.write(filePath);
				fileVO fileVO = new fileVO();
				fileVO.setFile_name(filePath);
				fileVO.setFile_realname(realFilename);
				fileVO.setPost_id(post_id);
				int res2 = fileService.insertFile(fileVO);
			}
		}
		if (request.getPart("realFilename5") != null) {
			Part postfile = request.getPart("realFilename5");

			String realFilename = FileUploadUtil.getFilename(postfile.getHeader("Content-Disposition"));
			String fileName = UUID.randomUUID().toString();
			String filePath = "";
			String ext = FileUploadUtil.getExtenstion(realFilename);

			if (postfile.getSize() > 0) {
				filePath = "D:\\postfile\\" + fileName + "." + ext;
				postfile.write(filePath);
				fileVO fileVO = new fileVO();
				fileVO.setFile_name(filePath);
				fileVO.setFile_realname(realFilename);
				fileVO.setPost_id(post_id);
				int res2 = fileService.insertFile(fileVO);
			}
		}

		if (res == 1) {
			response.sendRedirect(request.getContextPath() + "/selectPost?board_id=" + board_id + "");
		} else {
			doGet(request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		request.setAttribute("board_id", board_id);
		request.getRequestDispatcher("/post/insertpost.jsp").forward(request, response);
	}

}
