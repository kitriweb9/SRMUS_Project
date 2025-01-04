package org.kitri.services.store.customer.service;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpSession;

import org.kitri.services.store.repo.dto.SsmCusLgnDto;

public interface ISsmCusLgnSvc {
	public boolean register(SsmCusLgnDto customer) throws SQLIntegrityConstraintViolationException;
	public boolean login(HttpSession session, String id, String pwd);
	public boolean logout(HttpSession session, String id);
	public SsmCusLgnDto userInfo(String id);
}
