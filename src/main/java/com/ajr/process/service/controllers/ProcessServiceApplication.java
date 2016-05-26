package com.ajr.process.service.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class ProcessServiceApplication extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ProcessServiceMenuManagerController.class);
		return classes;
	}


}
