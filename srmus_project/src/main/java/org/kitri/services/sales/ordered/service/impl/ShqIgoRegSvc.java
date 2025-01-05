package org.kitri.services.sales.ordered.service.impl;

import java.util.List;

import org.kitri.services.sales.ordered.dao.IShqIgoRegDao;
import org.kitri.services.sales.ordered.dto.ShqIgoRegIIDto;
import org.kitri.services.sales.ordered.dto.ShqIgoRegIRDto;
import org.kitri.services.sales.ordered.service.IShqIgoRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqIgoRegSvc implements IShqIgoRegSvc {

	@Autowired
	private IShqIgoRegDao iRegDao;

	@Override
	public String integrationOrderRegistration(String orderId, String employeeId) {
		String result = null;
		List<ShqIgoRegIRDto> isiDtos = iRegDao.inquiryByOrderId(orderId);
		for(ShqIgoRegIRDto data : isiDtos) {
			data.setEmployeeId(employeeId);
		}
		int cnt = iRegDao.integrationRegistration(isiDtos);
		if(cnt > 0) {
			iRegDao.changeOrderStatus(orderId, "Y");
			result = "통합 발주에 등록되었습니다.";
		} else {
			result = "통합 발주에 실패하였습니다."; 
		}
		return result;
	}

	@Override
	public List<ShqIgoRegIIDto> integrationOrderInquiry(String date) {
		List<ShqIgoRegIIDto> integrationList = null;
		if(date.isEmpty()||date==null) {
			integrationList = iRegDao.allIntegrationOrderInquiry();
		} else if(!date.isEmpty()||date!=null) {
			integrationList = iRegDao.integrationOrderInquiryBydate(date);
		}
		return integrationList;
	}
}
