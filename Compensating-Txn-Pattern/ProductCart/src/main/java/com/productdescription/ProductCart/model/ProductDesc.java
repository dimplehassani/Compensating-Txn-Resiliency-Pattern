package com.productdescription.ProductCart.model;

public class ProductDesc {

	private long productId;
	private String category_name;
	private String productName;
	private String mfgDate;
	private String warranty;

	public ProductDesc() {
		super();
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return "ProductDesc [productId=" + productId + ", category_name=" + category_name + ", productName="
				+ productName + ", mfgDate=" + mfgDate + ", warranty=" + warranty + "]";
	}

}
