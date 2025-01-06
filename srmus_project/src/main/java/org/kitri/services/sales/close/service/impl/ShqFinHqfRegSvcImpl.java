package org.kitri.services.sales.close.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.kitri.services.sales.close.dao.ShqFinHqfRegDao;
import org.kitri.services.sales.close.service.ShqFinHqfRegSvc;
import org.kitri.services.sales.repo.dto.ShqFinHqfRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqFinHqfRegSvcImpl implements ShqFinHqfRegSvc {
	private ShqFinHqfRegDao shqFinHqfRegDao;

	@Autowired
	public ShqFinHqfRegSvcImpl(ShqFinHqfRegDao shqFinHqfRegDao) {
		super();
		this.shqFinHqfRegDao = shqFinHqfRegDao;
	}

	@Override
	public String registHqClosingInfo(String hqClosingDate, int hqClosingAmount) {
		int insertResult = shqFinHqfRegDao
				.registHqClosingInfo(new ShqFinHqfRegDto(hqClosingAmount, convertStringToTimeStamp(hqClosingDate)));
		if (insertResult != 0) {
			return "성공적으로 마감정보가 등록되었습니다.";
		} else {
			return "등록에 실패하였습니다.";
		}
	}

	private Timestamp convertStringToTimeStamp(String requestDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(requestDate, formatter);
		return Timestamp.valueOf(localDate.atStartOfDay());
	}

}
