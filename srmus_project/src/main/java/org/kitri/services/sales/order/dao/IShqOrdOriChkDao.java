package org.kitri.services.sales.order.dao;

import java.util.List;

import org.kitri.services.sales.order.dto.ShqOrdOriChkDto;
import org.springframework.stereotype.Repository;

@Repository
public interface IShqOrdOriChkDao {
	List<ShqOrdOriChkDto> searchAllOrders();
	
	List<ShqOrdOriChkDto> searchByOrderId(String orderId);
	
	List<ShqOrdOriChkDto> searchBygoodsName(String goodsName);
	
	List<ShqOrdOriChkDto> searchByOrderIdGoodsName(String orderId, String goodsName);
}
