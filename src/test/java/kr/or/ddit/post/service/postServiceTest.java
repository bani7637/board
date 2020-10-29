package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.post.model.postVO;

public class postServiceTest {
	PostServiceI postService;

	@Before
	public void setup() {
		postService = new PostService();
	}

	@Test
	public void insertPost2Test() {
		/*** Given ***/

		/*** When ***/
		postVO postVO = new postVO();
		postVO.setBoard_id(73);
		postVO.setPost_title("테스트코드진행중");
		postVO.setPost_content("테스트");
		postVO.setMem_id("bani");
		int res = postService.insertPost(postVO);

		/*** Then ***/
		assertEquals(1, res);
	}

	@Test
	public void repostInsertTest() {
		/*** Given ***/

		/*** When ***/
		postVO postVO = new postVO();
		postVO.setBoard_id(73);
		postVO.setPost_title("테스틓");
		postVO.setPost_content("테스트");
		postVO.setMem_id("bani");
		postVO.setP_post_id(134);
		postVO.setGu(67);

		int res = postService.repostInsert(postVO);
		/*** Then ***/
		assertEquals(1, res);

	}

	@Test
	public void updatePostTest() {
		/*** Given ***/

		/*** When ***/
		postVO postVO = new postVO();
		postVO.setPost_title("테스트코드진행중22");
		postVO.setPost_content("냉무");
		postVO.setPost_id(134);
		int res = postService.updatePost(postVO);

		/*** Then ***/
		assertEquals(1, res);
	}

	@Test
	public void deletePostTest() {
		/*** Given ***/

		/*** When ***/
		int post_id = 134;
		int res = postService.deletePost(post_id);
		/*** Then ***/
		assertEquals(1, res);

	}

}
