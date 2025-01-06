package org.kitri.services.store.sreturn.service.impl;

import org.kitri.services.store.sreturn.service.ISsmRtnSndSvc;
import org.springframework.stereotype.Service;

@Service
public class SsmRtnSndSvcImpl implements ISsmRtnSndSvc{
	@Override
	public void ssmReturnSend() {
		System.out.println("반품 요청 파일 생성");
		System.out.println("반품 요청 발송");
	}
}
