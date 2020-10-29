package kr.or.ddit.replys.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.replys.model.replyVO;

public class replyServiceTest {
	replySeviceI replyService;
	
	@Before
	public void setup() {
		replyService = new replyService();
	}
	
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		
		
		/***When***/
		replyVO replyVO = new replyVO();
		replyVO.setMem_id("bani");
		replyVO.setPost_id(100);
		replyVO.setReply_content("테스트코드진행중");
		int res = replyService.insertReply(replyVO);
		
		/***Then***/
		assertEquals(1, res);
	}
	
	@Test
	public void updateReplTest() {
		/***Given***/
		
		
		/***When***/
		int reply_id = 28;
		int res = replyService.updateReply(reply_id);
		
		/***Then***/
		assertEquals(1, res);
	}
}
