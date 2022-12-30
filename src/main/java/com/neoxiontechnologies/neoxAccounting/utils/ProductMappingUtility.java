package com.neoxiontechnologies.neoxAccounting.utils;

import java.util.ArrayList;
import java.util.List;

import com.neoxiontechnologies.neoxAccounting.dto.ProductDTO;
import com.neoxiontechnologies.neoxAccounting.entities.ProductEntity;

public class ProductMappingUtility {

	public static List<ProductDTO> convertListofProductEntitiestoDTO(List<ProductEntity> findAll) {
		List<ProductDTO>  ret  =new ArrayList<>();
		for (ProductEntity productEntity : findAll) {
			
		}
		return ret;
	}

	public static ProductEntity convertProductDtoToEntiy(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
