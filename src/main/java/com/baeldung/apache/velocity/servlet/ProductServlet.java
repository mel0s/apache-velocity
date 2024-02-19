package com.baeldung.apache.velocity.servlet;

import com.baeldung.apache.velocity.model.Product;
import com.baeldung.apache.velocity.service.ProductService;
import lombok.SneakyThrows;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class ProductServlet extends VelocityViewServlet {

	String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	String appConfigPath = rootPath + "application.properties";

	Properties appProps = new Properties();


	ProductService service = new ProductService();

	@SneakyThrows
	@Override
	public Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) {

		appProps.load(new FileInputStream(appConfigPath));

		String appVersion = appProps.getProperty("version");
		String build = appProps.getProperty("build.date");

		Logger logger= LoggerFactory.getLogger(ProductServlet.class);

		List<Product> products = service.getProducts();

		context.put("products", products);

		context.put("version", appVersion);

		context.put("build", build);

		Template template = null;

		try {
			template = getTemplate("templates/index.vm");
			response.setHeader("Template Returned", "Success");
		} catch (Exception e) {
			logger.error("Error while reading the template ", e);
		}

		return template;

	}
}
