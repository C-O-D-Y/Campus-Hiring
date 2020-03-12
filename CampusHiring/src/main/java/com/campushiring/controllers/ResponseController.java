package com.campushiring.controllers;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campushiring.customExceptionHandling.ExceptionHandling;
import com.campushiring.entity.Response;
import com.campushiring.repositories.ResponseRepo;

@Controller
public class ResponseController {

	public ResponseController() {
		LOG = LoggerFactory.getLogger(ResponseController.class);
	}

	@Autowired
	ResponseRepo resrep;

	Logger LOG;

	@GetMapping(path = "/sc/getResponse/{uid}/{qid}")
	@ResponseBody()
	public Response getResponse(@PathVariable(required = true, name = "qid") Integer qid,
			@PathVariable(required = true, name = "uid") Long uid) throws ExceptionHandling {
		try {

			Response resp = resrep.findByQuestionIdAndUserId(qid, uid);

			if (resp == null) {
				System.out.println("resp null hai");
				ExceptionHandling.setHttpCode(HttpStatus.NOT_FOUND);
				throw new ExceptionHandling("no content");
			}
			LOG.info("Response has been fetched");
			return resp;
		} catch (Exception ex) {
			ExceptionHandling.setHttpCode(HttpStatus.NOT_FOUND);
			LOG.error("Exception Came With Code " + HttpStatus.NOT_FOUND);
			throw new ExceptionHandling("no content");
		}

	}

	@PutMapping(path = "/sc/setResponse", consumes = { "application/json" })
	@ResponseBody()
	public Response setOrUpdateResponse(@RequestBody Response updatedResponse) throws SQLException {
		resrep.save(updatedResponse);
		LOG.info("Response had Created or updated");
		return updatedResponse;

	}
}
