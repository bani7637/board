package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoI;
import kr.or.ddit.post.model.pagingVO;
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
	@Override
	public postVO getPost(int post_id) {
		return postDao.getPost(post_id);
	}
	@Override
	public int deletePost(int post_id) {
		return postDao.deletePost(post_id);
	}
	@Override
	public Map<String, Object> selectPostList(pagingVO pv) {
		Map<String, Object>map = new HashMap<>();
		map.put("postList", postDao.selectPostList(pv));
		// 15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야함
		// 15/7 =2.14...올림하여 3개의 페이지가 필요
		int totalCnt = postDao.selectPostTotalCount(pv.getBoard_id());
		int pages = (int)Math.ceil((double)(totalCnt)/pv.getPageSize());
		int pageSize = pv.getPageSize();
		map.put("pages", pages);
		map.put("pageSize",pageSize);
		return map;
	}
	@Override
	public int insertPost(postVO postVO) {
		return postDao.insertPost(postVO);
	}
	@Override
	public int updatePost(postVO postVO) {
		return postDao.updatePost(postVO);
	}
	@Override
	public int repostInsert(postVO postVO) {
		return postDao.repostInsert(postVO);
	}

}
