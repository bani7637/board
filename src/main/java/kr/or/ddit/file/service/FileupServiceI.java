package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.model.fileVO;

public interface FileupServiceI {
	int insertFile(fileVO fileVO);

	List<fileVO> getFile(int post_id);

	fileVO downfile(int file_id);

	int deleteFile(int file_id);
}
