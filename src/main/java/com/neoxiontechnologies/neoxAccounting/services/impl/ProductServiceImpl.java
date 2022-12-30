package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neoxiontechnologies.neoxAccounting.dao.ProductDao;
import com.neoxiontechnologies.neoxAccounting.dto.ProductDTO;
import com.neoxiontechnologies.neoxAccounting.entities.ProductEntity;
import com.neoxiontechnologies.neoxAccounting.services.ProductService;
import com.neoxiontechnologies.neoxAccounting.utils.ProductMappingUtility;

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void createProduct(ProductDTO productDTO) {
		ProductEntity productEntity = ProductMappingUtility.convertProductDtoToEntiy(productDTO);
		productDao.save(productEntity);
	}

	@Override
	public List<ProductDTO> listProducts() {
		List<ProductEntity> findAll = productDao.findAll();
		return ProductMappingUtility.convertListofProductEntitiestoDTO(findAll);

	}

}
