package com.neoxiontechnologies.neoxAccounting.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neoxiontechnologies.neoxAccounting.dto.ProductDTO;
import com.neoxiontechnologies.neoxAccounting.utils.NeoxAccountingUtils;

@Controller
@RequestMapping("TestRest")
public class TestRest {
	@GetMapping(value = "/getValue") //

	public String getValue() throws InterruptedException {
		Thread.sleep(666666);
		return "aaa";

	}
}
