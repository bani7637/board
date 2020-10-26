package kr.or.ddit.member.model;

import java.util.Date;

public class MemberVO {

	private String mem_id;
	private String mem_name;
	private String mem_pass;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result + ((mem_name == null) ? 0 : mem_name.hashCode());
		result = prime * result + ((mem_pass == null) ? 0 : mem_pass.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (mem_name == null) {
			if (other.mem_name != null)
				return false;
		} else if (!mem_name.equals(other.mem_name))
			return false;
		if (mem_pass == null) {
			if (other.mem_pass != null)
				return false;
		} else if (!mem_pass.equals(other.mem_pass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_pass=" + mem_pass + "]";
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

}