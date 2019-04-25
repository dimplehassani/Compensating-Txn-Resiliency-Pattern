package com.productdescription.productdescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDescRepo extends JpaRepository<ProductDesc, Long>{

}
