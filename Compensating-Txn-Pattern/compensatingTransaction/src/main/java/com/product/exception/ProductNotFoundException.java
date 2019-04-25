package com.product.exception;

/**
 * The Class ProductNotFoundException.
 */
public class ProductNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new product not found exception.
	 *
	 * @param str the str
	 */
	public ProductNotFoundException(String str) {
		super(str);
	}
	
}
