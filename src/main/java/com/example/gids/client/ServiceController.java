package com.example.gids.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/client/service")
public class ServiceController {

    static int count = 0;
    @GET
    @Path("/{parameter}")
    public String doSomething(@PathParam("parameter") String parameter) throws InterruptedException {
        
        count++;
        if (count %3 ==0) {
            Thread.sleep(3000);
        } else if (count % 5 == 0 ) {
            throw new RuntimeException();
        }
	return String.format("JPrime Service B Count: " + count + " $$$$ Processed parameter value '%s'", parameter);

    }
}
