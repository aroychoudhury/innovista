/* Copyright 2016 Roychoudhury, Abhishek */

package org.verizon.common.rest;

import java.io.IOException;
import java.util.List;

import org.verizon.common.rest.request.DefaultJsonConstructor;
import org.verizon.common.rest.response.DefaultJsonExtractor;
import org.verizon.common.util.Document;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * TODO
 * 
 * @author abhishek
 * @since 1.0
 */
public class MainTester {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    	String json = (String) new HttpRestBuilder.Builder("http://scsbwin-167767:8080/documentservices/testsearch/test")
                .get()
                .header("Content-Type", "application/json")
                .requestConstructor(new DefaultJsonConstructor(new Document()))
                .responseExtractor(new DefaultJsonExtractor()).build();
    	System.out.println("json : " + json);
        /*System.out.println(
        		new ObjectMapper().readValue(json, Document.class));*/
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(
                List.class, Document.class)));
    }
}
