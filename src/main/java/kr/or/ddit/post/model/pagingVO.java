package kr.or.ddit.post.model;

public class pagingVO {
	private int page;
	private int pageSize;
	private int board_id;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_id;
		result = prime * result + page;
		result = prime * result + pageSize;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pagingVO other = (pagingVO) obj;
		if (board_id != other.board_id)
			return false;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "pagingVO [page=" + page + ", pageSize=" + pageSize + ", board_id=" + board_id + "]";
	}
	
	}

