package com.Mart.po;

public class Cartproduct {
	private Integer proId;
	
	private String proImg;//商品图片链接
	private String proName;//商品名
	private Integer proPrice;//商品单价
	private Integer ccount;//该商品的数量
	private Long proSum;//该件商品的总价
	
	
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	
	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getProPrice() {
		return proPrice;
	}
	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}

	public Integer getCcount() {
		return ccount;
	}
	public void setCcount(Integer ccount) {
		this.ccount = ccount;
	}
	public Long getProSum() {
		return proSum;
	}
	public void setProSum(Long proSum) {
		this.proSum = proSum;
	}
	@Override
	public String toString() {
		return "Cartproduct [proImg=" + proImg + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccount == null) ? 0 : ccount.hashCode());
		result = prime * result + ((proImg == null) ? 0 : proImg.hashCode());
		result = prime * result + ((proName == null) ? 0 : proName.hashCode());
		result = prime * result + ((proPrice == null) ? 0 : proPrice.hashCode());
		result = prime * result + ((proSum == null) ? 0 : proSum.hashCode());
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
		Cartproduct other = (Cartproduct) obj;
		if (ccount == null) {
			if (other.ccount != null)
				return false;
		} else if (!ccount.equals(other.ccount))
			return false;
		if (proImg == null) {
			if (other.proImg != null)
				return false;
		} else if (!proImg.equals(other.proImg))
			return false;
		if (proName == null) {
			if (other.proName != null)
				return false;
		} else if (!proName.equals(other.proName))
			return false;
		if (proPrice == null) {
			if (other.proPrice != null)
				return false;
		} else if (!proPrice.equals(other.proPrice))
			return false;
		if (proSum == null) {
			if (other.proSum != null)
				return false;
		} else if (!proSum.equals(other.proSum))
			return false;
		return true;
	}
	
	
}
