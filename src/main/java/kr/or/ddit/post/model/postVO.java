package kr.or.ddit.post.model;

import java.util.Date;

public class postVO {
	private int post_id      ;
	private int board_id     ;
	private String post_title   ;
	private String post_content ;
	private Date post_date    ;
	private String post_status  ;
	private String mem_id       ;
	private int p_post_id    ;
	private int gu;
	private int level;
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_status() {
		return post_status;
	}
	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getP_post_id() {
		return p_post_id;
	}
	public void setP_post_id(int p_post_id) {
		this.p_post_id = p_post_id;
	}
	public int getGu() {
		return gu;
	}
	public void setGu(int gu) {
		this.gu = gu;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_id;
		result = prime * result + gu;
		result = prime * result + level;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result + p_post_id;
		result = prime * result + ((post_content == null) ? 0 : post_content.hashCode());
		result = prime * result + ((post_date == null) ? 0 : post_date.hashCode());
		result = prime * result + post_id;
		result = prime * result + ((post_status == null) ? 0 : post_status.hashCode());
		result = prime * result + ((post_title == null) ? 0 : post_title.hashCode());
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
		postVO other = (postVO) obj;
		if (board_id != other.board_id)
			return false;
		if (gu != other.gu)
			return false;
		if (level != other.level)
			return false;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (p_post_id != other.p_post_id)
			return false;
		if (post_content == null) {
			if (other.post_content != null)
				return false;
		} else if (!post_content.equals(other.post_content))
			return false;
		if (post_date == null) {
			if (other.post_date != null)
				return false;
		} else if (!post_date.equals(other.post_date))
			return false;
		if (post_id != other.post_id)
			return false;
		if (post_status == null) {
			if (other.post_status != null)
				return false;
		} else if (!post_status.equals(other.post_status))
			return false;
		if (post_title == null) {
			if (other.post_title != null)
				return false;
		} else if (!post_title.equals(other.post_title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "postVO [post_id=" + post_id + ", board_id=" + board_id + ", post_title=" + post_title
				+ ", post_content=" + post_content + ", post_date=" + post_date + ", post_status=" + post_status
				+ ", mem_id=" + mem_id + ", p_post_id=" + p_post_id + ", gu=" + gu + ", level=" + level + "]";
	}
	
	
}
