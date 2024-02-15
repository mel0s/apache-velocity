package com.baeldung.apache.velocity.servlet;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductServletLiveTest {

    @Test
    @Ignore
    public void whenRequestUsingHttpClient_thenCorrectResponse() throws Exception {

        HttpClient client = new DefaultHttpClient();
        HttpGet method= new HttpGet("http://localhost:8080/");

        HttpResponse httpResponse = client.execute(method);

        assertEquals("Success", httpResponse.getHeaders("Template Returned")[0].getValue());

    }
}
