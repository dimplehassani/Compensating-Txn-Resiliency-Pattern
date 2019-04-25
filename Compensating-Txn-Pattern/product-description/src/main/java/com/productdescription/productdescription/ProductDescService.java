package com.productdescription.productdescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductDescService {

	@Autowired
	ProductDescRepo repo;
	
	@Transactional
	public ProductDesc addProductDesc(ProductDesc prdDesc) {
		System.out.println("into service layer for save");
		repo.saveAndFlush(prdDesc);
		System.out.println("success from service after save");
		return prdDesc;
		
	}
}
