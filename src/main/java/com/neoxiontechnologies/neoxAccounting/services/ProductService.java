package com.neoxiontechnologies.neoxAccounting.services;

import java.util.List;

import com.neoxiontechnologies.neoxAccounting.dto.ProductDTO;

public interface ProductService {

	void createProduct(ProductDTO productDTO);

	List<ProductDTO> listProducts();

}
