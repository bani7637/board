package kr.or.ddit.replys.dao;

import java.util.List;

import kr.or.ddit.replys.model.replyVO;

public interface replyDaoI {
	int insertReply(replyVO replyVO);
	List<replyVO> selectPost(int post_id);
	int updateReply(int reply_id);
}
