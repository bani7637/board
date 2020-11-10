package kr.or.ddit.file.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.file.model.fileVO;
import kr.or.ddit.file.service.FileupService;
import kr.or.ddit.file.service.FileupServiceI;

@WebServlet("/postfileDownload")
public class postfileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileupServiceI fileService;
       
	@Override
	public void init() throws ServletException {
		fileService = new FileupService();
	}
	//통합서비스서버 필요한 이유 : 다운로드기능구현시 다른컴퓨터에서 서버구동(db=내컴퓨터)일때 다운불가능 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int file_id = Integer.parseInt(request.getParameter("file_id"));
		fileVO fileVO = fileService.downfile(file_id);
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileVO.getFile_realname()+"\"");
		response.setContentType("application/octet-stream"); 
		
		FileInputStream fis = new FileInputStream(fileVO.getFile_name());
		ServletOutputStream sos = response.getOutputStream();
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer)!=-1) {
			sos.write(buffer);
		}
		
		fis.close();
		
		sos.flush();
		sos.close();
	}
	}


