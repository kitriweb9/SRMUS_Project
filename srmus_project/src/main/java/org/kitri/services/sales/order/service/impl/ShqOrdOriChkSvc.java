package org.kitri.services.sales.order.service.impl;

import java.util.List;

import org.kitri.services.sales.order.dao.IShqOrdOriChkDao;
import org.kitri.services.sales.order.dto.ShqOrdOriChkDto;
import org.kitri.services.sales.order.service.IShqOrdOriChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqOrdOriChkSvc implements IShqOrdOriChkSvc {

	@Autowired
	private IShqOrdOriChkDao iChkDao;

	@Override
	public List<ShqOrdOriChkDto> searchOrders(String orderId, String goodsName) {
		List<ShqOrdOriChkDto> ordersList = null;
		if ((orderId == null || orderId.isEmpty()) && (goodsName == null || goodsName.isEmpty())) {
			ordersList = iChkDao.searchAllOrders();
		} else if ((!orderId.isEmpty() || orderId != null) && (goodsName.isEmpty() || goodsName == null)) {
			ordersList = iChkDao.searchByOrderId(orderId);
		} else if ((orderId.isEmpty() || orderId == null) && (!goodsName.isEmpty() || goodsName != null)) {
			ordersList = iChkDao.searchBygoodsName(goodsName);
		} else if ((!orderId.isEmpty() || orderId != null) && (!goodsName.isEmpty() || goodsName != null)) {
			ordersList = iChkDao.searchByOrderIdGoodsName(orderId, goodsName);
		}

		filterOrdersStatus(ordersList);

		return ordersList;
	}

	public void filterOrdersStatus(List<ShqOrdOriChkDto> ordersList) {
		if (ordersList == null) {
			return;
		}
		for (ShqOrdOriChkDto order : ordersList) {
			String status = order.getOrderConfirmStatus();
			switch (status) {
			case "N":
				order.setOrderConfirmStatus("수주");
				break;
			case "Y":
				order.setOrderConfirmStatus("발주 완료");
				break;
			default:
				order.setOrderConfirmStatus("미확인 상태");
				break;
			}
		}

	}

}
