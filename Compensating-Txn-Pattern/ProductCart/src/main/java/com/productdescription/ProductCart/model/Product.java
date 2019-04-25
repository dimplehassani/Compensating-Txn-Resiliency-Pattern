package com.productdescription.ProductCart.model;

/**
 * The Class Product.
 */

public class Product {

	/** The product id. */

	private long product_id;

	/** The product name. */

	private String product_name;

	/** The desc. */

	private String categoryId;

	/** The status. */
	/*
	 * @Column(name="status", columnDefinition="VARCHAR(40) default 'Unverified'" )
	 * private String status = "Unverified";
	 */

	/**
	 * Instantiates a new product.
	 */
	public Product() {
		super();
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public long getProduct_id() {
		return product_id;
	}

	/**
	 * Sets the product id.
	 *
	 * @param product_id the new product id
	 */
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProduct_name() {
		return product_name;
	}

	/**
	 * Sets the product name.
	 *
	 * @param product_name the new product name
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the category id.
	 *
	 * @param categoryId the new category id
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	/*
	 * public String getStatus() { return status; }
	 * 
	 *//**
		 * Sets the status.
		 *
		 * @param status the new status
		 *//*
			 * public void setStatus(String status) { this.status = status; }
			 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", desc=" + categoryId + "]";
	}

}
