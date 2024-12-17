package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.util.Comparator;

import com.neoxiontechnologies.neoxAccounting.entities.BillEntity;

public class DateComparator implements Comparator<BillEntity> {

	@Override
	public int compare(BillEntity o1, BillEntity o2) {
		return o2.getDateOfBill().compareTo(o1.getDateOfBill());
  
	}

}
