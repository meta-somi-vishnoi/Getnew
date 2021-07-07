package com.metacube.advertisementwebservices.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.metacube.advertisementwebservices.enums.Status;
import com.metacube.advertisementwebservices.facade.CategoryFacade;
import com.metacube.advertisementwebservices.model.Category;

@Path("/CategoryResource")
public class CategoryResource {
	CategoryFacade categoryFacade = CategoryFacade.getInstance();
	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoris(@HeaderParam("Authorization") String authorizationString){
		Map<Object, Object> resourceMap = new HashMap<Object, Object>();
		if (!"GET-2018".equals(authorizationString)) {
			resourceMap.put("Status", 400);
			resourceMap.put("payload", "Authorization-error");
		}else{
			List<Category> list = categoryFacade.getAll();
			resourceMap.put("status", 200);
			resourceMap.put("payload", list);
		}
		Gson gson = new Gson();
		return gson.toJson(resourceMap);
	}
	
	@POST
	@Path("/SetFeeds")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertIntoCategories(@HeaderParam("Authorization") String authorizationString,Category category){
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		if (!"GET-2018".equals(authorizationString)) {
			responseMap.put("Status", 400);
			responseMap.put("payload", "Authorization-error");
		}else{
			Status status = categoryFacade.insertCategory(category.getCategoryName());
			if(Status.NO_DATA_TO_INSERT.equals(status)){
				responseMap.put("Status",400);
			}else{
				responseMap.put("Status",200);
			}		
			responseMap.put("Payload", status);
		}
		Gson gson = new Gson();
		return gson.toJson(responseMap);
	}
	
	@PUT
	@Path("/UpdateFeeds/{categoryId}/{categoryName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCategory(@HeaderParam("Authorization") String authorizationString,@PathParam("categoryId") String categoryId,
	        @PathParam("categoryName") String categoryName){
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		if (!"GET-2018".equals(authorizationString)) {
			responseMap.put("Status", 400);
			responseMap.put("payload", "Authorization-error");
		}else{
			Status status = categoryFacade.updateCategory(categoryName, Integer.parseInt(categoryId));
			if(status.equals(Status.INVALID) || status.equals(Status.NOT_FOUND)){
				responseMap.put("Status",400);
			}else{
				responseMap.put("Status",200);
			}
			
			responseMap.put("Payload", status);
		}
		Gson gson = new Gson();
		return gson.toJson(responseMap);
	}
	
	
}
