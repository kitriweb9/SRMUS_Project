package org.kitri.system.dualdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Scope("prototype")
@Component
public class DualDataModuleImpl implements IDualDataModule {

    private Object dto;
    private final DtoParser dtoParser;
    private final DtoModifier dtoModifier;

    @Autowired
    public DualDataModuleImpl(DtoParser dtoParser, DtoModifier dtoModifier) {
        this.dtoParser = dtoParser;
        this.dtoModifier = dtoModifier;
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
    public void close() {
        this.dto = null;
        System.out.println("DualDataModule 내부 데이터 초기화 완료");
    }
}
