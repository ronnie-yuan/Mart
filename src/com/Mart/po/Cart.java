package com.Mart.po;

public class Cart {
	private Integer	cId;//购物车表id 主键
	private Integer	userId;//用户表id  外键
	private Integer	proId;//商品表id  外键
	private Integer	cCount;//购物车内商品数量
	private Integer	cChecked;//商品是否选择状态,默认为0未选中,1位选中
	
	public Integer getCId() {
		return cId;
	}
	public void setCId(Integer cId) {
		this.cId = cId;
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
	public Integer getCCount() {
		return cCount;
	}
	public void setCCount(Integer cCount) {
		this.cCount = cCount;
	}
	public Integer getCChecked() {
		return cChecked;
	}
	public void setCChecked(Integer cChecked) {
		this.cChecked = cChecked;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cChecked == null) ? 0 : cChecked.hashCode());
		result = prime * result + ((cCount == null) ? 0 : cCount.hashCode());
		result = prime * result + ((cId == null) ? 0 : cId.hashCode());
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
		Cart other = (Cart) obj;
		if (cChecked == null) {
			if (other.cChecked != null)
				return false;
		} else if (!cChecked.equals(other.cChecked))
			return false;
		if (cCount == null) {
			if (other.cCount != null)
				return false;
		} else if (!cCount.equals(other.cCount))
			return false;
		if (cId == null) {
			if (other.cId != null)
				return false;
		} else if (!cId.equals(other.cId))
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
		return "Cart [cId=" + cId + ", userId=" + userId + ", proId=" + proId + ", cCount=" + cCount + ", cChecked="
				+ cChecked + "]";
	}
	
	
}
