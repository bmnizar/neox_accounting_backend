package com.neoxiontechnologies.neoxAccounting.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neoxiontechnologies.neoxAccounting.dto.InvoiceDTO;
import com.neoxiontechnologies.neoxAccounting.dto.ProductDTO;
import com.neoxiontechnologies.neoxAccounting.services.ProductService;
import com.neoxiontechnologies.neoxAccounting.utils.NeoxAccountingUtils;

@Controller
@RequestMapping(NeoxAccountingUtils.GENERAL_REST_URL + "/ProductRest")
public class ProductRest {
	
	private ProductService productService;

	@PostMapping(value = "/createProduct") //
	@ResponseBody
	public void createProduct(@RequestBody ProductDTO productDTO) {

		productService.createProduct(productDTO);

	}

	@GetMapping(value = "/listProducts") //
	@ResponseBody
	public List<ProductDTO> listProducts() {

		return productService.listProducts();

	}
}
