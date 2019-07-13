package com.ustglobal.demo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@ConfigurationProperties(prefix = "camel-demo-route")
@Data
@EqualsAndHashCode(callSuper = true)

public class CamelDemoRoute extends RouteBuilder {

	// The value of this property is injected from application.properties based on
	// the profile chosen.
	// private String injectedName;

	private String query;
	private String queryResultTopic;
	private String queryInputTopic;
	private String brokers;
	private String timerFrequency;
	
	/*
	 * @Autowired private JdbcTemplate jdbcTemplate;
	 */
	@Override
	public void configure() throws Exception {

		// @formatter:off
		
		// errorHandler(deadLetterChannel("seda:errorQueue").maximumRedeliveries(5).redeliveryDelay(1000));

				
		from("timer://dbQueryTimer?period=10s")
		.routeId("DATABASE_QUERY_TIMER_ROUTE")
		.to("sql:SELECT version()?dataSource=#dataSource")	
		//.to("sql:SELECT version()?dataSource=#mydatasource")
		.log(LoggingLevel.INFO,"******Database query executed******");
		
		
		// @formatter:on

	}

}
