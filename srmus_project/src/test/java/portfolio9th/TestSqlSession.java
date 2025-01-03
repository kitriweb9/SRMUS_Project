package portfolio9th;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class TestSqlSession {
	private SqlSessionTemplate sql;
	public TestSqlSession() throws Exception {
		DataSource dataSource = createDataSource();
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/**/*.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("org.kitri.services.store.dto,org.kitri.services.sales.dto");

		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

		// 3. SqlSessionTemplate 생성
		sql = new SqlSessionTemplate(sqlSessionFactory);

	}
	public SqlSessionTemplate getSession() {
		return sql;
	}
	
    private DataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@blanks.life:16151:xe");
        dataSource.setUsername("kitri_test");
        dataSource.setPassword("kitriTESTham");
        return dataSource;
    }
}
