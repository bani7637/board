package kr.or.ddit.replys.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.replys.model.replyVO;

public class replyDao implements replyDaoI {

	@Override
	public int insertReply(replyVO replyVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt =0;
		try {
			insertCnt =sqlSession.insert("reply.insertReply",replyVO);
		} catch (Exception e) {

		}
		if(insertCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public List<replyVO> selectPost(int post_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<replyVO> postList = sqlSession.selectList("reply.selectReply",post_id);
		
		sqlSession.close();
		return postList;
	}

	@Override
	public int updateReply(int reply_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updatetCnt =0;
		try {
			updatetCnt =sqlSession.insert("reply.updateReply",reply_id);
		} catch (Exception e) {

		}
		if(updatetCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updatetCnt;
	}

}
