# 이중화 모듈

![Wrtier](https://img.shields.io/badge/Writer-%EC%A0%95%EC%95%88%EC%8B%9D-blue) [![Repository](https://img.shields.io/badge/View-Repository-blue)](https://github.com/kitriweb9/SRMUS_Project/tree/master/srmus_project/src/main/java/org/kitri/system/dualdata/factory) [![Diagram](https://img.shields.io/badge/View-Class_Diagram-blue)](../cld.md#dual-data) [![Use Case Diagram](https://img.shields.io/badge/View-Use_Case_Diagram-blue)](../use-case.md#dual-data)

## 1. 팩토리 관련

### 1.1 IDualDataModuleFactory  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/system/dualdata/factory/IDualDataModuleFactory.java)

#### **메서드** <a href="#method" id="method"></a>

* `createModule(Object dto): IDualDataModule`\
  DTO를 기반으로 이중화 모듈 객체를 생성하고 반환합니다.

### **1.2 DualDataModuleFactoryImpl**  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/system/dualdata/factory/impl/DualDataModuleFactoryImpl.java)

#### **필드** <a href="#field" id="field"></a>

* `applicationContext: ApplicationContext`\
  Spring의 ApplicationContext로, 필요한 빈(Bean)을 주입받습니다.

#### **생성자** <a href="#constructor" id="constructor"></a>

* `DualDataModuleFactoryImpl(applicationContext: ApplicationContext)`\
  ApplicationContext를 주입받아 초기화합니다.

#### **메서드** <a href="#method" id="method"></a>

* `createModule(Object dto): IDualDataModule`\
  `DualDataModuleImpl` 객체를 생성하고 DTO로 초기화하여 반환합니다.

***



[![Repository](https://img.shields.io/badge/View-Repository-blue)](https://github.com/kitriweb9/SRMUS_Project/tree/master/srmus_project/src/main/java/org/kitri/system/dualdata/core) [![Diagram](https://img.shields.io/badge/View-Class_Diagram-blue)](../cld.md#dual-data) [![Use Case Diagram](https://img.shields.io/badge/View-Use_Case_Diagram-blue)](../use-case.md#dual-data)

## 2. 모듈 관련 <a href="#module" id="module"></a>

### 2.1 IDualDataModule  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/system/dualdata/core/IDualDataModule.java)&#x20;

#### **메서드** <a href="#method" id="method"></a>

* `initialize(Object dto): void`\
  모듈 내부에서 사용할 DTO를 초기화합니다.
* `modifyToDto(): EncryptedDto`\
  DTO를 암호화하여 EncryptedDto로 변환합니다.
* `getSqlSessionTemplate(): SqlSessionTemplate`\
  데이터베이스와 상호작용하기 위한 SqlSessionTemplate을 반환합니다.
* `close(): void`\
  모듈 자원을 정리합니다. (AutoCloseable 인터페이스 구현)

### **2.2. DualDataModuleImpl**  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/system/dualdata/core/Impl/DualDataModuleImpl.java)&#x20;

#### **필드** <a href="#field" id="field"></a>

* `dto: Object`\
  모듈이 처리할 DTO 객체.
* `dtoParser: DtoParser`\
  DTO 문자열을 파싱하여 Map으로 변환하는 유틸리티.
* `dtoModifier: DtoModifier`\
  Map 데이터를 암호화하여 새로운 데이터를 생성하는 유틸리티.
* `sqlSessionTemplateProvider: SqlSessionTemplateProvider`\
  SqlSessionTemplate 객체를 생성하여 제공하는 유틸리티.

#### **생성자** <a href="#constructor" id="constructor"></a>

* `DualDataModuleImpl(DtoParser dtoParser, DtoModifier dtoModifier, SqlSessionTemplateProvider sqlSessionTemplateProvider)`\
  필요한 유틸리티 객체를 주입받아 초기화합니다.

#### **메서드** <a href="#method" id="method"></a>

* `initialize(Object dto): void`\
  DTO를 초기화합니다. Null이면 예외를 발생시킵니다.
* `modifyToDto(): EncryptedDto`\
  DTO를 암호화하여 EncryptedDto로 변환합니다.
* `getSqlSessionTemplate(): SqlSessionTemplate`\
  데이터베이스 작업에 사용할 SqlSessionTemplate을 반환합니다.
* `close(): void`\
  내부 필드를 초기화하고 리소스를 정리합니다.

***



[![Repository](https://img.shields.io/badge/View-Repository-blue)](https://github.com/kitriweb9/SRMUS_Project/tree/master/srmus_project/src/main/java/org/kitri/system/dualdata/dto/util) [![Diagram](https://img.shields.io/badge/View-Class_Diagram-blue)](../cld.md#dual-data) [![Use Case Diagram](https://img.shields.io/badge/View-Use_Case_Diagram-blue)](../use-case.md#dual-data)

## 3. 유틸리티 관련 <a href="#util" id="util"></a>

## 3.1 SqlSessionTemplateProvider  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/system/dualdata/core/Impl/SqlSessionTemplateProvider.java)&#x20;

#### **메서드** <a href="#method" id="method"></a>

* `createSqlSessionTemplate(): SqlSessionTemplate`\
  설정 파일에서 정보를 읽어 SqlSessionTemplate 객체를 생성하고 반환합니다.
* `loadProperties(): Properties`\
  `enc.setting` 파일에서 데이터베이스 설정 정보를 로드합니다.

### 3.2 DtoParser  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/system/dualdata/dto/util/DtoParser.java)&#x20;

#### **메서드** <a href="#method" id="method"></a>

* `parse(Object dto): Map<String, String>`\
  DTO 객체의 `toString()` 결과를 파싱하여 `[필드=값]` 형태의 문자열을 Map으로 변환합니다.

### 3.3 DtoModifier  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/system/dualdata/dto/util/DtoModifier.java)&#x20;

#### **필드**

* `encAesUtil: EncAesUtil`\
  AES256 암호화를 수행하는 유틸리티 객체.

#### **생성자** <a href="#constructor" id="constructor"></a>

* `DtoModifier(EncAesUtil encAesUtil)`\
  EncAesUtil 객체를 주입받아 초기화합니다.

#### **메서드** <a href="#method" id="method"></a>

* `modify(Map<String, String> fieldMap): Map<String, String>`\
  입력받은 Map 데이터를 AES256 암호화하여 새로운 Map으로 반환합니다.

***



[![Repository](https://img.shields.io/badge/View-Repository-blue)](https://github.com/kitriweb9/SRMUS_Project/tree/master/srmus_project/src/main/java/org/kitri/system/dualdata/dto) [![Diagram](https://img.shields.io/badge/View-Class_Diagram-blue)](../cld.md#dual-data) [![Use Case Diagram](https://img.shields.io/badge/View-Use_Case_Diagram-blue)](../use-case.md#dual-data)

## 4. DTO 관련

### 4.1 EncryptedDto  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/system/dualdata/dto/EncryptedDto.java)

#### **필드** <a href="#field" id="field"></a>

* `encryptedFields: Map<String, String>`\
  암호화된 데이터를 보관하는 필드.

#### **생성자** <a href="#constructor" id="constructor"></a>

* `EncryptedDto(Map<String, String> encryptedFields)`\
  암호화된 데이터로 객체를 생성합니다.

#### **메서드** <a href="#method" id="method"></a>

* `getEncryptedFields(): Map<String, String>`\
  암호화된 데이터를 반환합니다.
* `setEncryptedFields(Map<String, String>): void`\
  암호화된 데이터를 설정합니다.
