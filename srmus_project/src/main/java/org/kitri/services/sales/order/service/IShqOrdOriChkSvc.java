package org.kitri.services.sales.order.service;

import java.util.List;

import org.kitri.services.sales.order.dto.ShqOrdOriChkDto;

public interface IShqOrdOriChkSvc {
	List<ShqOrdOriChkDto> searchOrders(String orderId, String goodsName);
	
	void filterOrdersStatus(List<ShqOrdOriChkDto> ordersList);
}
