package portfolio9th;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.kitri.services.sales.in.dao.impl.ShqInbExpDaoImpl;
import org.kitri.services.sales.in.entity.StoreInbound;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class TestShqInbExpDao {
	private static ShqInbExpDaoImpl dao;
	
	@Before
	public void setUp() throws Exception {
        // 1. 데이터소스 생성
        dao = new ShqInbExpDaoImpl(new TestSqlSession().getSession());
    }
	


    @org.junit.Test
    public void save() {
    	StoreInbound storeInbound = new StoreInbound()
    								  .setStoreId("ST001")
    								  .setGoodsId("GDS001")
    								  .setInboundQuantity(2)
    								  .setInboundDate(Timestamp.valueOf(LocalDateTime.now()));
    			
    	dao.save(storeInbound);
    }
    
    @org.junit.Test
    public void findAll() {
    	List<StoreInbound> findAll = dao.findAll();
    	System.out.println(findAll.size());
    }
    
    @org.junit.Test
    public void findByStoreId() {
    	String storeId = "ST002'";
    	System.out.println("STORE 검색");
    	List<StoreInbound> findAll = dao.findById(storeId);
    	for (StoreInbound storeInbound : findAll) {
			System.out.println(storeInbound.getStoreId());
		}
    }
    
}
