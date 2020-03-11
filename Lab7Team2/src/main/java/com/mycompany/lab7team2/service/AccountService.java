
package com.mycompany.lab7team2.service;

import com.mycompany.lab7team2.Model.User;
import com.mycompany.lab7team2.Model.UserList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("accounts")
public class AccountService {
    
    UserList userList = new UserList();
    
    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewUserAccount(User user) {
        userList.addUser(user);
        User createdUser = userList.getUserById(user.getUserName());
        
        if (createdUser != null) {
            return Response.status(Response.Status.CREATED).entity(createdUser).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @PUT
    @Path("update")
    public Response updateUserName(@QueryParam("existingId") String existingId, @QueryParam("newId") String newId ) {
        User updatedUser = userList.updateUserID(existingId, newId);
        if (updatedUser != null) {
             return Response.status(Response.Status.OK).entity(updatedUser).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();    
    }
    
    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@QueryParam("userID") String userId) {
        if (userList.getUserById(userId) != null) {
            return Response.status(Response.Status.OK).entity(userList.getUserById(userId)).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build(); 
    }
    
    @DELETE
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@QueryParam("userID") String userId) {
        User removedUser = userList.deleteUserById(userId);
        
        if (removedUser == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.OK).entity("removed").build();
       
    }
    
}
