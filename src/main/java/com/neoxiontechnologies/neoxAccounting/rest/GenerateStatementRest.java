package com.neoxiontechnologies.neoxAccounting.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neoxiontechnologies.neoxAccounting.dto.CustomerDTO;
import com.neoxiontechnologies.neoxAccounting.dto.GenerateStatementRequestDTO;
import com.neoxiontechnologies.neoxAccounting.services.GenerateStatementService;
import com.neoxiontechnologies.neoxAccounting.utils.NeoxAccountingUtils;
@Controller
@RequestMapping(NeoxAccountingUtils.GENERAL_REST_URL + "/GenerateStatementRest")
public class GenerateStatementRest {
	@Autowired
	private GenerateStatementService generateStatementService;

	@PostMapping(value = "/generateStatement") //
	@ResponseBody
	public void generateStatement(@RequestBody GenerateStatementRequestDTO generateStatementRequestDTO)
			throws IOException {

		generateStatementService.generateStatement(generateStatementRequestDTO);

	}

}
