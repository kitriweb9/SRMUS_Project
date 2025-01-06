package org.kitri.services.sales.close.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.kitri.services.sales.close.dao.ShqFinMkfRegDao;
import org.kitri.services.sales.close.entity.MarketClosing;
import org.kitri.services.sales.close.service.ShqFinMkfRegSvc;
import org.kitri.services.sales.repo.dto.ShqFinMkfRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqFinMkfRegSvcImpl implements ShqFinMkfRegSvc {
	private ShqFinMkfRegDao shqFinMkfRegDao;

	@Autowired
	public ShqFinMkfRegSvcImpl(ShqFinMkfRegDao shqFinMkfRegDao) {
		super();
		this.shqFinMkfRegDao = shqFinMkfRegDao;
	}

	@Override
	public String registMarketClosingInfo(ShqFinMkfRegDto shqFinMkfRegDto) {
		if (shqFinMkfRegDao.registMarketClosingInfo(convertToEntity(shqFinMkfRegDto)) >= 1) {
			return "성공적으로 마감정보가 등록되었습니다.";
		}
		return "마감정보 등록에 실패하였습니다.";
	}

	private MarketClosing convertToEntity(ShqFinMkfRegDto shqFinMkfRegDto) {
		Timestamp markestClosingDate = convertStringToTimeStamp(shqFinMkfRegDto.getMarketClosingDate());
		MarketClosing marketClosing = new MarketClosing(shqFinMkfRegDto.getMarketClosingId(),
				shqFinMkfRegDto.getStoreId(), markestClosingDate, shqFinMkfRegDto.getMarketClosingAmount());
		return marketClosing;
	}

	private Timestamp convertStringToTimeStamp(String requestDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime localDateTime = LocalDateTime.parse(requestDate, formatter);
		return Timestamp.valueOf(localDateTime);
	}

}
