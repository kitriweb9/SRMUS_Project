package org.kitri.services.sales.ordered.service;

import java.util.List;

import org.kitri.services.sales.ordered.dto.ShqIgoRegIIDto;

public interface IShqIgoRegSvc {
	String integrationOrderRegistration(String employeeId, String orderId);
	
	List<ShqIgoRegIIDto> integrationOrderInquiry(String date);
}
