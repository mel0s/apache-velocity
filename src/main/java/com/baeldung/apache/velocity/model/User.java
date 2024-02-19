package com.baeldung.apache.velocity.model;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="user")
@RequestScoped
@Getter
@Setter
public class User {
    private String name;
}
