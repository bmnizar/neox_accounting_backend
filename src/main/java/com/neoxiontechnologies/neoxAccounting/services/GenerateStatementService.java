package com.neoxiontechnologies.neoxAccounting.services;

import java.io.IOException;

import com.neoxiontechnologies.neoxAccounting.dto.GenerateStatementRequestDTO;

public interface GenerateStatementService {

	void generateStatement(GenerateStatementRequestDTO invoiceDTO) throws IOException;

}
