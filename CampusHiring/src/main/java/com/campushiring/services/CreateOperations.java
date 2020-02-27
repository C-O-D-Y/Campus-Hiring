package com.campushiring.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javassist.bytecode.stackmap.BasicBlock.Catch;

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

//	public Questions readJsonFile(String filePath) {
//
//		try {
//
//			// create ObjectMapper instance
//			ObjectMapper objectMapper = new ObjectMapper();
//			in = new FileInputStream(new File(filePath));
//			TypeReference<Questions> tp = new TypeReference<Questions>() {
//			};
//			questions = objectMapper.readValue(in, tp);
//			System.out.println(", statement=" + questions.getStatement() + ", type=" + questions.getType()
//					+ ", difficulty=" + questions.getDifficulty() + "]");
//
//		} catch (Exception e) {
//			System.out.println("Catch");
//			e.printStackTrace();
//		}
//		return questions;
//	}

	@PostMapping(path = "/sc/setQuestion")
	@ResponseBody
	@Consumes({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
	@JsonIgnoreProperties(ignoreUnknown = true)
	public Questions setQuestionsAndOptions(@RequestBody Questions questions) {
		qoi.addQuestions(questions);
		return questions;
	}

	@GetMapping(path = "/sc/getQuestion/{id}")
	@ResponseBody()
	public Questions getQuestions(@PathVariable Integer id) throws ExceptionHandling {
		try {
			Questions qe = qoi.getQuestions(id);
			if (qe.getQuestion_id() == 0)
				throw new ExceptionHandling("Question for the given QuestionId cannot be found");
			qe.setOptions(null);
			return qe;
		} catch (Exception e) {
			throw new ExceptionHandling("Question for the given QuestionId cannot be found");
		}
	}

	@GetMapping(path = "/sc/getOptions/{id}")
	@ResponseBody()
	public List<Options> getOptions(@PathVariable(name = "id") Integer id) throws ExceptionHandling {
		try {
			List<Options> option = qoi.getOptions(id);
			if (option.get(0).getOption_id() == 0) {
				throw new ExceptionHandling("Options for the given QuestionId cannot be found");
			}
			for (Options op : option) {
				op.setIs_correct("");
				op.setQuestions(null);
			}
			return option;
		} catch (Exception e) {
			throw new ExceptionHandling("Options for the given QuestionId cannot be found");
		}
	}

	@GetMapping(path = "/sc/getResponse/{uid}/{qid}")
	@ResponseBody()
	public Response getResponse(@PathVariable(required = true, name = "qid") Integer qid,
			@PathVariable(required = true, name = "uid") Long uid) throws ExceptionHandling {
		try {
			System.out.println("READ");
//		Response response = ril.addResponse();
			Response resp = resrep.findByQuestionIdAndUserId(qid, uid);

			if (resp == null) {
				throw new ExceptionHandling("Response of the usercannot be found");
			}
			return resp;
		} catch (Exception ex) {
			throw new ExceptionHandling("Response of the usercannot be found");
		}

	}

	@PutMapping(path = "/sc/setResponse", consumes = { "application/json" })
	@ResponseBody()
	public Response setOrUpdateResponse(@RequestBody Response updatedResponse) {

		resrep.save(updatedResponse);
		return updatedResponse;

	}

	@GetMapping(path = "/sc/getAllQuestion")
	@ResponseBody()
	public List<Questions> getAllQuestions() {
		Iterable<Questions> qe = questionsRepo.findAll();
		Iterator<Questions> itr = qe.iterator();
		List<Questions> allQuestions = new ArrayList<Questions>();
		while (itr.hasNext()) {
			Questions getQues = itr.next();
			getQues.setOptions(null);

			allQuestions.add(getQues);
		}
		return allQuestions;
	}
}