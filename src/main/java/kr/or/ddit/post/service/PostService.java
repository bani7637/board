package kr.or.ddit.post.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoI;
import kr.or.ddit.post.model.postVO;

public class PostService implements PostServiceI{
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	private PostDaoI postDao;
	
	public PostService() {
		postDao = new PostDao();
	}
	@Override
	public List<postVO> selectPost(int board_id) {
		return postDao.selectPost(board_id);
	}

}
