package kr.or.ddit.replys.service;

import java.util.List;

import kr.or.ddit.replys.model.replyVO;

public interface replySeviceI {
	//댓글 작성
	int insertReply(replyVO replyVO);
	//댓글 목록불러오기
	List<replyVO> selectPost(int post_id);
	//댓글삭제처리
	int updateReply(int reply_id);
}
