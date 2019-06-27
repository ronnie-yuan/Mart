package com.Mart.po;

public class BigType {
	private Integer bigId;//商品大分类表主键
	private String	bigName;//商品大分类名称
	
	public Integer getBigId() {
		return bigId;
	}
	public void setBigId(Integer bigId) {
		this.bigId = bigId;
	}
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bigId == null) ? 0 : bigId.hashCode());
		result = prime * result + ((bigName == null) ? 0 : bigName.hashCode());
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
		BigType other = (BigType) obj;
		if (bigId == null) {
			if (other.bigId != null)
				return false;
		} else if (!bigId.equals(other.bigId))
			return false;
		if (bigName == null) {
			if (other.bigName != null)
				return false;
		} else if (!bigName.equals(other.bigName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bigtype [bigId=" + bigId + ", bigName=" + bigName + "]";
	}
	
	
}
