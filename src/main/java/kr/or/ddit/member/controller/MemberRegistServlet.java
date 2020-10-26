package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/memberRegist")
@MultipartConfig
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberServiceI memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberRegistServlet.class);
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberRegist.jsp").forward(request, response);
	}
	
	//doXXX메서드에는 request, response 인자말고 다른 객체를 인자로 받아서 쓸수 있음=>  spring
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_pass = request.getParameter("mem_pass");
		logger.debug("param:{},{},{}",mem_id,mem_name,mem_pass);
		
		// 사용자 정보등록
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id(mem_id);
		memberVO.setMem_name(mem_name);
		memberVO.setMem_pass(mem_pass);
		
		int res = memberService.insertMember(memberVO);
		//1건이 입력되어있을때, 1건이아닐때 비정상
		
		if(res == 1) {
			response.sendRedirect(request.getContextPath()+"/memberList");
		}else {
			//화면요청
		doGet(request, response);
		}
	}

	
}
