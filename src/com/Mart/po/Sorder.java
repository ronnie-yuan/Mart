package com.Mart.po;

public class Sorder {
	private Integer soId;//订单子表主键 
	private Integer orderId;//订单表id  外键
	private Integer proId;//商品表id  外键
	private Integer soCount;//订单中单个商品数量
	
	public Integer getSoId() {
		return soId;
	}
	public void setSoId(Integer soId) {
		this.soId = soId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public Integer getSoCount() {
		return soCount;
	}
	public void setSoCount(Integer soCount) {
		this.soCount = soCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((proId == null) ? 0 : proId.hashCode());
		result = prime * result + ((soCount == null) ? 0 : soCount.hashCode());
		result = prime * result + ((soId == null) ? 0 : soId.hashCode());
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
		Sorder other = (Sorder) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (proId == null) {
			if (other.proId != null)
				return false;
		} else if (!proId.equals(other.proId))
			return false;
		if (soCount == null) {
			if (other.soCount != null)
				return false;
		} else if (!soCount.equals(other.soCount))
			return false;
		if (soId == null) {
			if (other.soId != null)
				return false;
		} else if (!soId.equals(other.soId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sorder [soId=" + soId + ", orderId=" + orderId + ", proId=" + proId + ", soCount=" + soCount + "]";
	}
	
	
}
