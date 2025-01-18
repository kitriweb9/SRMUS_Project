package org.kitri.system.dualdata.core.Impl;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Component
public class SqlSessionTemplateProvider {

	// SqlSessionTemplate 생성 메서드
	// default로 생성하여 외부에서 호출할 수 없도록 설정
	SqlSessionTemplate createSqlSessionTemplate() {
		try {
			Properties properties = loadProperties();

			// DataSource 설정
			DataSource dataSource = new BasicDataSource();
			((BasicDataSource) dataSource).setDriverClassName(properties.getProperty("oracle.jdbc.OracleDriver"));
			((BasicDataSource) dataSource).setUrl(properties.getProperty("DB_URL"));
			((BasicDataSource) dataSource).setUsername(properties.getProperty("DB_USER_NAME"));
			((BasicDataSource) dataSource).setPassword(properties.getProperty("DB_USER_PASSWORD"));
			System.out.println("datasource 생성완료");
			// SqlSessionFactory 설정
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			factoryBean.setDataSource(dataSource);
			factoryBean.setMapperLocations(
					new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/**/*.xml"));
			System.out.println("팩토리빈생성완료");
			// SqlSessionTemplate 반환
			return new SqlSessionTemplate(factoryBean.getObject());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to create SqlSessionTemplate", e);
		}
	}

	// store.setting 파일에서 Properties를 로드
	private Properties loadProperties() {
		try {
			Properties properties = new Properties();
			properties.load(new ClassPathResource("enc.setting").getInputStream());
			return properties;
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties from .setting", e);
		}
	}
}
