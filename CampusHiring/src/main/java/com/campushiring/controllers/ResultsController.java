package com.campushiring.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campushiring.customExceptionHandling.ExceptionHandling;
import com.campushiring.entity.Options;
import com.campushiring.pojo.Result;
import com.campushiring.services.Services;

@Controller
public class ResultsController {

	@Autowired
	Services qoi;

	Logger LOG;

	public ResultsController() {
		LOG = LoggerFactory.getLogger(ResultsController.class);
	}

	@GetMapping(path = "/sc/getResult")
	@ResponseBody()
	public Result getResult(@RequestParam(required = true, name = "userId") Long userId) throws ExceptionHandling {

		ArrayList<HashMap<Integer, String>> result = new ArrayList<HashMap<Integer, String>>();
		// HashMap<Integer, String> sdfdc = new HashMap<Integer, String>();
		try {
			List<Options> gf = qoi.getResult(userId);
			System.out.println("SIZE OF THE USERID IS " + gf.size());
			System.out.println(userId);
			HashMap<Integer, String> ui = null;
			for (Options sd : gf) {
				ui = new HashMap<Integer, String>();
				ui.put(sd.getQuestions().getQuestion_id(), sd.getIs_correct());
				result.add(ui);
			}
			LOG.info("Result is fetched");

		} catch (Exception ex) {
			ExceptionHandling.setHttpCode(HttpStatus.NOT_FOUND);
			LOG.error("Exception Came With Code " + HttpStatus.NOT_FOUND);
			throw new ExceptionHandling("no content");
		}
		return new Result(userId, result);
	}

	@GetMapping(path = "/sc/getAllResult")
	@ResponseBody()
	public HashMap<String, ArrayList<Result>> getAllResult(
			@RequestParam(required = true, name = "testId") String testId) throws ExceptionHandling {
		HashMap<String, ArrayList<Result>> gfgf = new HashMap<String, ArrayList<Result>>();
		try {
			ArrayList<Result> resy = new ArrayList<Result>();
			HashSet<Long> ts = qoi.getAllResult(testId);

			for (Long re : ts) {
				Result rt = getResult(re);
				resy.add(rt);
			}
			gfgf.put(testId, resy);
		} catch (Exception e) {
			ExceptionHandling.setHttpCode(HttpStatus.NOT_FOUND);
			LOG.error("Exception Came With Code " + HttpStatus.NOT_FOUND);
			throw new ExceptionHandling("no content");
		}
		return gfgf;
	}
}
