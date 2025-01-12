package org.kitri.system.dualdata.core.Impl;

import java.util.Map;

import org.kitri.system.dualdata.core.IDualDataModule;
import org.kitri.system.dualdata.dto.EncryptedDto;
import org.kitri.system.dualdata.dto.util.DtoModifier;
import org.kitri.system.dualdata.dto.util.DtoParser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class DualDataModuleImpl implements IDualDataModule {

	private Object dto;
	private final DtoParser dtoParser;
	private final DtoModifier dtoModifier;
	private final SqlSessionTemplateProvider sqlSessionTemplateProvider;

	@Autowired
	public DualDataModuleImpl(DtoParser dtoParser, DtoModifier dtoModifier,
			SqlSessionTemplateProvider sqlSessionTemplateProvider) {
		this.dtoParser = dtoParser;
		this.dtoModifier = dtoModifier;
		this.sqlSessionTemplateProvider = sqlSessionTemplateProvider;
	}

	@Override
	public void initialize(Object dto) {
		if (dto == null) {
			throw new IllegalArgumentException("DTO는 NULL일 수 없습니다.");
		}
		this.dto = dto;
	}

	@Override
	public EncryptedDto modifyToDto() {
		if (this.dto == null) {
			throw new IllegalStateException("DTO가 초기화되지 않았습니다.");
		}

		Map<String, String> parsedFields = dtoParser.parse(this.dto);
		Map<String, String> encryptedFields = dtoModifier.modify(parsedFields);
		return new EncryptedDto(encryptedFields);
	}

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplateProvider.createSqlSessionTemplate();
	}

	@Override
	public void close() {
		this.dto = null;
		System.out.println("DualDataModule 내부 데이터 초기화 완료");
	}
}
