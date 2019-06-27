package com.Mart.po;

public class Collect {
	private Integer coId;//心愿单表id	主键
	private Integer userId;//用户id	外键
	private Integer proId;//商品表id	外键
	public Integer getCoId() {
		return coId;
	}
	public void setCoId(Integer coId) {
		this.coId = coId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coId == null) ? 0 : coId.hashCode());
		result = prime * result + ((proId == null) ? 0 : proId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Collect other = (Collect) obj;
		if (coId == null) {
			if (other.coId != null)
				return false;
		} else if (!coId.equals(other.coId))
			return false;
		if (proId == null) {
			if (other.proId != null)
				return false;
		} else if (!proId.equals(other.proId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Collect [coId=" + coId + ", userId=" + userId + ", proId=" + proId + "]";
	}
	
	
}
