package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {

	//
	MemberVO getMember(String mem_id);
	
	List<MemberVO> selectAllMember();
	
	int selectMemberTotalCount();
	
	int insertMember(MemberVO memberVO);
	
	int updateMember(MemberVO memberVO);
	
}
