package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.pagingVO;
import kr.or.ddit.post.model.postVO;


public interface PostServiceI {
	// 전체글가져오기
	List<postVO> selectPost(int board_id);
	
	// 하나의 글가져오기
	postVO getPost(int post_id);
	
	// 게시글 삭제하기
	int deletePost(int post_id);
	
	//게시글 페이징
	Map<String, Object> selectPostList(pagingVO pv);
	
	//게시글 작성
	int insertPost(postVO postVO);
	
	//게시글 수정
	int updatePost(postVO postVO);
	
	//답글 작성
	int repostInsert(postVO postVO);
}
