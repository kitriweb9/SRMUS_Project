package portfolio9th;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.kitri.services.sales.in.dao.ShqInbImiDao;
import org.kitri.services.sales.in.dao.impl.ShqInbImiDaoImpl;
import org.kitri.services.sales.in.entity.IntegrationInbound;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class TestShqInbImiDao {
    private static ShqInbImiDao dao;
    

	@Before
	public void setUp() throws Exception {
        // 1. 데이터소스 생성
        DataSource dataSource = createDataSource();

        // 2. SqlSessionFactory 생성
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
        	    new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/**/*.xml")
        	);
        	sqlSessionFactoryBean.setTypeAliasesPackage("org.kitri.services.store.dto,org.kitri.services.sales.dto");

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

        // 3. SqlSessionTemplate 생성
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

        // 4. DAO 생성
        dao = new ShqInbImiDaoImpl(sqlSessionTemplate);
    }
	
    private DataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@blanks.life:16151:xe");
        dataSource.setUsername("kitri_test");
        dataSource.setPassword("kitriTESTham");
        return dataSource;
    }

    @org.junit.Test
    public void findAll() {
    	System.out.println("==============");
    	System.out.println("전체 조회 테스트");
    	List<IntegrationInbound> findEntity = dao.findAll();
    	System.out.println(findEntity);
    	assertNotNull(findEntity);
    	System.out.println("전체 조회 완료");
    	System.out.println("==============");
    }
    
    @org.junit.Test
    public void findById() {
    	System.out.println("=========");
    	System.out.println("아이디 조회");
    	IntegrationInbound entity = new IntegrationInbound()
				.setInboundDate(Timestamp.valueOf("2024-12-25 05:34:13"))
				.setGoodsId("TEST")
				.setConfirmStatus("N")
				.setInboundQty(7);
    	IntegrationInbound dbEntity = dao.findById(entity);
    	assertEquals(entity.getGoodsId(), dbEntity.getGoodsId());
    	
    }
    
    @org.junit.Test
    public void findByGoodsId() {
    	List<IntegrationInbound> result = dao.findByGoodsId("TEST");
    	assertEquals(result.size(), 1);
    	
    	
    }
    
    @org.junit.Test
    public void insert() {
    	IntegrationInbound entity = new IntegrationInbound()
				.setGoodsId("inTEST")
				.setConfirmStatus("N")
				.setInboundQty(7);
    	int save = dao.save(entity);
    	
    	assertEquals(1, save);
    }

    @org.junit.Test
    public void update() {
    	IntegrationInbound entity = new IntegrationInbound()
    			.setInboundDate(Timestamp.valueOf("2024-12-25 05:34:13"))
				.setGoodsId("TEST")
				.setConfirmStatus("N")
				.setInboundQty(2);
        int update = dao.update(entity);
        assertEquals(1, update);
     }
    
    @org.junit.Test
    public void findByStatus() {
    	List<IntegrationInbound> ys = dao.findByStatus("Y");
    	System.out.println(ys.size());
    	List<IntegrationInbound> ns = dao.findByStatus("N");
    	System.out.println(ns.size());
    }
}


