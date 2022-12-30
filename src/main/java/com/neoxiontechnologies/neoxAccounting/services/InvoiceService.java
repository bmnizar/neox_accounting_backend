package com.neoxiontechnologies.neoxAccounting.services;

import java.io.IOException;
import java.util.List;

import com.neoxiontechnologies.neoxAccounting.dto.InvoiceDTO;

/**
 ** @BMN 2021
 **
 **/

public interface InvoiceService {

	void createInvoice(InvoiceDTO invoiceDTO);

	List<InvoiceDTO> listInvoices();

	void deleteInvoice(Long id) throws IOException;

	Object downloadProof(String invoiceId);
	 

}
