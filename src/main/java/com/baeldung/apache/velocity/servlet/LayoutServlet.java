package com.baeldung.apache.velocity.servlet;

import com.baeldung.apache.velocity.entity.Employee;
import com.baeldung.apache.velocity.entity.Pet;
import com.baeldung.apache.velocity.service.EmployeeServices;
import com.baeldung.apache.velocity.service.ProductService;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityLayoutServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.inject.Inject;


public class LayoutServlet extends VelocityLayoutServlet {

	@Inject
	ProductService service;
	@Inject
	EmployeeServices employeeServicesImpl ;

	@Override
	public Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) {

        Logger logger= LoggerFactory.getLogger(LayoutServlet.class);

		List<Pet> products = employeeServicesImpl.getAllPet();



		context.put("products", products);

		Template template = null;

		try {
			template = getTemplate("templates/layoutdemo.vm");

			response.setHeader("Template Returned", "Success");
		} catch (Exception e) {
			logger.error("Error while reading the template ",e);
		}

		return template;

	}

}
