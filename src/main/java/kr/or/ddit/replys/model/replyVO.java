package kr.or.ddit.replys.model;

import java.util.Date;

public class replyVO {            
	private int reply_id       ;
	private String reply_content  ;
	private String reply_status   ;
	private Date reply_date     ;
	private int post_id        ;
	private String mem_id         ;
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_status() {
		return reply_status;
	}
	public void setReply_status(String reply_status) {
		this.reply_status = reply_status;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result + post_id;
		result = prime * result + ((reply_content == null) ? 0 : reply_content.hashCode());
		result = prime * result + ((reply_date == null) ? 0 : reply_date.hashCode());
		result = prime * result + reply_id;
		result = prime * result + ((reply_status == null) ? 0 : reply_status.hashCode());
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
		replyVO other = (replyVO) obj;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (post_id != other.post_id)
			return false;
		if (reply_content == null) {
			if (other.reply_content != null)
				return false;
		} else if (!reply_content.equals(other.reply_content))
			return false;
		if (reply_date == null) {
			if (other.reply_date != null)
				return false;
		} else if (!reply_date.equals(other.reply_date))
			return false;
		if (reply_id != other.reply_id)
			return false;
		if (reply_status == null) {
			if (other.reply_status != null)
				return false;
		} else if (!reply_status.equals(other.reply_status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "replyVO [reply_id=" + reply_id + ", reply_content=" + reply_content + ", reply_status=" + reply_status
				+ ", reply_date=" + reply_date + ", post_id=" + post_id + ", mem_id=" + mem_id + "]";
	}


}