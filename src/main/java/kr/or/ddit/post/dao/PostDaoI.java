package kr.or.ddit.post.dao;

import java.util.List;

import kr.or.ddit.post.model.postVO;


public interface PostDaoI {
	List<postVO> selectPost(int board_id);
}
