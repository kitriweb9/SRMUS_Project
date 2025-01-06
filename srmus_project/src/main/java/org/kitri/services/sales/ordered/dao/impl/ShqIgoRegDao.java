package org.kitri.services.sales.ordered.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kitri.services.sales.ordered.dao.IShqIgoRegDao;
import org.kitri.services.sales.ordered.dto.ShqIgoRegIIDto;
import org.kitri.services.sales.ordered.dto.ShqIgoRegIRDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqIgoRegDao implements IShqIgoRegDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// orderId로 상품아이디, 상품 개수 조회해서 ShqIgoRegISIDto 넣기
	@Override
	public List<ShqIgoRegIRDto> inquiryByOrderId(String orderId) {
		return sessionTemplate.selectList("ordered.inquiryByOrderId", orderId);
	}
	 
	// integration테이블에 넣기
	@Override
	public int integrationRegistration(List<ShqIgoRegIRDto> integrationData) {
		int cnt = 0;
		for (ShqIgoRegIRDto data : integrationData) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("goodsId", data.getGoodsId());
	        params.put("orderQuantity", data.getOrderQuantity());
	        params.put("employeeId", data.getEmployeeId());
	        cnt = sessionTemplate.insert("ordered.integrationInboundRegistration", params);
		}
		return cnt;
	}

	@Override
	public int changeOrderStatus(String orderId, String status) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("orderId", orderId); params.put("status", status);
		return sessionTemplate.update("ordered.changeOrderStatus", params);
	}

	@Override
	public List<ShqIgoRegIIDto> allIntegrationOrderInquiry() {
		return sessionTemplate.selectList("ordered.integrationOrderInquiry");
	}

	@Override
	public List<ShqIgoRegIIDto> integrationOrderInquiryBydate(String date) {
		return sessionTemplate.selectList("ordered.integrationOrderInquiryBydate",date);
	}
		

}
