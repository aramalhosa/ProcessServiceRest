package com.ajr.process.service.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.ajr.process.service.dto.ChainComponentDTO;
import com.ajr.process.service.dto.ChainDTO;
import com.ajr.process.service.dto.ChainProjDTO;
import com.ajr.process.service.services.ProcessServiceChainManagerService;

@Controller
@Path("/chainProjects")
public class ProjectServiceChainManagerController {

	@Autowired
	ProcessServiceChainManagerService manager;

	@GET
	@Path("/list/{project}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getProjectsList(@PathParam("project") String project) {

		return manager.getChainProjectsList(project);

	}
	
	@GET
	@Path("/selected/{project}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProjectSelected(@PathParam("project") String project) {

		return manager.getChainProjectSelected(project);

	}

	@GET
	@Path("{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ChainDTO getProjects(@PathParam("projectId") Integer projectId) {

		return manager.getChainProjectById(projectId);

	}

	@POST
	@Path("post/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response createProject(@PathParam("project") String project,
			ChainProjDTO chainProject) {

		manager.insertProject(project, chainProject);

		String result = "Project created : " + chainProject;

		return Response.status(201).entity(result).build();

	}
	
	@POST
	@Path("post/selectedOptions/{projectId}/{chainProj}/{component}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response updateProjectComponents(
			@PathParam("projectId") int projectId, @PathParam("chainProj") String chainPrj,
			@PathParam("component") String comp) {

		manager.updateSelectedProjectComponent(projectId, chainPrj, comp);

		String result = "Selected Project/Component updated!";

		return Response.status(201).entity(result).build();

	}	

	@POST
	@Path("post/components/{projectId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response createProjectComponents(
			@PathParam("projectId") int projectId,
			List<ChainComponentDTO> components) {

		manager.insertProjectComponents(projectId, components);

		String result = "Project Components created!";

		return Response.status(201).entity(result).build();

	}

	@POST
	@Path("post/update/components/{projectId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response updateProjectComponents(
			@PathParam("projectId") int projectId,
			List<ChainComponentDTO> components) {

		manager.updateProjectComponents(projectId, components);

		String result = "Project Components updated!";

		return Response.status(201).entity(result).build();

	}

}
