package org.kitri.services.sales.ordered.dao;

import java.util.List;

import org.kitri.services.sales.ordered.dto.ShqIgoRegIIDto;
import org.kitri.services.sales.ordered.dto.ShqIgoRegIRDto;

public interface IShqIgoRegDao {
	List<ShqIgoRegIRDto> inquiryByOrderId(String orderId);
	
	int integrationRegistration(List<ShqIgoRegIRDto> integrationData);
	
	int changeOrderStatus(String orderId, String status);
	
	List<ShqIgoRegIIDto> allIntegrationOrderInquiry();
	
	List<ShqIgoRegIIDto> integrationOrderInquiryBydate(String date);
	
}
