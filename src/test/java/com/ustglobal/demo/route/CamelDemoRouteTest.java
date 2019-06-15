package com.ustglobal.demo.route;

import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(CamelSpringBootRunner.class)
@MockEndpoints
@SpringBootApplication
@SpringBootTest(classes = CamelDemoRouteTest.class)
public class CamelDemoRouteTest	{

	@Test
	public void sampleTestMethod() throws Exception {
		System.out.println("***** sampleTestMethod() invoked! *****");
	}

}
