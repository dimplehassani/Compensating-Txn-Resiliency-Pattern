package com.productdescription.productdescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/productDescription")
public class ProductDescController {

	@Autowired
	ProductDescService prdService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ProductDesc> addProductDesc(@RequestBody ProductDesc prodDesc) {
		System.out.println("Incoming product details:"+prodDesc);
		ProductDesc prd = prdService.addProductDesc(prodDesc);
		System.out.println("success from service after save controller");
		return ResponseEntity.status(HttpStatus.OK).body(prd);
	}
}
