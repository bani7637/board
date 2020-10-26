package kr.or.ddit.post.service;

import java.util.List;

import kr.or.ddit.post.model.postVO;


public interface PostServiceI {
	List<postVO> selectPost(int board_id);
}
