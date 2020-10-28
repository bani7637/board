package kr.or.ddit.replys.service;

import kr.or.ddit.replys.dao.replyDaoI;
import kr.or.ddit.replys.model.replyVO;

import java.util.List;

import kr.or.ddit.replys.dao.replyDao;

public class replyService implements replySeviceI {
	private replyDaoI replyDao;
	
	public replyService() {
		replyDao = new replyDao();
	}

	@Override
	public int insertReply(replyVO replyVO) {
		return replyDao.insertReply(replyVO);
	}

	@Override
	public List<replyVO> selectPost(int post_id) {
		return replyDao.selectPost(post_id);
	}

	@Override
	public int updateReply(int reply_id) {
		return replyDao.updateReply(reply_id);
	}
}
