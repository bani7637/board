package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.post.model.postVO;

public class PostDao implements PostDaoI{

	@Override
	public List<postVO> selectPost(int board_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<postVO> postList = sqlSession.selectList("post.selectPost",board_id);
		
		sqlSession.close();
		return postList;
	}

}
