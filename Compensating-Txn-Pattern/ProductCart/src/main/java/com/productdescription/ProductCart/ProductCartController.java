package com.productdescription.ProductCart;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productdescription.ProductCart.model.Category;
import com.productdescription.ProductCart.model.Product;
import com.productdescription.ProductCart.model.ProductDesc;
import com.productdescription.ProductCart.service.ProductCartService;
import com.productdescription.ProductCart.service.ProductCategoryService;
import com.productdescription.ProductCart.service.ProductDescService;

@RestController
@RequestMapping("/productCart")
public class ProductCartController {

	
	@Autowired
	ProductCartService service;
	
	@Autowired
	ProductCategoryService categoryService;
	
	@Autowired
	ProductDescService prdDescService;
	
	@RequestMapping("/save")
	public ResponseEntity<?> addProductDetails(@RequestBody Product product) {
		Product prod = new Product();
		try {
			//Add Product details
			 prod = service.addProduct(product);
			
			//fetch category details
			Category cat = categoryService.getCategoryDetails();
			//System.out.println("category "+cat);
			
			//save the product description details
			ProductDesc newProdDesc = new ProductDesc();
			newProdDesc.setCategory_name(cat.getCategory_name());
			newProdDesc.setProductId(prod.getProduct_id());
			newProdDesc.setProductName(prod.getProduct_name());
			newProdDesc.setMfgDate("01-01-2019");
			newProdDesc.setWarranty("2 years");
			
			ProductDesc prdDesc = prdDescService.saveProductDesc(newProdDesc);
			
			System.out.println("Product Added success ");
			return ResponseEntity.status(HttpStatus.OK).body(prdDesc);
		}catch(Exception e) {
			if(Objects.nonNull(prod)) {
				service.deleteProduct(prod.getProduct_id());
			}
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error! Roll back txn");
		}
		// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request! try again");
		
	}
}
