package com.baeldung.apache.velocity.controller;

import com.baeldung.apache.velocity.model.Product;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("user")
public class EmployeeController {

    @Inject
    private Product product;

    @POST
    public String post() {
        product.setName("John Doe");
        return "redirect:/submit";
    }

    @GET
    public String get(){
        return "user.jsp";
    }

}
