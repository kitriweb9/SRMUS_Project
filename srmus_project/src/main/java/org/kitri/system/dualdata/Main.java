package org.kitri.system.dualdata;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Spring Context 초기화
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/dispatcher-servlet.xml");

		// 팩토리 및 DAO 빈 가져오기
		IDualDataModuleFactory moduleFactory = context.getBean(IDualDataModuleFactory.class);
		EncryptedDtoDao encryptedDtoDao = context.getBean(EncryptedDtoDao.class);

		// Example DTO 생성
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
