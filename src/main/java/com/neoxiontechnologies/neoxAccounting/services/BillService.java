package com.neoxiontechnologies.neoxAccounting.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.neoxiontechnologies.neoxAccounting.dto.BillDTO;

public interface BillService {

	String createBill(BillDTO billDTO);

	List<BillDTO> listAllBills();

	void deleteBill(Long id) throws IOException;

	Object downloadProof(String billId);

	List<BillDTO> listAllBills(Date fromDate, Date toDate);

}
