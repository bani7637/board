package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/memUpdate")
@MultipartConfig
public class memberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberServiceI memberService;

	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		MemberVO memberVO = memberService.getMember(mem_id);
		request.setAttribute("memberVO", memberVO);
		request.getRequestDispatcher("/member/memupdate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_pass = request.getParameter("mem_pass");
		

		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id(mem_id);
		memberVO.setMem_name(mem_name);
		memberVO.setMem_pass(mem_pass);
		

		int res = memberService.updateMember(memberVO);
		// 1건이 입력되어있을때, 1건이아닐때 비정상

		if (res == 1) {
			response.sendRedirect(request.getContextPath() + "/member?mem_id="+mem_id+"");
		} else {
			// 화면요청
			doGet(request, response);
		}
	}

}
