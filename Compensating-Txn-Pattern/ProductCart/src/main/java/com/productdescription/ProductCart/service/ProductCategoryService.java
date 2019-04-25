package com.productdescription.ProductCart.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productdescription.ProductCart.model.Category;


@Service
public class ProductCategoryService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	public Category getCategoryDetails() {
		System.out.println("addprodcut servcie called");
		URI uri = URI.create("http://localhost:9091/category-details");
		Category cat = restTemplate.getForObject(uri, Category.class);
		System.out.println("Product recieved " + cat);
		return cat;	
	}
}
