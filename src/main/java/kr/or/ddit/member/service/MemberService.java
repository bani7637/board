package kr.or.ddit.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberService implements MemberServiceI {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	private MemberDaoI memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVO getMember(String mem_id) {
		return memberDao.getMember(mem_id);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return memberDao.selectAllMember();
	}
	

	@Override
	public int insertMember(MemberVO memberVO) {
		return memberDao.insertMember(memberVO);
	}


	@Override
	public int updateMember(MemberVO memberVO) {
		return memberDao.updateMember(memberVO);
	}

	

	



}
