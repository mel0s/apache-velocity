package com.baeldung.apache.velocity.controller;


import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("users")
public class UserController {
    @GET
    @View("/user.jsp")
    @Controller
    public void  user(){
    }
}
