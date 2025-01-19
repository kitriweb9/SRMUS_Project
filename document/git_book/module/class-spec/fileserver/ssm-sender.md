# 매장 송신 서버

![Wrtier](https://img.shields.io/badge/Writer-%ED%95%A8%EC%98%88%EC%A0%95-blue) [![Repository](https://img.shields.io/badge/View-Repository-blue)](https://github.com/kitriweb9/SRMUS_Project/tree/master/file_server/03storeSenderlast/src) [![Diagram](https://img.shields.io/badge/View-Class_Diagram-blue)](../../cld.md#file-server-ssm) [![Use Case Diagram](https://img.shields.io/badge/View-Use_Case_Diagram-blue)](../../use-case.md#file-server)



**패키지명:** -

**클래스명:** SysComSsmFieSnd  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/03storeSenderlast/src/SysComSsmFieSnd.java)

**클래스 타입:** Application

**클래스 개요**: 매장 송신 서버를 수행하는 클래스, 소켓 통신으로 본부와 매장을 연결함

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>SETTING</td><td>Properties</td><td>설정 파일을 읽은 설정 값 객체</td></tr><tr><td>private</td><td>in</td><td>InputStream</td><td><p>소켓의 입력 스트림</p><p>매장에서 전송된 데이터를 읽기 위해 사용</p></td></tr><tr><td>private</td><td>out</td><td>OutputStream</td><td><p>소켓의 출력 스트림</p><p>매장으로 데이터를 전송할 때 사용</p></td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>main</td><td>args: String[]</td><td>void</td><td><p>프로그램 시작점,</p><p>jar파일로 배포 시 </p><p>start메소드실행</p></td></tr><tr><td>private</td><td>start</td><td>-</td><td>void</td><td><p>소켓 통신 서버를 </p><p>시작하고 본부와 소켓 </p><p>통신 연결 후 </p><p>설정한 주기마다 파일 송신</p></td></tr><tr><td>private</td><td>sendFile</td><td>sendFiles: List&#x3C;File></td><td>void</td><td>소켓 통신으로 파일 전송</td></tr><tr><td>private</td><td>waitTime</td><td>time: int</td><td>void</td><td>time 값 만큼 대기</td></tr><tr><td>private</td><td>getSendFile</td><td>-</td><td>List&#x3C;File></td><td><p>전송할 파일 </p><p>존재 유무 확인</p></td></tr><tr><td>private</td><td>connect</td><td>-</td><td>void</td><td>본부와 소켓 통신 연결</td></tr><tr><td>private</td><td>getSetting</td><td>-</td><td>Properties</td><td>설정 파일을 읽어 Properties 객체로 반환</td></tr></tbody></table>



***

