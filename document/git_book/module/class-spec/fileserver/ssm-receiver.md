# 매장 수신 서버

![Wrtier](https://img.shields.io/badge/Writer-%ED%95%A8%EC%98%88%EC%A0%95-blue) [![Repository](https://img.shields.io/badge/View-Repository-blue)](https://github.com/kitriweb9/SRMUS_Project/tree/master/file_server/04store.receiver) [![Diagram](https://img.shields.io/badge/View-Class_Diagram-blue)](../../cld.md#file-server-ssm) [![Use Case Diagram](https://img.shields.io/badge/View-Use_Case_Diagram-blue)](../../use-case.md#file-server)



**패키지명:** com.thelightway.store.receiver

**클래스명:** SysComSsmFieRcv  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/04store.receiver/src/main/java/com/thelightway/store/receiver/SysComSsmFieRcv.java)&#x20;

**클래스 타입:** Application

**클래스 개요**: 매장 송신 서버를 수행하는 클래스, 소켓 통신으로 파일 및 메시지를 수신하는 기능 제공

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>SERVER_IP</td><td>String</td><td>소켓 통신 본부 서버 IP</td></tr><tr><td>private</td><td>SERVER_PORT</td><td>int</td><td>소켓 통신 포트번호</td></tr><tr><td>private</td><td>RECEIVE_PATH</td><td>String</td><td>수신 폴더 경로</td></tr><tr><td>private</td><td>STORE_ID</td><td>String</td><td><p>매장 아이디로 SysComShqFieRcv</p><p>클래스에서 최초 소켓 통신 연결시 </p><p>처음으로 수신하는 데이터</p></td></tr><tr><td>private</td><td><p>IMG_</p><p>CONVERTER</p></td><td>SvcComItT</td><td>이미지 변환 모듈</td></tr><tr><td>private</td><td>DAO</td><td>ReceiverDao</td><td>DB 기록을 위한 Dao</td></tr><tr><td>private</td><td>socketInput</td><td>InputStream</td><td>매장에서 전송된 데이터를 읽을때 사용</td></tr><tr><td>private</td><td>socketOuput</td><td>OutputStream</td><td>매장으로 데이터를 전송할 때 사용</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>main</td><td>args: String[]</td><td>void</td><td><p>프로그램 시작점,</p><p>jar파일로 배포 시 </p><p>start메소드실행</p></td></tr><tr><td>public</td><td>run</td><td>-</td><td>void</td><td><p>파일 수신을 수행</p><p>설정 시간만큼 대기 후, </p><p>수신한 파일 유무 확인</p><p></p><p>수신한 파일을 이미지</p><p>변환 모듈로 MAP 객체로 변환</p><p></p><p>DAO를 호출해 데이터를 DB에 저장</p></td></tr><tr><td>private</td><td>connect</td><td>-</td><td>void</td><td>본부와 소켓 통신 연결</td></tr><tr><td>private</td><td>waitTime</td><td>time: int</td><td>void</td><td>time 값 만큼 대기</td></tr><tr><td>private</td><td>sendText</td><td>msg: String</td><td>void</td><td>본부로 문자 정보 전송</td></tr><tr><td>private</td><td>getSetting</td><td>-</td><td>Properties</td><td>설정 파일을 읽어 Properties 객체로 반환</td></tr><tr><td>private</td><td>start</td><td>-</td><td>void</td><td><p>소켓 통신 서버를 </p><p>시작하고 본부와 </p><p>소켓 통신 연결 후</p><p>설정한 주기마다 </p><p>파일 수신</p></td></tr><tr><td>private</td><td>receiveFile</td><td><p>fileSize: long, </p><p>file: File</p></td><td>void</td><td>파일 수신 수행</td></tr><tr><td>private</td><td>createParentDir</td><td>folder: File</td><td>File</td><td><p>수신 폴더 경로가 </p><p>존재하지 않을 경우</p><p>폴더 생성</p></td></tr></tbody></table>



***



**패키지명:** com.thelightway.store.receiver.dao

**클래스명:** ReceiverDao  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/04store.receiver/src/main/java/com/thelightway/store/receiver/dao/ReceiverDao.java)&#x20;

**클래스 타입:** DAO

**클래스 개요**: 수신된 데이터를 데이터베이스에 기록하는 클래스

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>dbUrl</td><td>String</td><td>DB 접속 주소</td></tr><tr><td>private</td><td>dbId</td><td>String</td><td>DB 접속 아이디</td></tr><tr><td>private</td><td>dbPw</td><td>String</td><td>DB 접속 비밀번호</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>saveData</td><td><p>data: </p><p>Map&#x3C;String, String></p></td><td>int</td><td><p>수신된 데이터</p><p>(Map 객체)를 </p><p>데이터베이스에 저장 후</p><p>추가된 행 개수 반환</p></td></tr><tr><td>public</td><td>convertTextToSql</td><td><p>tableName: String, </p><p>data: Map&#x3C;String, String></p></td><td>String</td><td><p>매개변수 값을 기반으로 </p><p>Insert SQL문을 </p><p>생성하여 반환</p></td></tr><tr><td>public</td><td>getPwd</td><td>-</td><td>String</td><td>DB_PWD 반환</td></tr></tbody></table>

