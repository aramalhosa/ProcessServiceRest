package com.ajr.process.service.controllers;

import java.io.IOException;
import java.util.List;

import com.ajr.process.service.entity.ComponentRelation;
import com.ajr.process.service.services.ProcessServiceChainManagerService;
import com.ajr.process.service.services.impl.ProcessServiceChainManagerServiceImpl;

public class DirectInvoke1 {

	public String getResourceFirst() throws IOException {

		System.out
				.println("All versions of AssertionBuilderRegistryImpl:"
						+ getClass()
								.getClassLoader()
								.getResources(
										"org/apache/neethi/AssertionBuilderFactory.class"));

		return "";

	}
	
	public String getResourceFirst1() throws IOException {

		System.out
				.println("Currently used version of AssertionBuilderRegistryImpl:"
						+ getClass()
								.getClassLoader()
								.getResource(
										"org/apache/neethi/AssertionBuilderFactory.class"));

		return "";

	}
	
}
