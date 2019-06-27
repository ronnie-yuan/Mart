package com.Mart.po;

import java.util.Date;

public class Comment {
	private Integer comId;//评论表主键id
	private String 	comContent;//留言内容	可为空
	private Date 	comCreateTime;//留言时间	可为空
	private String 	comReplyContent;//回复内容	可为空
	private Date 	comReplyTime;//回复时间	可为空
	private Integer comisIn;//回复内容是否隐藏(删除)  0,隐藏   1,显示(默认) 可为空
	private Integer userId;//用户表id  外键
	private Integer proId;//商品表id  外键
	
	public Integer getComId() {
		return comId;
	}
	public void setComId(Integer comId) {
		this.comId = comId;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public Date getComCreateTime() {
		return comCreateTime;
	}
	public void setComCreateTime(Date comCreateTime) {
		this.comCreateTime = comCreateTime;
	}
	public String getComReplyContent() {
		return comReplyContent;
	}
	public void setComReplyContent(String comReplyContent) {
		this.comReplyContent = comReplyContent;
	}
	public Date getComReplyTime() {
		return comReplyTime;
	}
	public void setComReplyTime(Date comReplyTime) {
		this.comReplyTime = comReplyTime;
	}
	public Integer getComisIn() {
		return comisIn;
	}
	public void setComisIn(Integer comisIn) {
		this.comisIn = comisIn;
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
		result = prime * result + ((comContent == null) ? 0 : comContent.hashCode());
		result = prime * result + ((comCreateTime == null) ? 0 : comCreateTime.hashCode());
		result = prime * result + ((comId == null) ? 0 : comId.hashCode());
		result = prime * result + ((comReplyContent == null) ? 0 : comReplyContent.hashCode());
		result = prime * result + ((comReplyTime == null) ? 0 : comReplyTime.hashCode());
		result = prime * result + ((comisIn == null) ? 0 : comisIn.hashCode());
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
		Comment other = (Comment) obj;
		if (comContent == null) {
			if (other.comContent != null)
				return false;
		} else if (!comContent.equals(other.comContent))
			return false;
		if (comCreateTime == null) {
			if (other.comCreateTime != null)
				return false;
		} else if (!comCreateTime.equals(other.comCreateTime))
			return false;
		if (comId == null) {
			if (other.comId != null)
				return false;
		} else if (!comId.equals(other.comId))
			return false;
		if (comReplyContent == null) {
			if (other.comReplyContent != null)
				return false;
		} else if (!comReplyContent.equals(other.comReplyContent))
			return false;
		if (comReplyTime == null) {
			if (other.comReplyTime != null)
				return false;
		} else if (!comReplyTime.equals(other.comReplyTime))
			return false;
		if (comisIn == null) {
			if (other.comisIn != null)
				return false;
		} else if (!comisIn.equals(other.comisIn))
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
		return "Comment [comId=" + comId + ", comContent=" + comContent + ", comCreateTime=" + comCreateTime
				+ ", comReplyContent=" + comReplyContent + ", comReplyTime=" + comReplyTime + ", comisIn=" + comisIn
				+ ", userId=" + userId + ", proId=" + proId + "]";
	}
	
	
	
}
