package kr.or.ddit.file.dao;

import java.util.List;

import kr.or.ddit.file.model.fileVO;

public interface FileupDaoI {
	int insertFile(fileVO fileVO);
	List<fileVO> getFile(int post_id);
	fileVO downfile(int file_id);
	int deleteFile(int file_id);
}
