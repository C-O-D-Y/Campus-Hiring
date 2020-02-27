package com.campushiring.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ResponseImpl {

	@Autowired
	ResponseRepo responseRepo;

	InputStream in;
	Response response;

	public Response readJsonFileForResponse(String filePath) {

		try {

			// create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			in = new FileInputStream(new File(filePath));
			TypeReference<Response> tp = new TypeReference<Response>() {
			};
			response = objectMapper.readValue(in, tp);

		} catch (Exception e) {
			System.out.println("Catch");
			e.printStackTrace();
		}
		return response;
	}

	@Transactional
	public Response addResponse() {

		Response responses = readJsonFileForResponse(
				"C:\\Users\\saurabh.chauhan\\Spring Workspace\\CampusHiring\\src\\main\\java\\com\\campushiring\\json\\Response.json");
		Response response = new Response(responses.getResponseId(), responses.getUserId(), responses.getQuestionId(),
				responses.getSelectedOptionId());
		// Creating Options
	
		
		return response;
	}

}
