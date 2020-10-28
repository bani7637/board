package kr.or.ddit.post.dao;

import java.util.List;

import kr.or.ddit.post.model.pagingVO;
import kr.or.ddit.post.model.postVO;


public interface PostDaoI {
	List<postVO> selectPost(int board_id);
	postVO getPost(int post_id);
	int deletePost(int post_id);
	List<postVO> selectPostList(pagingVO pv);
	int selectPostTotalCount(int board_id);
	int insertPost(postVO postVO);
	int updatePost(postVO postVO);
	int repostInsert(postVO postVO);
}
