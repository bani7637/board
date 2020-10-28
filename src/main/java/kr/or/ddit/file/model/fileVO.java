package kr.or.ddit.file.model;

public class fileVO {
	private int file_id      ;
	private String file_name    ;
	private String file_realname;
	private int post_id      ;
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_realname() {
		return file_realname;
	}
	public void setFile_realname(String file_realname) {
		this.file_realname = file_realname;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + file_id;
		result = prime * result + ((file_name == null) ? 0 : file_name.hashCode());
		result = prime * result + ((file_realname == null) ? 0 : file_realname.hashCode());
		result = prime * result + post_id;
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
		fileVO other = (fileVO) obj;
		if (file_id != other.file_id)
			return false;
		if (file_name == null) {
			if (other.file_name != null)
				return false;
		} else if (!file_name.equals(other.file_name))
			return false;
		if (file_realname == null) {
			if (other.file_realname != null)
				return false;
		} else if (!file_realname.equals(other.file_realname))
			return false;
		if (post_id != other.post_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "fileVO [file_id=" + file_id + ", file_name=" + file_name + ", file_realname=" + file_realname
				+ ", post_id=" + post_id + "]";
	}
	
	
}                               
