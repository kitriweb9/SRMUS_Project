package org.kitri.services.store.customer.service.impl;

import java.util.List;

import org.kitri.services.store.customer.dao.ISsmCusMgtDao;
import org.kitri.services.store.customer.service.ISsmCusMgtSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.kitri.system.encryption.HexConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmCusMgtSvcImpl implements ISsmCusMgtSvc {
	@Autowired
	ISsmCusMgtDao mgtDao;
	
	@Override
	public List<SsmCusLgnDto> findCustomerAll() {
		return mgtDao.findCustomerAll();
	}

	@Override
	public boolean updateCustomer(SsmCusLgnDto customer) {
		if(mgtDao.updateCustomer(customer) == 1) {
			return true;
		}
		return false;
	}
}
