package org.kitri.system.dualdata;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class SqlSessionTemplateFactory {

	// store.setting 파일에서 받은 Properties를 사용해 SqlSessionTemplate 생성
	public static SqlSessionTemplate createSqlSessionTemplate(Properties properties) {
		try {
			DataSource dataSource = new BasicDataSource();
			((BasicDataSource) dataSource).setDriverClassName(properties.getProperty("db.driverClassName"));
			((BasicDataSource) dataSource).setUrl(properties.getProperty("db.url"));
			((BasicDataSource) dataSource).setUsername(properties.getProperty("db.username"));
			((BasicDataSource) dataSource).setPassword(properties.getProperty("db.password"));

			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			factoryBean.setDataSource(dataSource);
			factoryBean.setMapperLocations(
					new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/**/*.xml"));
			factoryBean.setTypeAliasesPackage("org.kitri.system.dualdata");

			return new SqlSessionTemplate(factoryBean.getObject());
		} catch (Exception e) {
			throw new RuntimeException("Failed to create SqlSessionTemplate", e);
		}
	}
}
