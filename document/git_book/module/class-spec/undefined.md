# 이미지 변환 모듈

![Wrtier](https://img.shields.io/badge/Writer-%ED%95%A8%EC%98%88%EC%A0%95-blue)

**패키지명:** org.kitri.services.common.file.imgtotxt

**클래스명:** SvcComItt  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/services/common/file/imgtotxt/SvcComItt.java)

**클래스 타입:** Module

**클래스 개요**: PNG 이미지 파일을 Text로 변환하는 클래스

**속성 (Attribute):**

| 접근제어자   | 속성명              | 타입     | 설명               |
| ------- | ---------------- | ------ | ---------------- |
| private | TESS\_DATA\_PATH | String | OCR 학습 데이터 파일 경로 |

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="144">메소드명</th><th width="163">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>extractTextFromImage</td><td>imgPath: String</td><td>Map&#x3C;String, String></td><td><p>PNG 이미지를 텍스트로 변환</p><p>데이터를 해석하여 MAP 객체로 반환</p></td></tr></tbody></table>



***



**패키지명:** org.kitri.services.common.file.txttoimg

**클래스명:** SvcComTti  [![Repository](https://img.shields.io/badge/View-Repository-blue)](../../../../srmus_project/src/main/java/org/kitri/services/common/file/txttoimg/SvcComTti.java)

**클래스 타입:** Module

**클래스 개요**: DTO 데이터를 PNG 파일로 변환하는 클래스

**메소드(Method):**

<table><thead><tr><th width="130">접근제어자</th><th width="151">메소드명</th><th width="163">매개변수</th><th width="104">반환값</th><th>설명</th></tr></thead><tbody><tr><td>public</td><td>processTextToImage</td><td><p>object: Object,</p><p>type: int,</p><p>storeId: String</p></td><td>boolean</td><td><p>이미지 변환 후 </p><p>파일로 저장</p></td></tr><tr><td>public</td><td>fileNameSave</td><td>object: Object</td><td>String</td><td>저장할 파일 이름 반환</td></tr><tr><td>public</td><td>getDirectory</td><td><p>type: int, </p><p>storeId: String</p></td><td>String</td><td><p>이미지 파일을 </p><p>저장할 폴더 경로 반환</p></td></tr><tr><td>private</td><td><p>converting</p><p>TexttoImage</p></td><td>object: Object</td><td><p>Buffered</p><p>Image</p></td><td>객체를 이미지 파일로 변환</td></tr><tr><td>private</td><td><p>converting</p><p>SsmOrdSndDto</p><p>TexttoImage</p></td><td>object: Object</td><td><p>Buffered</p><p>Image</p></td><td>SsmOrdSndDto객체를 이미지 파일로 변환</td></tr><tr><td>private</td><td><p>converting</p><p>SsmRtnSndDto</p><p>TexttoImage</p></td><td>object: Object</td><td><p>Buffered</p><p>Image</p></td><td><p>SsmRtnSndDto객체를</p><p>이미지 파일로 변환</p></td></tr><tr><td>private</td><td><p>converting</p><p>ShqInbExpDto</p><p>TexttoImage</p></td><td>object: Object</td><td><p>Buffered</p><p>Image</p></td><td>ShqInbExpDto객체를 이미지 파일로 변환</td></tr><tr><td>private</td><td><p>saveImage</p><p>ToFile</p></td><td><p>bufferedImage:</p><p>   BufferedImage, fileName: String</p></td><td>boolean</td><td><p>BufferedImage 객체를 </p><p>이미지 파일로 저장</p></td></tr></tbody></table>



