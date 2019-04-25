package com.productdescription.ProductCart.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productdescription.ProductCart.model.Product;


@Service
public class ProductCartService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	public Product addProduct(Product product) {
		System.out.println("addprodcut servcie called");
		URI uri = URI.create("http://localhost:8080/product/save");
		ResponseEntity<Product> prd = restTemplate.postForEntity(uri, product, Product.class);
		System.out.println("Product recieved " + prd.getBody());
		return prd.getBody();	
	}
	
	public void deleteProduct(long id) {
		System.out.println("Delete servcie called");
		URI uri = URI.create("http://localhost:8080/product");
		System.out.println(uri);
		//ResponseEntity<String> result = restTemplate.exchange(uri , HttpMethod.DELETE, null, String.class);
		Map<String, Object> urlVars = new HashMap<String, Object>();
		  String urlPath = "http://localhost:8080/product/{id}";
		  urlVars.put("id", id);
		 restTemplate.delete(urlPath, urlVars);
		System.out.println("Product Deleted Successfully ");
	}
}
