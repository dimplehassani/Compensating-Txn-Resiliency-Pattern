package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.exception.ProductNotFoundException;
import com.product.model.Product;
import com.product.service.ProductService;

/**
 * The Class ProductContoller.
 */
@RestController
@RequestMapping("/product")
public class ProductContoller {

	/** The product service. */
	@Autowired
	ProductService productService;

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return the response entity
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product prd = new Product();
		prd = productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(prd);
	}

	/**
	 * Verify product.
	 *
	 * @param prdId the prd id
	 * @param isomark the isomark
	 * @return the response entity
	 */
	/*@RequestMapping(value = "/verify/{prdId}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> verifyProduct(@PathVariable long prdId, @RequestBody String isomark) {
		try {
			char flag = productService.verifyProduct(prdId, isomark);
			if (flag == 'Y') {
				return ResponseEntity.status(HttpStatus.OK).body("Product is verified");
			}
		} catch (ProductNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sorry! Product not verified");
	}*/

	/**
	 * Gets the product details.
	 *
	 * @return the product details
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductDetails() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductDetails());
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable long id) {
		try {
			Optional<Product> prd = productService.findOne(id);
			return ResponseEntity.status(HttpStatus.OK).body(prd);
		} catch (ProductNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProduct(@PathVariable long id) {
		try {
			System.out.println("Inside delete service");
			productService.deleteProduct(id);
			System.out.println(" deleted ");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Product Deleted!");
	}

	/**
	 * Update product details.
	 *
	 * @param id the id
	 * @param prd the prd
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProductDetails(@PathVariable long id, @RequestBody Product prd) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductDetails(id, prd));
	}
}
