package org.kitri.system.dualdata.shq;

import org.kitri.services.sales.in.entity.StoreInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ShqDualDataModuleFactory implements IShqDualDataModuleFactory {
	// ApplicationContext는 Spring의 IoC 컨테이너입니다. 필요한 빈을 생성하고, 관리하며, 의존성을 주입하는 작업을 수행합니다.
	// @Scope("prototype") 빈을 생성할 때 applicationContext.getBean()을 사용하면 항상 새로운 인스턴스를 생성할 수 있습니다.
	// + DualDataModuleImpl을 스프링 빈으로 수동 등록해주는 과정임 @Transactional 을 사용하기 위해서 구조를 변경하였음
	private final ApplicationContext applicationContext;

	@Autowired
	public ShqDualDataModuleFactory(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public IShqDualDataModule createModule(StoreInbound decryptedDto, ShqEncryptedDto encryptedDto) {
		// Spring 컨테이너에서 새로운 DualDataModuleImpl 인스턴스를 생성
		// 스프링 AOP는 인터페이스 기반 프록시를 생성하기에 getBean() 호출 시 인터페이스 타입으로 요청해야 함
		IShqDualDataModule module = applicationContext.getBean(IShqDualDataModule.class);
		module.initialize(decryptedDto, encryptedDto); // DTO 설정
		return module;
	}
}
