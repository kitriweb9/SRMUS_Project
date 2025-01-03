package org.kitri.system.dualdata.shq;


import org.kitri.services.sales.in.entity.StoreInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Scope("prototype") // 호출될 때마다 새로운 인스턴스 생성
@Component
public class ShqDualDataModuleImpl implements IShqDualDataModule, AutoCloseable {

	private final ShqDecryptedAccessor decryptedAccessor;
	private final ShqEncryptedAccessor encryptedAccessor;
	private StoreInbound decryptedDto;
	private ShqEncryptedDto encryptedDto;
	
	@Autowired
	public ShqDualDataModuleImpl(ShqDecryptedAccessor decryptedAccessor, ShqEncryptedAccessor encryptedAccessor) {
		this.decryptedAccessor = decryptedAccessor;
		this.encryptedAccessor = encryptedAccessor;
	}
	
	@Override
	public void initialize(StoreInbound decryptedDto, ShqEncryptedDto encryptedDto) {
		if (decryptedDto == null || encryptedDto == null) {
			throw new IllegalArgumentException("DTO는 NULL일 수 없습니다.");
		}
		this.decryptedDto = decryptedDto;
		this.encryptedDto = encryptedDto;
	}

	@Override
	@Transactional
	public void saveDualData() {
		decryptedAccessor.insertDecryptedData(decryptedDto);
		encryptedAccessor.insertEncrypedData(encryptedDto);
	}

	@Override
	public void close() {
		digest();
	}

	private void digest() {
		this.decryptedDto = null;
		this.encryptedDto = null;
		System.out.println("DualDataModule 내부 데이터 초기화 완료");
	}
}
