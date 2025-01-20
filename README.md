# 매장 통합 관리 시스템(SRMUS)
SRMUS (Store Resource Management Unified System)는 본사와 매장 간 통합 관리 시스템으로, 영업 본부와<br>
매장의 업무를 체계화하고 효율적으로 수행할 수 있도록 설계되었습니다.<br>
주요 목표는 데이터의 안전성과 정확성을 유지하며, 고객과 직원 모두의 사용 편의성을 증대시키는 것입니다.<br>
이 시스템은 영업 본부와 매장의 주요 기능을 지원하며, 데이터 이중화 및 암호화와 같은 보안 기술을 통해<br>
안정적인 서비스를 제공합니다.

## 개요

**프로젝트 명:** 매장 통합 관리 시스템

**프로젝트 기간:** 기간: 2024/12/16 ~ 2025/01/18

**담당자 및 역할**
| 개발팀 구분    | 담당자 | 역할       | 프로젝트 주요 작업 내용                                                                                                    |
|:---------------:|:---------:|:-----------:|:---------------------------------------------------------------------------------------------------------------------------|
| 매장 개발      | [정안식](https://github.com/LEELISE)| 팀장 (PL)  | - 팀원 코드 피드백, 프로젝트 구조 설계 및 서류 작성 <br> - 데이터 이중화 모듈, 매장 발주/입고/재고 시스템 개발,<br>&#8194;&#8201;프론트엔드 일부 작업 |
| 매장 개발      | 박시연   | 팀원       | - 로그인 모듈, 매장 고객 시스템 개발                                                                                        |
| 매장 개발      | [현영은](https://github.com/Dotorido)| 팀원       | - 암호화 모듈, 매장 구매/판매 시스템 개발                                                                                    |
| 영업 본부 개발 | [함예정](https://github.com/YJ-circle)   | 팀장 (PL)  | - 팀원 코드 피드백, 프로젝트 구조 설계 및 서류 작성, GIT 도입 <br>- 본부/매장 동기화 파일 서버 모듈 개발, 본부 입/출고 시스템 개발,<br>&#8194;&#8201;본부/매장 재고 관리 시스템 개발, 화면 레이아웃 개발|
| 영업 본부 개발 | [김율궁](https://github.com/Kim-YulKung)| 팀원       | - 권한 검증 모듈/ 본부 시스템 로그인, 직원 마이페이지,<br>&#8194;&#8201;매장관리, 상품관리, 마감관리 시스템 개발                               |
| 영업 본부 개발 | 문은서   | 팀원       | - 텍스트 이미지 상호 변환 모듈 개발, 직원 관리, 본부 발주 시스템 개발




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

## 시스템 요구사항, 업무 흐름 및 기대 효과

### 주요 요구사항 및 기능

**1. 공통 서비스**

- **페이지 권한 관리**:  
  - 권한 기반의 페이지 접근 제어  
  - 사용자의 권한 정보 등록 및 수정  
  - 권한 부족 시 오류 페이지 반환  

- **파일 전송**:  
  - 본사와 매장 간의 데이터 파일 전송 기능  
  - 발주 및 입고 데이터를 이미지 파일 형태로 변환 및 송수신  

- **로그인**:  
  - 직원 및 고객 로그인 처리  

**2. 영업 본부(본사) 서비스**

- **마감 관리**:  
  - 영업 마감 데이터를 생성 및 조회  

- **직원 관리**:  
  - 직원 정보 등록 및 조회  
  - 직원별 권한 및 역할 관리  

- **상품 관리**:  
  - 상품 등록, 수정, 삭제  
  - 상품 정보 조회  

- **입고 관리**:  
  - 매장에서 전송된 입고 요청 데이터 확인  
  - 입고 요청 데이터를 처리하고 승인  

- **발주 관리**:  
  - 발주 요청 데이터를 관리  
  - 발주 데이터를 DB에 반영하고 매장에 전달  

- **재고 관리**:  
  - 본사 전체 재고 현황 조회  

- **매장 관리**:  
  - 매장별 매출 및 운영 현황 모니터링  
  - 매장 데이터 수집 및 통합 관리  

**3. 매장 서비스**

- **고객 관리**:  
  - 고객 회원가입 및 로그인 처리  
  - 고객별 구매 내역 조회  

- **상품 관리**:  
  - 매장 내 상품 목록 조회 및 관리  
  - 상품별 재고 현황 확인  

- **입고 관리**:  
  - 본사에서 승인된 입고 데이터를 확인  
  - 입고 데이터 수정 및 확정  

- **발주 관리**:  
  - 상품 발주 요청 생성 및 수정  
  - 발주 요청 상태 확인 및 본사로 데이터 전송  

- **구매 관리**:  
  - 고객의 구매 요청 처리  
  - 구매 내역 기록 및 조회  

- **판매 관리**:  
  - 승인된 판매 내역 확정  
  - 판매 기록을 통해 재고 업데이트  

- **재고 관리**:  
  - 매장 재고 현황 조회 및 수정  
  - 안전 재고량 관리  

**4. 시스템 서비스**

- **데이터 이중화**:  
  - 주요 데이터는 평문 DB와 암호화 DB에 동기화 저장  
  - 장애 발생 시 데이터 손실 방지  

- **암호화**:  
  - SHA-256으로 비밀번호 암호화 처리  
  - AES-256으로 민감한 데이터 암호화 및 복호화  

---

### 업무 흐름

**1. 고객 사용 흐름**

- 고객은 회원가입 후 로그인합니다.  
- 상품 목록에서 원하는 상품을 선택하여 구매를 완료합니다.  
- 구매 내역에서 상품 정보를 확인하고, 필요시 구매 취소 요청을 진행합니다.  

**2. 직원 사용 흐름**

- 직원은 로그인 후 판매 목록에서 고객 구매 내역을 확인합니다.  
- 판매 요청을 승인하거나 거부합니다.  
- 승인된 판매는 판매 확정을 통해 재고에 반영됩니다.  
- 고객의 구매 취소 요청 내역을 확인하고 처리합니다.  

**3. 영업 본부와 매장 간 데이터 흐름**

- 매장에서 발주 등록 메뉴를 통해 상품 ID와 수량을 입력하여 발주 요청을 생성합니다.  
- 매장은 발주 데이터를 파일 서버를 통해 본사로 전송합니다.  
- 본사는 발주 데이터를 처리하여 DB에 반영하고, 입고 데이터를 매장으로 전송합니다.  
- 매장은 입고 데이터를 확인하고, 수정 및 확정을 통해 재고에 반영합니다.  

**4. 보안 처리 흐름**

- 회원가입 및 로그인 시 입력된 비밀번호는 SHA-256으로 암호화되어 전송됩니다.  
- 고객 데이터는 AES-256으로 암호화되어 서버로 전송되며, 복호화 후 데이터 이중화 모듈을 통해 안전하게 저장됩니다.  

---

### 기대 효과

- **운영 효율성 증대**:  
  영업 본부와 매장의 체계적 데이터 연동을 통해 업무 속도와 정확성을 향상.  

- **보안 강화**:  
  데이터 이중화 및 암호화를 통해 민감 데이터의 안전성을 확보.  

- **고객 만족도 향상**:  
  사용자 중심의 기능 제공으로 고객의 편의성 및 만족도 증대.  

- **유지보수 용이성**:  
  모듈화된 설계를 통해 새로운 요구사항이나 변경 사항에 유연하게 대응 가능.  

## 추가 첨부 문서

[![업무 정의서](https://img.shields.io/badge/-업무%20정의서-blue?style=for-the-badge&link=https://)](#link)
[![요구사항 명세서](https://img.shields.io/badge/-요구사항%20명세서-green?style=for-the-badge&link=https://)](#link)
[![ER 다이어그램](https://img.shields.io/badge/-ER%20다이어그램-orange?style=for-the-badge&link=https://kitriweb9.gitbook.io/srmus/erd)](https://kitriweb9.gitbook.io/srmus/erd)
[![Class 다이어그램](https://img.shields.io/badge/-Class%20다이어그램-yellow?style=for-the-badge&link=https://kitriweb9.gitbook.io/srmus/class/cld)](https://kitriweb9.gitbook.io/srmus/class/cld)
[![Class 명세서](https://img.shields.io/badge/-Class%20명세서-red?style=for-the-badge&link=https://)](#link)
[![Data Flow 다이어그램](https://img.shields.io/badge/-Data%20Flow%20흐름도-purple?style=for-the-badge&link=https://kitriweb9.gitbook.io/srmus/dfd)](https://kitriweb9.gitbook.io/srmus/dfd)
[![Use Case 다이어그램](https://img.shields.io/badge/-Use%20Case%20다이어그램-teal?style=for-the-badge&link=https://)](#link)

