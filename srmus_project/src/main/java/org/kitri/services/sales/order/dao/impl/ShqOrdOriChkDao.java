package org.kitri.services.sales.order.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kitri.services.sales.order.dao.IShqOrdOriChkDao;
import org.kitri.services.sales.order.dto.ShqOrdOriChkDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqOrdOriChkDao implements IShqOrdOriChkDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Override
	public List<ShqOrdOriChkDto> searchAllOrders() {
		return sessionTemplate.selectList("order.searchAllOrders");
	}

	@Override
	public List<ShqOrdOriChkDto> searchByOrderId(String orderId) {
		return sessionTemplate.selectList("order.searchByOrderId", orderId);
	}

	@Override
	public List<ShqOrdOriChkDto> searchBygoodsName(String goodsName) {
		return sessionTemplate.selectList("order.searchBygoodsName", goodsName);
	}

	@Override
	public List<ShqOrdOriChkDto> searchByOrderIdGoodsName(String orderId, String goodsName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("orderId", orderId); params.put("goodsName", goodsName);
		return sessionTemplate.selectList("order.searchByOrderIdGoodsName", params);
	}
	
	
}
