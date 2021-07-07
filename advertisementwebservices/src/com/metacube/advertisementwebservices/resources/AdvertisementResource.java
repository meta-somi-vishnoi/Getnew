package com.metacube.advertisementwebservices.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.metacube.advertisementwebservices.facade.AdvertisementFacade;
import com.metacube.advertisementwebservices.model.Advertisement;

@Path("/AdvertisementResource")
public class AdvertisementResource {
    AdvertisementFacade advertisementFacade = new AdvertisementFacade();

    @GET
    @Path("/Advertisements")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAdvertisements(@HeaderParam("Authorization") String authorizationString) {
        Map<Object, Object> resourceMap = new HashMap<Object, Object>();
        if (!"GET-2018".equals(authorizationString)) {
            resourceMap.put("Status", 400);
            resourceMap.put("payload", "Authorization-error");
        } else {
            List<Advertisement> advertisementList = advertisementFacade.getAll();
            resourceMap.put("status", 200);
            resourceMap.put("payload", advertisementList);
        }
        Gson gson = new Gson();
        return gson.toJson(resourceMap);
    }

    @POST
    @Path("/SetFeeds")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertAdvertisement(@HeaderParam("Authorization") String authorizationString, Advertisement advertisement) {
        Map<Object, Object> resourceMap = new HashMap<Object, Object>();
        if (!"GET-2018".equals(authorizationString)) {
            resourceMap.put("Status", 400);
            resourceMap.put("payload", "Authorization-error");
        } else {
            Status status = advertisementFacade.insertAdvertisement(advertisement);
            if (Status.INVALID.equals(status) || Status.NOT_FOUND.equals(status)) {
                resourceMap.put("status", 400);
            } else {
                resourceMap.put("status", 200);
            }
            resourceMap.put("payload", status);
        }
        Gson gson = new Gson();
        return gson.toJson(resourceMap);
    }

    @GET
    @Path("/Categories/{categoryId}/Advertisements")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdvertisementsOfCategory(@HeaderParam("Authorization") String authorizationString,
            @PathParam("categoryId") String categoryId) {
        Map<Object, Object> resourceMap = new HashMap<Object, Object>();
        if (!"GET-2018".equals(authorizationString)) {
            resourceMap.put("Status", 400);
            resourceMap.put("payload", "Authorization-error");
        } else {
            resourceMap.put("status", 200);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("categoryId", categoryId);
            map.put("advertisementList", advertisementFacade.getAllById(Integer.parseInt(categoryId)));
            resourceMap.put("payload", map);
        }
        Gson gson = new Gson();
        return gson.toJson(resourceMap);
    }

    @PUT
    @Path("/Advertisements/{advertisementId}/{advertisementTitle}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateAdvertisement(@HeaderParam("Authorization") String authorizationString,
            @PathParam("advertisementId") String advertisementId, @PathParam("advertisementTitle") String 
            advertisementTitle) {
        Map<Object, Object> resourceMap = new HashMap<Object, Object>();
        if (!"GET-2018".equals(authorizationString)) {
            resourceMap.put("Status", 400);
            resourceMap.put("payload", "Authorization-error");
        } else {
            Status status = advertisementFacade.updateName(advertisementTitle, Integer.parseInt(advertisementId));
            if (status.INVALID.equals(status) || status.NOT_UPDATED.equals(status)) {
                resourceMap.put("Status", 400);
            } else {
                resourceMap.put("status", 200);
            }
            resourceMap.put("payload", status);
        }
        Gson gson = new Gson();
        return gson.toJson(resourceMap);
    }

    @DELETE
    @Path("/DeleteAdvertisementById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteAdvertisementById(@HeaderParam("Authorization") String authorizationString, @PathParam("id") int id) {
        Map<Object, Object> resourceMap = new HashMap<Object, Object>();

        if (!"GET-2018".equals(authorizationString)) {
            resourceMap.put("Status", 400);
            resourceMap.put("payload", "error");
        } else {
            Status status = advertisementFacade.deleteAdvertisement(id);
            if (Status.NOT_FOUND.equals(status)) {
                resourceMap.put("Status", 400);
            } else {
                resourceMap.put("Status", 200);
            }
            resourceMap.put("payload", status);
        }
        Gson gson = new Gson();
        return gson.toJson(resourceMap);
    }
}
