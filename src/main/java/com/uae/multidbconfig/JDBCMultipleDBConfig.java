package com.uae.multidbconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JDBCMultipleDBConfig {
	@Bean(name = "sqlDbTr")
	@Primary
	@ConfigurationProperties(prefix = "spring.sybase_tr")
	public DataSource syBaseTrDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sqlDbTrJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("sqlDbTr") DataSource dsSyBaseTr) {
		return new JdbcTemplate(dsSyBaseTr);
	}
	
	@Bean(name = "sqlDbPr")
	@ConfigurationProperties(prefix = "spring.sybase_pr")
	public DataSource syBasePrDataSource() {
		return  DataSourceBuilder.create().build();
	}

	@Bean(name = "sqlDbPrJdbcTemplate")
	public JdbcTemplate postgresJdbcTemplate(@Qualifier("sqlDbPr") 
                                              DataSource dsSyBasePr) {
		return new JdbcTemplate(dsSyBasePr);
	}
}