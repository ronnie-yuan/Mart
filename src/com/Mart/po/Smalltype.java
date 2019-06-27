package com.Mart.po;

public class Smalltype {
	private Integer smId;//商品小分类表主键
	private String 	smName;//商品小分类名称
	private Integer bigId;//商品大分类表id  外键
	
	public Integer getSmId() {
		return smId;
	}
	public void setSmId(Integer smId) {
		this.smId = smId;
	}
	public String getSmName() {
		return smName;
	}
	public void setSmName(String smName) {
		this.smName = smName;
	}
	public Integer getBigId() {
		return bigId;
	}
	public void setBigId(Integer bigId) {
		this.bigId = bigId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bigId == null) ? 0 : bigId.hashCode());
		result = prime * result + ((smId == null) ? 0 : smId.hashCode());
		result = prime * result + ((smName == null) ? 0 : smName.hashCode());
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
		Smalltype other = (Smalltype) obj;
		if (bigId == null) {
			if (other.bigId != null)
				return false;
		} else if (!bigId.equals(other.bigId))
			return false;
		if (smId == null) {
			if (other.smId != null)
				return false;
		} else if (!smId.equals(other.smId))
			return false;
		if (smName == null) {
			if (other.smName != null)
				return false;
		} else if (!smName.equals(other.smName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Smalltype [smId=" + smId + ", smName=" + smName + ", bigId=" + bigId + "]";
	}
	
	
	
}
