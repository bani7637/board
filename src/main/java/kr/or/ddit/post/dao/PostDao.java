package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.post.model.pagingVO;
import kr.or.ddit.post.model.postVO;

public class PostDao implements PostDaoI{

	@Override
	public List<postVO> selectPost(int board_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<postVO> postList = sqlSession.selectList("post.selectPost",board_id);
		
		sqlSession.close();
		return postList;
	}

	@Override
	public postVO getPost(int post_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		postVO postVO = sqlSession.selectOne("post.getPost", post_id);
		sqlSession.close();
		return postVO;
	}

	@Override
	public int deletePost(int post_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int res = 0;
		try {
			res = sqlSession.insert("post.deletePost", post_id);
		} catch (Exception e) {
			
		}
		
		if(res ==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return res;
	}

	@Override
	public List<postVO> selectPostList(pagingVO pv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<postVO> postList2 = sqlSession.selectList("post.selectPostList",pv);
		sqlSession.close();
		return postList2;
	}

	@Override
	public int selectPostTotalCount(int board_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int totalcnt = sqlSession.selectOne("post.selectPostTotalcnt",board_id);
		return totalcnt;
	}

	@Override
	public int insertPost(postVO postVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt =0;
		try {
			insertCnt =sqlSession.insert("post.insertPost",postVO);
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
	public int updatePost(postVO postVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int upCnt = 0;
		try {
			upCnt = sqlSession.update("post.updatePost",postVO);
		} catch (Exception e) {
		}
		if(upCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return upCnt;
	}

	@Override
	public int repostInsert(postVO postVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt =0;
		try {
			insertCnt =sqlSession.insert("post.repostInsert",postVO);
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

	
}
