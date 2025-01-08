package org.kitri.system.dualdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DualDataService {

	private final IDualDataModuleFactory moduleFactory;
	private final EncryptedDtoDao encryptedDtoDao;

	@Autowired
	public DualDataService(IDualDataModuleFactory moduleFactory, EncryptedDtoDao encryptedDtoDao) {
		this.moduleFactory = moduleFactory;
		this.encryptedDtoDao = encryptedDtoDao;
	}

	public void executeModule() {
		ExampleDto exampleDto = new ExampleDto();
		// DualDataModule을 사용하여 데이터 처리
		try (IDualDataModule module = moduleFactory.createModule(exampleDto)) {
			// DualDataModule에서 EncryptedDto 생성
			EncryptedDto encryptedDto = module.modifyToDto();

			// DAO를 사용하여 EncryptedDto 저장
			encryptedDtoDao.insertEncryptedData(encryptedDto);

			System.out.println("Data saved successfully: " + encryptedDto.getEncryptedFields());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
