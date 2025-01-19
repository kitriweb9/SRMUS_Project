# 본부 수신 서버

[![Repository](https://img.shields.io/badge/View-Repository-blue)](https://github.com/kitriweb9/SRMUS_Project/tree/master/file_server/02headquarter.receiver) [![Diagram](https://img.shields.io/badge/View-Class_Diagram-blue)](../../cld.md#file-server-shq) [![Use Case Diagram](https://img.shields.io/badge/View-Use_Case_Diagram-blue)](../../use-case.md#file-server)



**패키지명:** com.thelightway.headquarter.receiver

**클래스명:** Setting  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/02headquarter.receiver/src/main/java/com/thelightway/headquarter/receiver/Setting.java)&#x20;

**클래스 타입:** Configuration

**클래스 개요**: 본부 수신 서버 설정을 설정 파일로부터 가져오는 클래스

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>SETTING_FILE_PATH</td><td>String</td><td>설정 파일 경로</td></tr><tr><td>private</td><td>SERVER_PORT</td><td>int</td><td>매장과 본부가 소켓 통신하는 포트</td></tr><tr><td>private</td><td>POLLING_TIME</td><td>int</td><td>수신한 파일이 있는지 확인하는 주기</td></tr><tr><td>private</td><td><p>TESS_DATA_</p><p>PATH</p></td><td>String</td><td>OCR 학습 데이터 파일 경로</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>getSetting</td><td>-</td><td>Properties</td><td>설정 파일을 읽어 Properties 객체로 반환</td></tr><tr><td>private</td><td><p>printMsgNot</p><p>FoundSetting</p></td><td>-</td><td>void</td><td><p>설정 파일이 없다는 </p><p>메시지 콘솔에 출력</p></td></tr><tr><td>public</td><td>getServerPort</td><td>-</td><td>int</td><td>SERVER_PORT 반환</td></tr><tr><td>public</td><td>getPollingTime</td><td>-</td><td>void</td><td>POLLING_TIME 반환</td></tr><tr><td>public</td><td><p>getStore</p><p>ReceivePath</p></td><td>storeId: String</td><td>String</td><td>전송 폴더 경로 반환</td></tr><tr><td>public</td><td>getTessDataPath</td><td>-</td><td>String</td><td>TESS_DATA_PATH 반환</td></tr><tr><td>public</td><td>getDBInfo</td><td>-</td><td>DBInfo</td><td><p>설정 파일을 읽고 </p><p>DB 접속 정보를 </p><p>DBInfo 클래스 객체로 반환</p></td></tr></tbody></table>



***



**패키지명:** com.thelightway.headquarter.receiver.dao

**클래스명:** DBInfo  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/02headquarter.receiver/src/main/java/com/thelightway/headquarter/receiver/dao/DBInfo.java)&#x20;

**클래스 타입:** Configuration

**클래스 개요**: 데이터 베이스 접속 정보를 가진 클래스

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>DB_URL</td><td>String</td><td>DB 접속 URL과 포트</td></tr><tr><td>private</td><td>DB_ID</td><td>String</td><td>DB 접속 사용자 아이디</td></tr><tr><td>private</td><td>DB_PWD</td><td>String</td><td>DB 접속 사용자 패스워드</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>getDbUrl</td><td>-</td><td>String</td><td>DB_URL 반환</td></tr><tr><td>public</td><td>getId</td><td>-</td><td>String</td><td>DB_ID 반환</td></tr><tr><td>public</td><td>getPwd</td><td>-</td><td>String</td><td>DB_PWD 반환</td></tr></tbody></table>



***



**패키지명:** com.thelightway.headquarter.receiver.dao

**클래스명:** ReceiverDao  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/02headquarter.receiver/src/main/java/com/thelightway/headquarter/receiver/dao/ReceiverDao.java)&#x20;

**클래스 타입:** DAO

**클래스 개요**: 수신된 데이터를 데이터베이스에 기록하는 클래스

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>DB_INFO</td><td>DBInfo</td><td>DB 접속 정보</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>saveData</td><td><p>data: </p><p>Map&#x3C;String, String></p></td><td>int</td><td><p>수신된 데이터</p><p>(Map 객체)를 </p><p>데이터베이스에 저장 후</p><p>추가된 행 개수 반환</p></td></tr><tr><td>public</td><td>convertTextToSql</td><td><p>tableName: String, </p><p>data: Map&#x3C;String, String></p></td><td>String</td><td><p>매개변수 값을 기반으로 </p><p>Insert SQL문을 </p><p>생성하여 반환</p></td></tr><tr><td>public</td><td>getPwd</td><td>-</td><td>String</td><td>DB_PWD 반환</td></tr></tbody></table>



***



**패키지명:** com.thelightway.headquarter.receiver.service

**클래스명:** SysComShqFieRcv  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/02headquarter.receiver/src/main/java/com/thelightway/headquarter/receiver/service/SysComShqFieRcv.java)&#x20;

**클래스 타입:** Application

**클래스 개요**: 파일을 수신하고 필요한 처리를 모두 수행하는 서비스 클래스

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>IMG_CONVERTER</td><td>SvcComItt</td><td>이미지 변환 모듈</td></tr><tr><td>private</td><td>DAO</td><td>ReceiverDao</td><td>DB 기록을 위한 Dao</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>main</td><td>args: String[]</td><td>void</td><td><p>프로그램 시작점, </p><p>jar파일로 배포 시 </p><p>start메소드실행</p></td></tr><tr><td>public</td><td>start</td><td>-</td><td>void</td><td><p>소켓 통신 서버를 </p><p>시작하고 매장 연결 대기</p><p>매장과 연결되면 </p><p>새로운 스레드 생성 후</p><p>매장과 소켓 통신 수행</p></td></tr></tbody></table>



***



**패키지명:** com.thelightway.headquarter.receiver.service.SysComShqFieRcv

**클래스명:** StoreSever  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/02headquarter.receiver/src/main/java/com/thelightway/headquarter/receiver/service/SysComShqFieRcv.java)&#x20;

**클래스 타입:** Runnable

**클래스 개요**: 본부 파일 수신 기능을 수행하는 클래스, 소켓 통신으로 파일 및 메시지를 수신하는 기능 제공

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>RECEIVE_PATH</td><td>String</td><td>수신 폴더 경로</td></tr><tr><td>private</td><td>STORE_ID</td><td>String</td><td><p>매장 아이디로 SysComShqFieRcv</p><p>클래스에서 최초 소켓 통신 연결시</p><p>처음으로 수신하는 데이터</p></td></tr><tr><td>private</td><td>socketInput</td><td>InputStream</td><td>매장에서 전송된 데이터를 읽기 위해 사용</td></tr><tr><td>private</td><td>socketOuput</td><td>OutputStream</td><td>매장으로 데이터를 전송할 때 사용</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>run</td><td>-</td><td>void</td><td><p>파일 수신을 수행</p><p>설정 시간만큼 대기 후, </p><p>수신한 파일 유무 확인</p><p></p><p>수신한 파일을 이미지</p><p>변환 모듈로 MAP 객체로 변환</p><p></p><p>DAO를 호출해 데이터를 DB에 저장</p></td></tr><tr><td>private</td><td>receiveFile</td><td><p>file: File, </p><p>fileName: String, </p><p>fileSize: long</p></td><td>void</td><td>파일 수신 수행</td></tr><tr><td>private</td><td><p>createFolder</p><p>IfNotExist</p></td><td>folder: File</td><td>void</td><td>수신 폴더 경로가 존재하지 않을 경우 폴더 생성</td></tr><tr><td>private</td><td>saveToDatabase</td><td><p>file: File, </p><p>keyAndValues: </p><p>  Map&#x3C;String, String></p></td><td>void</td><td><p>데이터 DB에 저장</p><p>수신한 파일 삭제</p></td></tr><tr><td>private</td><td>waitTime</td><td>waitTime: int</td><td>void</td><td>waitTime 값 만큼 대기</td></tr></tbody></table>



***

