package kr.or.ddit.board.model;

public class BoardVO {
                               
	private int board_id    ;
	private String mem_id      ;
	private String board_name  ;
	private String board_status;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_status() {
		return board_status;
	}
	public void setBoard_status(String board_status) {
		this.board_status = board_status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_id;
		result = prime * result + ((board_name == null) ? 0 : board_name.hashCode());
		result = prime * result + ((board_status == null) ? 0 : board_status.hashCode());
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
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
		BoardVO other = (BoardVO) obj;
		if (board_id != other.board_id)
			return false;
		if (board_name == null) {
			if (other.board_name != null)
				return false;
		} else if (!board_name.equals(other.board_name))
			return false;
		if (board_status == null) {
			if (other.board_status != null)
				return false;
		} else if (!board_status.equals(other.board_status))
			return false;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardVO [board_id=" + board_id + ", mem_id=" + mem_id + ", board_name=" + board_name + ", board_status="
				+ board_status + "]";
	}
	
	
	
	
	
}
