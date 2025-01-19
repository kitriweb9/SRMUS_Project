# 매장 통합 관리 시스템
SRMUS (Store Resource Management Unified System)는 매장 통합 관리 시스템으로, 영업 본부가 여러 매장을 효율적으로 관리할 수 있도록 설계된 시스템입니다.
고객과 매장 직원을 위한 사용자 인터페이스와 함께 구매, 판매, 발주, 입고, 재고 관리 기능을 제공합니다. 본 시스템은 데이터 보안을 강화하기 위해 데이터 이중화 및 암호화 방식을 사용하며, 파일 전송을 통해 본사와 매장 간의 효율적인 데이터 교환을 지원합니다.

## 개요

**프로젝트 명:** 매장 통합 관리 시스템

**프로젝트 기간:** 기간: 2024/12/16 ~ 2025/01/18

**담당자 및 역할**
| 개발팀 구분    | 담당자명 | 역할       | 프로젝트 주요 작업 내용                                                                                                    |
|---------------|---------|-----------|---------------------------------------------------------------------------------------------------------------------------|
| 매장 개발      | 정안식   | 팀장 (PL)  | - 팀원 코드 피드백, 프로젝트 구조 설계 및 서류 작성 <br> - 데이터 이중화 모듈, 매장 발주/입고/재고 시스템 개발, 프론트엔드 일부 작업 |
| 매장 개발      | 박시연   | 팀원       | 로그인 모듈, 매장 고객 시스템 개발                                                                                         |
| 매장 개발      | 현영은   | 팀원       | 암호화 모듈, 매장 구매/판매 시스템 개발                                                                                     |
| 영업 본부 개발 | 함예정   | 팀장 (PL)  | - 팀원 코드 피드백, 프로젝트 구조 설계 및 서류 작성, GIT 설계 <br> - 하신 일을 적어 주세요                                   |
| 영업 본부 개발 | 김율궁   | 팀원       | 권한 검증 모듈/ 본부 시스템 로그인, 직원 마이페이지, 매장관리, 상품관리, 마감관리 시스템 개발                                |
| 영업 본부 개발 | 문은서   | 팀원       | 하신 일을 적어 주세요                                                                                                      |




## 마일스톤
1. **기획 완료**: 2025/12/19  
2. **개발 완료**: 2025/01/18 
3. **배포 완료**: 배포 준비 중


## 기술 스택  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
    ![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
    ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
    ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
    ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
    ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
    ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
    ![Cent OS](https://img.shields.io/badge/cent%20os-002260?style=for-the-badge&logo=centos&logoColor=F0F0F0)
    ![GitBook](https://img.shields.io/badge/GitBook-%23000000.svg?style=for-the-badge&logo=gitbook&logoColor=white)

## 시스템 구성도
![System-diagram](https://raw.githubusercontent.com/kitriweb9/SRMUS_Project/master/document/system_diagram/system_diagram.png)

## 시스템 기능 및 업무 흐름

### 주요 기능

**1. 고객 관리 기능**
- **로그인 및 회원가입**:  
  고객은 ID와 비밀번호를 사용하여 로그인하며, 회원가입 시 입력된 정보는 데이터 이중화 및 암호화를 통해 안전하게 저장됩니다.
- **상품 조회 및 구매**:  
  고객은 상품 목록에서 원하는 상품을 선택하고 구매할 수 있으며, 구매 내역을 확인할 수 있습니다.
- **구매 취소 요청**:  
  구매 후 마음에 들지 않는 상품에 대해 구매 취소를 요청할 수 있습니다.

**2. 직원 관리 기능**
- **로그인**:  
  매장 직원은 ID와 비밀번호를 통해 로그인합니다.
- **판매 관리**:  
  고객 구매 내역을 확인하고 판매를 승인하거나 거부할 수 있습니다.
- **판매 확정**:  
  승인된 판매를 확정하여 매장 재고에 반영합니다.
- **구매 취소 내역 관리**:  
  고객이 요청한 구매 취소 내역을 확인하고 처리할 수 있습니다.

**3. 발주 관리 기능**
- **발주 등록 및 수정**:  
  상품 ID와 수량을 입력하여 발주를 생성하거나 기존 발주를 수정할 수 있습니다.
- **발주 확정 및 전송**:  
  발주를 확정한 후, 해당 내용을 이미지로 변환하여 파일 서버를 통해 본사로 전송합니다. 본사는 이를 처리하여 DB에 반영합니다.

**4. 입고 관리 기능**
- **입고 데이터 조회**:  
  본사에서 전송된 입고 데이터를 매장에서 확인할 수 있습니다.
- **입고 수정**:  
  잘못된 입고 데이터(예: 수량 부족, 손상 등)를 수정할 수 있습니다.
- **입고 확정**:  
  수정된 데이터를 확정하여 매장 재고에 반영합니다.

**5. 재고 관리 기능**
- **재고 조회**:  
  현재 매장의 재고 상태를 확인할 수 있습니다.
- **재고 수정**:  
  특정 상품의 재고량 및 안전재고수량을 수정할 수 있습니다.

**6. 데이터 보안 기능**
- **데이터 이중화 및 암호화**:  
  고객 회원가입 시 입력된 정보는 평문 DB와 암호화 DB에 동기화됩니다.  
  비밀번호는 JSP 단에서 SHA-256으로 암호화됩니다.  
  기타 데이터는 AES-256으로 암호화 및 복호화 과정을 거쳐 안전하게 저장됩니다.
- **HTTP 보안 강화**:  
  HTTPS가 적용되지 않은 환경에서 데이터의 안전한 전송을 보장하기 위해 암호화 모듈을 활용합니다.

## 추가 첨부 문서

[![업무 정의서](https://img.shields.io/badge/-업무%20정의서-blue?style=for-the-badge&link=https://)](#link)
[![요구사항 명세서](https://img.shields.io/badge/-요구사항%20명세서-green?style=for-the-badge&link=https://)](#link)
[![ER 다이어그램](https://img.shields.io/badge/-ER%20다이어그램-orange?style=for-the-badge&link=https://kitriweb9.gitbook.io/srmus/erd)](https://kitriweb9.gitbook.io/srmus/erd)
[![Class 다이어그램](https://img.shields.io/badge/-Class%20다이어그램-yellow?style=for-the-badge&link=https://kitriweb9.gitbook.io/srmus/class/cld)](https://kitriweb9.gitbook.io/srmus/class/cld)
[![Class 명세서](https://img.shields.io/badge/-Class%20명세서-red?style=for-the-badge&link=https://)](#link)
[![Data Flow 다이어그램](https://img.shields.io/badge/-Data%20Flow%20흐름도-purple?style=for-the-badge&link=https://kitriweb9.gitbook.io/srmus/dfd)](https://kitriweb9.gitbook.io/srmus/dfd)
[![Use Case 다이어그램](https://img.shields.io/badge/-Use%20Case%20다이어그램-teal?style=for-the-badge&link=https://)](#link)

