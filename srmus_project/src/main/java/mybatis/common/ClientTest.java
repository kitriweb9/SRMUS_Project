package mybatis.common;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {
	public static void main(String[] args) throws InterruptedException {
		DBCacheClient dbCacheClient = new DBCacheClient();
		Thread.sleep(1_000);
		TestDto dto = new TestDto("test", "홍", 22);
				
		dbCacheClient.inputCache("POST:findByMemberId:test", dto);
		Thread.sleep(1_000);
		Object cacheData1 = dbCacheClient.getCacheData("GET:findByMemberId:test", TestDto.class);
		System.out.println("cacheData1 = " + cacheData1);
		
		
		Object cacheData2 = dbCacheClient.getCacheData("GET:findByMemberId:tes2t", TestDto.class);
		System.out.println("cacheData2 = " + cacheData2);
		
		
		List<TestDto> list = new ArrayList<>();
		list.add(new TestDto("test1", "홍길동", 22));
		list.add(new TestDto("test2", "홍길동", 24));
		list.add(new TestDto("test3", "홍길동", 25));
		dbCacheClient.inputCache("POST:findByMemberName:홍길동", list);
		List cacheData3 = (List) dbCacheClient.getCacheData("GET:findByMemberName:홍길동", TestDto.class);
		System.out.println("cacheData3 = " + cacheData3);
		System.out.println(cacheData3.get(1));
		Thread.sleep(20_000);
	}
	
}
