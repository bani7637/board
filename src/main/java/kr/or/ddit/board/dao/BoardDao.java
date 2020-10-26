package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI{

	@Override
	public List<BoardVO> selectBoard() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVO> boardList = sqlSession.selectList("board.selectBoard");
		
		sqlSession.close();
		return boardList;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt =0;
		try {
			insertCnt =sqlSession.insert("board.insertBoard",boardVO);
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
	public List<BoardVO> selectAllBoard() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVO> boardList = sqlSession.selectList("board.selectAllBoard");
		
		sqlSession.close();
		return boardList;
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt =0;
		try {
			updateCnt =sqlSession.update("board.updateBoard",boardVO);
		} catch (Exception e) {

		}
		if(updateCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}
}
