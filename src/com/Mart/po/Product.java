package com.Mart.po;

public class Product {
	private Integer proId;//商品表主键id
	private String	proName;//商品名称
	private String	proBrand;//商品品牌
	private Integer	proPrice;//商品价格
	private Integer	proStock;//商品库存
	private Integer	proStatus;//商品状态,0下架  1,正常销售  3,优惠价格
	private String	proImg;//商品图片 服务器上图片地址
	private String	proDescription;//商品描述信息	可为空
	private Integer	smId;//小分类表id  外键	可为空
	private Integer	bigId;//大分类表id  主键
	
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public Integer getProPrice() {
		return proPrice;
	}
	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}
	public Integer getProStock() {
		return proStock;
	}
	public void setProStock(Integer proStock) {
		this.proStock = proStock;
	}
	public Integer getProStatus() {
		return proStatus;
	}
	public void setProStatus(Integer proStatus) {
		this.proStatus = proStatus;
	}
	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	public String getProDescription() {
		return proDescription;
	}
	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}
	public Integer getSmId() {
		return smId;
	}
	public void setSmId(Integer smId) {
		this.smId = smId;
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
		result = prime * result + ((proBrand == null) ? 0 : proBrand.hashCode());
		result = prime * result + ((proDescription == null) ? 0 : proDescription.hashCode());
		result = prime * result + ((proStock == null) ? 0 : proStock.hashCode());
		result = prime * result + ((proId == null) ? 0 : proId.hashCode());
		result = prime * result + ((proImg == null) ? 0 : proImg.hashCode());
		result = prime * result + ((proName == null) ? 0 : proName.hashCode());
		result = prime * result + ((proPrice == null) ? 0 : proPrice.hashCode());
		result = prime * result + ((proStatus == null) ? 0 : proStatus.hashCode());
		result = prime * result + ((smId == null) ? 0 : smId.hashCode());
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
		Product other = (Product) obj;
		if (bigId == null) {
			if (other.bigId != null)
				return false;
		} else if (!bigId.equals(other.bigId))
			return false;
		if (proBrand == null) {
			if (other.proBrand != null)
				return false;
		} else if (!proBrand.equals(other.proBrand))
			return false;
		if (proDescription == null) {
			if (other.proDescription != null)
				return false;
		} else if (!proDescription.equals(other.proDescription))
			return false;
		if (proStock == null) {
			if (other.proStock != null)
				return false;
		} else if (!proStock.equals(other.proStock))
			return false;
		if (proId == null) {
			if (other.proId != null)
				return false;
		} else if (!proId.equals(other.proId))
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
		if (proStatus == null) {
			if (other.proStatus != null)
				return false;
		} else if (!proStatus.equals(other.proStatus))
			return false;
		if (smId == null) {
			if (other.smId != null)
				return false;
		} else if (!smId.equals(other.smId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", proBrand=" + proBrand + ", proPrice=" + proPrice
				+ ", proStock=" + proStock + ", proStatus=" + proStatus + ", proImg=" + proImg + ", proDescription="
				+ proDescription + ", smId=" + smId + ", bigId=" + bigId + "]";
	}
	
	
	
}
