
package com.mycompany.lab7team2.service;

import com.mycompany.lab7team2.Model.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("accounts")
public class AccountService {
    
    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewUserAccount(User user) {
        return Response.status(Response.Status.CREATED).build();
    }
    
}
