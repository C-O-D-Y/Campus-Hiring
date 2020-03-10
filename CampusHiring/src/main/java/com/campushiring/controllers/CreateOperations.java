package com.campushiring.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campushiring.customExceptionHandling.ExceptionHandling;
import com.campushiring.entity.Options;
import com.campushiring.entity.Questions;
import com.campushiring.entity.Response;
import com.campushiring.entity.User;
import com.campushiring.pojo.OptionsDTO;
import com.campushiring.pojo.QuestionsDTO;
import com.campushiring.pojo.QuestionsOptionsDTO;
import com.campushiring.pojo.Result;
import com.campushiring.pojo.Results;
import com.campushiring.repositories.QuestionsRepo;
import com.campushiring.repositories.ResponseRepo;
import com.campushiring.repositories.UserRepo;
import com.campushiring.services.QuestionsOptionsImp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Controller
public class CreateOperations {

//	InputStream in;
//	Questions questions;

	@Autowired
	QuestionsOptionsImp qoi;

//	@Autowired
//	ResponseImpl ril;
	@Autowired
	ResponseRepo resrep;

	@Autowired
	QuestionsRepo questionsRepo;

	@Autowired
	UserRepo userRepo;

	Logger LOG;
	ModelMapper modelMapper = new ModelMapper();

	public CreateOperations() {

		LOG = LoggerFactory.getLogger(CreateOperations.class);
	}

	@PostMapping(path = "/sc/setQuestion")
	@ResponseBody
	@Consumes({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
	@JsonIgnoreProperties(ignoreUnknown = true)
	public Questions setQuestionsAndOptions(@RequestBody Questions questions) {

		qoi.addQuestions(questions);
		LOG.info("Question has been Created");
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

	@GetMapping(path = "/sc/getOptions/{id}")
	@ResponseBody()
	public ArrayList<OptionsDTO> getOptions(@PathVariable(name = "id") Integer id) throws ExceptionHandling {
		try {
			OptionsDTO ty = null;
			ArrayList<OptionsDTO> dto = new ArrayList<OptionsDTO>();

			ArrayList<Options> option = (ArrayList<Options>) qoi.getOptions(id);

			if (option.get(0).getOption_id() == 0) {
				ExceptionHandling.setHttpCode(HttpStatus.NOT_FOUND);
				throw new ExceptionHandling("no content");
			}
			for (Options op : option) {
				ty = new OptionsDTO();
				modelMapper.map(op, ty);
				dto.add(ty);
			}

			LOG.info("Options has been Created");

			return dto;
		}

		catch (NullPointerException npe) {
			throw new ExceptionHandling("NPE");
		}

		catch (Exception e) {
			e.printStackTrace();
			ExceptionHandling.setHttpCode(HttpStatus.NOT_ACCEPTABLE);
			LOG.error("Exception Came With Code " + HttpStatus.NOT_ACCEPTABLE);
			throw new ExceptionHandling("no content");
		}

	}

	@GetMapping(path = "/sc/getResponse/{uid}/{qid}")
	@ResponseBody()
	public Response getResponse(@PathVariable(required = true, name = "qid") Integer qid,
			@PathVariable(required = true, name = "uid") Long uid) throws ExceptionHandling {
		try {
			System.out.println(qid + "   " + uid);
			System.out.println("READ");
//		Response response = ril.addResponse();
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

	@PutMapping(path = "/sc/setUser", consumes = { "application/json" })
	@ResponseBody()
	public User setOrUpdateUser(@RequestBody User userInfo) {
		userRepo.save(userInfo);
		LOG.info("User had Created or updated");
		return userInfo;
	}

	@GetMapping(path = "/sc/getAllUsers")
	@ResponseBody()
	public ArrayList<User> getAllUsers() {

		ArrayList<User> allUsers = new ArrayList<User>();

		Iterable<User> users = userRepo.findAll();
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			allUsers.add(itr.next());
		}
		return allUsers;
	}

	@GetMapping(path = "/sc/getAllQuestion")
	@ResponseBody()
	public ArrayList<QuestionsDTO> getAllQuestions() {
		QuestionsDTO ty = null;
		ArrayList<QuestionsDTO> dto = new ArrayList<QuestionsDTO>();

		Iterable<Questions> qe = questionsRepo.findAll();
		Iterator<Questions> itr = qe.iterator();
		while (itr.hasNext()) {
			Questions getQues = itr.next();

			ty = new QuestionsDTO();
			modelMapper.map(getQues, ty);
			dto.add(ty);
		}

		LOG.info("All Questions are fetched");
		return dto;
	}

	@GetMapping(path = "/sc/getResult")
	@ResponseBody()
	public ArrayList<Result> getResult(@RequestParam(required = true, name = "userId") Long userId) {

		ArrayList<Result> result = new ArrayList<Result>();
		// HashMap<Integer, String> sdfdc = new HashMap<Integer, String>();
		List<Options> gf = qoi.getResult(userId);
		System.out.println("SIZE OF THE USERID IS " + gf.size());
		System.out.println(userId);

		for (Options sd : gf) {
			Result ty = new Result();
			ty.setQuestion_id(sd.getQuestions().getQuestion_id());
			ty.setIs_correct(sd.getIs_correct());

			result.add(ty);
		}

		LOG.info("Result is fetched");
		return result;
	}

	@GetMapping(path = "/sc/getAllResult")
	@ResponseBody()
	public List<Results> getAllResult(@RequestParam(required = true, name = "testId") String testId) {
		Results ty = null;
		HashSet<Result> rt = new HashSet<Result>();
		List<Results> ts = qoi.getAllResult(testId);
		
		return ts;
	}
}