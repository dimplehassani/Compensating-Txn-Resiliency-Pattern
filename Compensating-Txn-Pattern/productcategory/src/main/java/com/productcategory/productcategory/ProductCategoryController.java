package com.productcategory.productcategory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/category-details")
public class ProductCategoryController {

	@RequestMapping( method = RequestMethod.GET)
	
	public Category getProductCategory() {
		Category cat = new Category();
		cat.setCategory_id("101");
		cat.setCategory_name("Facewash");
		return cat;	
	}
}
