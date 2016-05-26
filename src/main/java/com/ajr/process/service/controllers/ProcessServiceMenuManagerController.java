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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ajr.process.service.dto.MenuCellDTO;
import com.ajr.process.service.dto.MenuDataDTO;
import com.ajr.process.service.dto.SubMenu1CellDTO;
import com.ajr.process.service.dto.SubMenu2CellDTO;
import com.ajr.process.service.dto.SubMenuDataDTO;
import com.ajr.process.service.services.ProcessServiceMenuManagerService;

@Controller
@Path("/menuDefinitions")
public class ProcessServiceMenuManagerController {

	@Autowired
	ProcessServiceMenuManagerService manager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MenuCellDTO> getList() {

		return manager.getList();

	}

	@GET
	@Path("{project}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MenuCellDTO> getMenuByProject(
			@PathParam("project") String project) {

		return manager.getMenuByProject(project);

	}

	@GET
	@Path("submenu1/{project}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SubMenu1CellDTO> getSubMenu1ByProject(
			@PathParam("project") String project) {

		return manager.getSubMenu1ByProject(project);

	}

	@GET
	@Path("submenu2/{project}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SubMenu2CellDTO> getSubMenu2ByProject(
			@PathParam("project") String project) {

		return manager.getSubMenu2ByProject(project);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{project}/{menuId}")
	public MenuCellDTO getMenuById(@PathParam("project") String project,
			@PathParam("menuId") int menuId) {

		return manager.getMenuById(project, menuId);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("submenu1/{project}/{menuId}")
	public List<SubMenu1CellDTO> getSubMenu1ById(
			@PathParam("project") String project,
			@PathParam("menuId") int menuId) {

		return manager.getSubMenu1ById(project, menuId);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("submenu2/{project}/{menuId}/{submenu1Id}")
	public List<SubMenu2CellDTO> getSubMenu2ById(
			@PathParam("project") String project,
			@PathParam("menuId") int menuId,
			@PathParam("submenu1Id") int submenu1Id) {

		return manager.getSubMenu2ById(project, menuId, submenu1Id);

	}

	@POST
	@Path("post/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response updateMenu(@PathParam("project") String project,
			MenuDataDTO menu) {

		manager.updateMenuItems(project, menu);

		// String result = "Menu1: " + menu.getMenu1Text() + " Menu2: " +
		// menu.getMenu2Text() + " Menu3: " + menu.getMenu3Text() + " Menu4: " +
		// menu.getMenu4Text();
		return Response.status(201).entity(menu).build();

	}

	@POST
	@Path("submenu1/post/{project}/{menuId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response updateSubMenu1Items(@PathParam("project") String project,
			@PathParam("menuId") int menuId, SubMenuDataDTO items) {

		manager.updateSubMenu1Items(project, menuId, items);

		return Response.status(201).entity(items).build();

	}

	@POST
	@Path("submenu2/post/{project}/{menuId}/{submenu1Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response updateSubMenu2Items(@PathParam("project") String project,
			@PathParam("menuId") int menuId,
			@PathParam("submenu1Id") int submenu1Id, SubMenuDataDTO items) {

		manager.updateSubMenu2Items(project, menuId, submenu1Id, items);

		return Response.status(201).entity(items).build();

	}

}
