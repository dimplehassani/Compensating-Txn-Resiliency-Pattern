package com.productdescription.ProductCart.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productdescription.ProductCart.model.ProductDesc;


@Service
public class ProductDescService {

	@Autowired
	private RestTemplate restTemplate;
	
	public ProductDesc saveProductDesc(ProductDesc prdDesc) {
		System.out.println("saveProductDesc servcie called" +prdDesc);
		URI uri = URI.create("http://localhost:8090/productDescription/save");
		ResponseEntity<ProductDesc> desc = restTemplate.postForEntity(uri, prdDesc, ProductDesc.class);
		System.out.println("Product desc recieved " + desc.getBody());
		return desc.getBody();	
	}
}
