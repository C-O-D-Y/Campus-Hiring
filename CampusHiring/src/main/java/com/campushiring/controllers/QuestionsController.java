package com.campushiring.controllers;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.Consumes;

import org.modelmapper.ModelMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campushiring.customExceptionHandling.ExceptionHandling;
import com.campushiring.entity.Questions;
import com.campushiring.pojo.QuestionsDTO;
import com.campushiring.pojo.QuestionsOptionsDTO;
import com.campushiring.repositories.QuestionsRepo;
import com.campushiring.services.Services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Controller
public class QuestionsController {

	Logger LOG;

	@Autowired
	Services qoi;

	@Autowired
	QuestionsRepo questionsRepo;

	ModelMapper modelMapper = new ModelMapper();

	public QuestionsController() {
		LOG = LoggerFactory.getLogger(QuestionsController.class);
		// TODO Auto-generated constructor stub
	}

	@PostMapping(path = "/sc/setQuestion")
	@ResponseBody
	@Consumes({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
	@JsonIgnoreProperties(ignoreUnknown = true)
	public Questions setQuestionsAndOptions(@RequestBody Questions questions) throws ExceptionHandling {
		try {
			qoi.addQuestions(questions);
			LOG.info("Question has been Created");
		} catch (Exception e) {
			LOG.error("Exception Came With Code" + HttpStatus.INTERNAL_SERVER_ERROR);
			ExceptionHandling.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
			throw new ExceptionHandling("no content");
		}
		return questions;
	}

	@GetMapping(path = "/sc/getQuestion/{id}")
	@ResponseBody()
	public QuestionsOptionsDTO getQuestions(@PathVariable Integer id) throws ExceptionHandling {
		try {
			QuestionsOptionsDTO ty = null;

			Questions qe = qoi.getQuestions(id);

			if (qe.getQuestion_id() == 0) {
				ExceptionHandling.setHttpCode(HttpStatus.NOT_FOUND);
				throw new ExceptionHandling("no content");
			}

			ty = new QuestionsOptionsDTO();
			modelMapper.map(qe, ty);

			LOG.info("Question had fetched");
			return ty;
		}
		// catch(SQLException ve) {System.out.println("sbfuy");}
		catch (SQLException sqle) {
			LOG.error("Exception Came With Code" + HttpStatus.INTERNAL_SERVER_ERROR);
			throw new ExceptionHandling("no content");
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception Came With Code" + HttpStatus.BAD_REQUEST);
			throw new ExceptionHandling("no content");

		}

	}

	@GetMapping(path = "/sc/getAllQuestion")
	@ResponseBody()
	public ArrayList<QuestionsDTO> getAllQuestions() throws ExceptionHandling {
		ArrayList<QuestionsDTO> dto = new ArrayList<QuestionsDTO>();
		try {
			QuestionsDTO ty = null;

			Iterable<Questions> qe = questionsRepo.findAll();
			Iterator<Questions> itr = qe.iterator();
			while (itr.hasNext()) {
				Questions getQues = itr.next();

				ty = new QuestionsDTO();
				modelMapper.map(getQues, ty);
				dto.add(ty);
			}
		} catch (Exception e) {
			LOG.error("Exception Came With Code" + HttpStatus.INTERNAL_SERVER_ERROR);
			ExceptionHandling.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
			throw new ExceptionHandling("no content");
		}

		LOG.info("All Questions are fetched");
		return dto;
	}
}
