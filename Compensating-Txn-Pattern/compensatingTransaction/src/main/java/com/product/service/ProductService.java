package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.exception.ProductNotFoundException;
import com.product.model.Product;
import com.product.repository.ProductRepository;

/**
 * The Class ProductService.
 */
@Service
public class ProductService {

	/** The prd repo. */
	@Autowired
	private ProductRepository prdRepo;

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return the product
	 */
	@Transactional
	public Product addProduct(Product product) {
		Product prd = new Product();
		prd.setProduct_name(product.getProduct_name());
		prd.setCategoryId(product.getCategoryId());
		prdRepo.saveAndFlush(prd);
		return prd;
	}

	/**
	 * Verify product.
	 *
	 * @param prdId the prd id
	 * @param isomark the isomark
	 * @return the char
	 * @throws ProductNotFoundException the product not found exception
	 */
	/*public char verifyProduct(long prdId,String isomark) throws ProductNotFoundException {
		char flag = 'N';
		if(!StringUtils.isEmpty(isomark)) {
			if(isomark.contains(Isomark.YES.toString())) {
			Optional<Product> product = findOne(prdId);
			if(product.isPresent()) {
				if(product.get().getStatus().equals("Verified")) {
					flag = 'Y';
					return flag;
				}
				product.get().setStatus("Verified");
				prdRepo.saveAndFlush(product.get());
				flag = 'Y';
				return flag;
			}
			}else {
				deleteProduct(prdId);
				return flag;
			}
		}
		return flag;
		
	}*/
	
	/**
	 * Gets the product details.
	 *
	 * @return the product details
	 */
	public List<Product> getProductDetails() {
		return prdRepo.findAll();
	}
	
	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the optional
	 * @throws ProductNotFoundException the product not found exception
	 */
	public Optional<Product> findOne(@PathVariable long id) throws ProductNotFoundException {
		Optional<Product> product = prdRepo.findById(id);
		if(!product.isPresent()) {
			throw new ProductNotFoundException("Invalid Id");
		}
		return product;
	}


	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @throws ProductNotFoundException the product not found exception
	 */
	public void deleteProduct(@PathVariable long id) throws ProductNotFoundException {
		try {
		prdRepo.deleteById(id);
		}catch(Exception e) {
			throw new ProductNotFoundException("Invalid Id");
		}
	}

	/**
	 * Update product details.
	 *
	 * @param id the id
	 * @param prd the prd
	 * @return the product
	 */
	public Product updateProductDetails(@PathVariable long id, @RequestBody Product prd) {
		Optional<Product> product = prdRepo.findById(id);
		if (product.isPresent()) {
			Product newPrd = product.get();
			newPrd.setCategoryId(prd.getCategoryId());
			newPrd.setProduct_name(prd.getProduct_name());
			prdRepo.saveAndFlush(newPrd);
			return newPrd;
		}
		return null;
	}
}
