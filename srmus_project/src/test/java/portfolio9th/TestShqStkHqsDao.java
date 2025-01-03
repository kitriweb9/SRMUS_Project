package portfolio9th;

import org.junit.Before;
import org.junit.Test;
import org.kitri.services.sales.stock.dao.impl.ShqStkHqsDaoImpl;
import org.kitri.services.sales.stock.entity.GoodsStock;

public class TestShqStkHqsDao {
	private static ShqStkHqsDaoImpl dao;
	
	@Before
	public void setUp() throws Exception {
        // 1. 데이터소스 생성
        dao = new ShqStkHqsDaoImpl(new TestSqlSession().getSession());
    }
	
	
	@Test
	public void addStock() {
		GoodsStock testEntity = 
				new GoodsStock()
					.setGoodsId("GDS001")
					.setQty(3);
		
		dao.addStock(testEntity);
	}


  
    
}
