package kr.or.ddit.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.model.fileVO;

public class FileupDao implements FileupDaoI{

	@Override
	public int insertFile(fileVO fileVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt =0;
		try {
			insertCnt = sqlSession.insert("file.insertFile",fileVO);
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
	public List<fileVO> getFile(int post_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<fileVO> fileList = sqlSession.selectList("file.getFile",post_id);
		sqlSession.close();
		
		return fileList;
	}

	@Override
	public fileVO downfile(int file_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		fileVO fileVO = sqlSession.selectOne("file.downFile", file_id);
		return fileVO;
	}

	@Override
	public int deleteFile(int file_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt =0;
		try {
			deleteCnt = sqlSession.insert("file.deleteFile",file_id);
		} catch (Exception e) {
		}
		if(deleteCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}
}
