package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.dao.FileupDao;
import kr.or.ddit.file.dao.FileupDaoI;
import kr.or.ddit.file.model.fileVO;

public class FileupService implements FileupServiceI{
	private FileupDaoI fileDao;
	
	public FileupService() {
		fileDao = new FileupDao();
	}

	@Override
	public int insertFile(fileVO fileVO) {
		return fileDao.insertFile(fileVO);
	}

	@Override
	public List<fileVO> getFile(int post_id) {
		return fileDao.getFile(post_id);
	}

	@Override
	public fileVO downfile(int file_id) {
		return fileDao.downfile(file_id);
	}

	@Override
	public int deleteFile(int file_id) {
		return fileDao.deleteFile(file_id);
	}

}
