package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
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

@WebServlet("/updatepost")
@MultipartConfig
public class updatepost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(updatepost.class);
	private PostServiceI postService;
	private FileupServiceI fileService;
	private String fileName;
	private String realFilename;
	@Override
	public void init() throws ServletException {
		postService = new PostService();
		fileService = new FileupService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		postVO postVO = postService.getPost(post_id);
		List<fileVO>fileList = fileService.getFile(post_id);
		int fileListSize = fileList.size();
		request.setAttribute("fileListSize", fileListSize);
		request.setAttribute("fileList", fileList);
		request.setAttribute("postVO", postVO);
		request.getRequestDispatcher("/post/postupdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String post_title = request.getParameter("post_title");
		String post_content= request.getParameter("post_content");
		logger.debug("tnwjd :{}",post_id);
		logger.debug("tnwjd :{}",post_title);
		logger.debug("tnwjd :{}",post_content);
		
		postVO postVO = new postVO();
		postVO.setPost_id(post_id);
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		
		int res = postService.updatePost(postVO);
		int post_id2 = postVO.getPost_id();
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
			response.sendRedirect(request.getContextPath() + "/post?post_id=" + post_id + "");
		} else {
			doGet(request, response);
		}
		
	}

}
