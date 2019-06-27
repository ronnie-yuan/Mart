package com.Mart.po;

public class Pay {
	private Integer payId;//支付宝支付信息表主键
	private Integer userId;//用户表id  外键
	private Integer orderId;//订单表id  外键
	private Integer payPlatfrom;//选择的支付平台,0:微信 1支付宝(默认)
	private String	payNumber;//支付宝账单流水号  交易成功后支付宝服务器会发送一个给我们
	private String	payStatus;//当前支付信息状态
	
	public Integer getPayId() {
		return payId;
	}
	public void setPayId(Integer payId) {
		this.payId = payId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPayPlatfrom() {
		return payPlatfrom;
	}
	public void setPayPlatfrom(Integer payPlatfrom) {
		this.payPlatfrom = payPlatfrom;
	}
	public String getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((payId == null) ? 0 : payId.hashCode());
		result = prime * result + ((payNumber == null) ? 0 : payNumber.hashCode());
		result = prime * result + ((payPlatfrom == null) ? 0 : payPlatfrom.hashCode());
		result = prime * result + ((payStatus == null) ? 0 : payStatus.hashCode());
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
		Pay other = (Pay) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (payId == null) {
			if (other.payId != null)
				return false;
		} else if (!payId.equals(other.payId))
			return false;
		if (payNumber == null) {
			if (other.payNumber != null)
				return false;
		} else if (!payNumber.equals(other.payNumber))
			return false;
		if (payPlatfrom == null) {
			if (other.payPlatfrom != null)
				return false;
		} else if (!payPlatfrom.equals(other.payPlatfrom))
			return false;
		if (payStatus == null) {
			if (other.payStatus != null)
				return false;
		} else if (!payStatus.equals(other.payStatus))
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
		return "Pay [payId=" + payId + ", userId=" + userId + ", orderId=" + orderId + ", payPlatfrom=" + payPlatfrom
				+ ", payNumber=" + payNumber + ", payStatus=" + payStatus + "]";
	}
	
	
}
