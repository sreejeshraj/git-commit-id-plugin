package com.ustglobal.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@ConfigurationProperties(prefix="camel-demo-route")
@Data
@EqualsAndHashCode(callSuper=true)

public class CamelDemoRoute extends RouteBuilder {

	private String routeId;

	@Override
	public void configure() throws Exception {

		// @formatter:off

		from("file://{{inputFolder}}?delay=10s&noop=true")
		.routeId("InputFolderToTestSedaRoute")
		.setHeader("myHeader", constant("MY_HEADER_CONSTANT_VALUE"))
		.to("seda://testSeda")
		.log("**** Input File Pushed To Output Folder *****");

		from("seda://testSeda")
		.routeId("TestSedaToOutputFolderRoute")
		.to("file://{{outputFolder}}")
		.log("***** myHeader: ${header.myHeader}");
		
		// @formatter:on

	}

}
