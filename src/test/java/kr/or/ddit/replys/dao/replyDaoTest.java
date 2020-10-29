package kr.or.ddit.replys.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.replys.model.replyVO;


public class replyDaoTest {
	replyDaoI replyDao;

	@Before
	public void setup() {
		/*** Given ***/
		replyDao = new replyDao();

	}

	@Test
	public void selectReplyTest() {
		/***Given***/

		/***When***/
		int post_id = 100;
		List<replyVO>reList = replyDao.selectPost(post_id);
		
		/***Then***/
		assertEquals(1, reList.size());
	}
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		
		
		/***When***/
		replyVO replyVO = new replyVO();
		replyVO.setMem_id("bani");
		replyVO.setPost_id(100);
		replyVO.setReply_content("테스트코드진행중");
		int res = replyDao.insertReply(replyVO);
		
		/***Then***/
		assertEquals(1, res);
	}
	
	@Test
	public void updateReplTest() {
		/***Given***/
		
		
		/***When***/
		int reply_id = 28;
		int res = replyDao.updateReply(reply_id);
		
		/***Then***/
		assertEquals(1, res);
	}

}
