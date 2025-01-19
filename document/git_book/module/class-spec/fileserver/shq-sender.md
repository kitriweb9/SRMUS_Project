---
description: '작성자: 함예정'
---

# 본부 송신 서버

[![Repository](https://img.shields.io/badge/View-Repository-blue)](https://github.com/kitriweb9/SRMUS_Project/tree/master/file_server/01HeadquarterSender/src) [![Diagram](https://img.shields.io/badge/View-Class_Diagram-blue)](../../cld.md#file-server-shq) [![Use Case Diagram](https://img.shields.io/badge/View-Use_Case_Diagram-blue)](../../use-case.md#file-server)



**패키지명:** -

**클래스명:** Setting  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/01HeadquarterSender/src/Setting.java)

**클래스 타입:** Configuration&#x20;

**클래스 개요**: 본부 송신 서버 설정을 설정 파일로부터 가져오는 클래스

**속성 (Attribute):**

| 접근제어자   | 속성명           | 타입  | 설명                                |
| ------- | ------------- | --- | --------------------------------- |
| private | SERVER\_PORT  | int | <p>매장과 본부가 </p><p>소켓 통신하는 포트</p>  |
| private | POLLING\_TIME | int | <p>전송할 파일이 있는지 </p><p>확인하는 주기</p> |

**메소드(Method):**

<table><thead><tr><th width="125">접근제어자</th><th width="153">메소드명</th><th>매개변수</th><th width="118">반환값</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>getSetting</td><td>-</td><td>Properties</td><td>설정 파일을 읽어 Properties 객체로 반환</td></tr><tr><td>private</td><td>printMsgNotFoundSetting</td><td>-</td><td>void</td><td>설정 파일이 없다는 메시지 콘솔에 출력</td></tr><tr><td>public</td><td>getServerPort</td><td>-</td><td>int</td><td>속성 값 SERVER_PORT 반환</td></tr><tr><td>public</td><td>getPollingTime</td><td>-</td><td>int</td><td>속성 값 POLLING_TIME 반환</td></tr><tr><td>public</td><td>getStoreSendPath</td><td>storeId: String</td><td>String</td><td><p>입력 받은 storeId를 </p><p>포함한 전송 폴더 경로 반환</p></td></tr></tbody></table>



***



**패키지명:** -

**클래스명:** SysComShqFieSnd  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/01HeadquarterSender/src/SysComShqFieSnd.java)

**클래스 타입:** Module

**클래스 개요**: 본부 송신 서버를 수행하는 클래스, 소켓 통신으로 본부와 매장을 연결함

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>main</td><td>args: String[]</td><td>void</td><td><p>프로그램 시작점, </p><p>jar파일로 배포 시 </p><p>start메소드실행</p></td></tr><tr><td>public</td><td>start</td><td>-</td><td>void</td><td><p>소켓 통신 서버를 시작</p><p>하고 매장 연결을 대기</p><p></p><p>매장과 연결되면 </p><p>새로운 스레드 생성</p><p></p><p>매장과 소켓 통신 수행</p></td></tr><tr><td>private</td><td><p>getSocket</p><p>BufferedReader</p></td><td>socket: Socket</td><td><p>Buffered</p><p>Reader</p></td><td><p>연결된 소켓의 입력</p><p>스트림을  Buffered</p><p>Reader로 반환</p></td></tr><tr><td>private</td><td><p>printMsgConnect</p><p>Success</p></td><td>storeId: String</td><td>void</td><td><p>매장 연결 상태와 </p><p>매장 ID를 콘솔에</p><p>출력합니다.</p></td></tr></tbody></table>



***



**패키지명:** SysComShqFieSnd

**클래스명:** StoreSever  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../../file_server/01HeadquarterSender/src/SysComShqFieSnd.java)

**클래스 타입:** Runnable

**클래스 개요**: 본부 송신 기능을 수행하는 클래스, 소켓 통신으로 파일 및 메시지를 송신하는 기능 제공

**속성 (Attribute):**

<table><thead><tr><th width="131">접근제어자</th><th width="153">속성명</th><th width="153">타입</th><th>설명</th></tr></thead><tbody><tr><td>private</td><td>STORE_ID</td><td>String</td><td><p>매장 아이디로 SysComShqFieSnd</p><p>클래스에서 최초 소켓 통신 연결시</p><p>처음으로 수신하는 데이터</p></td></tr><tr><td>private</td><td>SEND_PATH</td><td>int</td><td>송신 폴더 경로</td></tr><tr><td>private</td><td>socketInput</td><td>InputStream</td><td><p>소켓의 입력 스트림</p><p>매장에서 전송된 데이터를 읽을 때 사용</p></td></tr><tr><td>private</td><td>socketOuput</td><td>OutputStream</td><td><p>소켓의 출력 스트림</p><p>매장으로 데이터를 전송할 때 사용</p></td></tr><tr><td>private</td><td>sending</td><td>boolean</td><td>파일 전송 진행 상태</td></tr></tbody></table>

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="154">메소드명</th><th width="154">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>run</td><td>-</td><td>void</td><td><p>파일 송신을 수행하는 </p><p>메소드</p><p>설정된 시간만큼 대기 </p><p>후, 전송 파일 유무 확인</p><p>/전송 작업을 반복함</p></td></tr><tr><td>private</td><td>closeSocket</td><td>-</td><td>void</td><td><p>매장과 소켓 연결</p><p>종료 시, 소켓을 닫고 </p><p>리소스 정리</p></td></tr><tr><td>private</td><td>findFilesToSend</td><td>-</td><td>List&#x3C;File></td><td>송신 폴더 확인</td></tr><tr><td>private</td><td>sendText</td><td>msg: Object</td><td>void</td><td>매장으로 문자 정보 전송</td></tr><tr><td>private</td><td>sendFile</td><td>sendFiles: List</td><td>void</td><td>매장으로 PNG 이미지 파일 전송</td></tr><tr><td>private</td><td>waitTime</td><td>waitTime: int</td><td>waitTime: int</td><td>매개변수 waitTime 값 만큼 대기</td></tr></tbody></table>

