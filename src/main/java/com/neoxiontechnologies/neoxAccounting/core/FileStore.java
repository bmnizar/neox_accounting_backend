package com.neoxiontechnologies.neoxAccounting.core;

import org.springframework.content.commons.repository.Store;
import org.springframework.content.rest.StoreRestResource;

import com.neoxiontechnologies.neoxAccounting.utils.NeoxAccountingUtils;

@StoreRestResource(path = NeoxAccountingUtils.FILE_STORE_REST_NAME)
public interface  FileStore extends Store<String> {
}