---
hidden: true
---

# 클래스 양식



**패키지명:** com.thelightway.headquarter.receiver.service.SysComShqFieRcv

**클래스명:** StoreSever

**클래스 타입:** Runnable

**클래스 개요**: 본부 파일 수신 기능을 수행하는 클래스, 소켓 통신으로 파일 및 메시지를 수신하는 기능 제공

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>RECEIVE_PATH</td><td>String</td><td>수신 폴더 경로</td></tr><tr><td>private</td><td>STORE_ID</td><td>String</td><td><p>매장 아이디로 SysComShqFieRcv</p><p>클래스에서 최초 소켓 통신 연결시</p><p>처음으로 수신하는 데이터</p></td></tr><tr><td>private</td><td>socketInput</td><td>InputStream</td><td>매장에서 전송된 데이터를 읽기 위해 사용</td></tr><tr><td>private</td><td>socketOuput</td><td>OutputStream</td><td>매장으로 데이터를 전송할 때 사용</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>run</td><td>-</td><td>void</td><td><p>파일 수신을 수행</p><p>설정 시간만큼 대기 후, </p><p>수신한 파일 유무 확인</p><p></p><p>수신한 파일을 이미지</p><p>변환 모듈로 MAP 객체로 변환</p><p></p><p>DAO를 호출해 데이터를 DB에 저장</p></td></tr><tr><td>private</td><td>receiveFile</td><td><p>file: File, </p><p>fileName: String, </p><p>fileSize: long</p></td><td>void</td><td>파일 수신 수행</td></tr><tr><td>private</td><td><p>createFolder</p><p>IfNotExist</p></td><td>folder: File</td><td>void</td><td>수신 폴더 경로가 존재하지 않을 경우 폴더 생성</td></tr><tr><td>private</td><td>saveToDatabase</td><td><p>file: File, </p><p>keyAndValues: </p><p>  Map&#x3C;String, String></p></td><td>void</td><td><p>데이터 DB에 저장</p><p>수신한 파일 삭제</p></td></tr><tr><td>private</td><td>waitTime</td><td>waitTime: int</td><td>void</td><td>waitTime 값 만큼 대기</td></tr></tbody></table>



***

