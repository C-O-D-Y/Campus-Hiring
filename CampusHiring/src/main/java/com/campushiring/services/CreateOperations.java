package com.campushiring.services;

import java.util.List;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public Questions getQuestions(@PathVariable Integer id) {
		Questions qe = qoi.getQuestions(id);
//		Iterator<Options> itr = qe.getOptions().iterator();
//		while (itr.hasNext()) {
//			Options addOp = itr.next();
//			addOp.setIs_correct("");
//			addOp.setQuestions(null);
		qe.setOptions(null);
		return qe;
	}

	@GetMapping(path = "/sc/getOptions/{id}")
	@ResponseBody()
	public List<Options> getOptions(@PathVariable(name = "id") Integer id) {
		List<Options> option = qoi.getOptions(id);
		for (Options op : option) {
			op.setIs_correct("");
			op.setQuestions(null);
		}
		return option;
	}

	@GetMapping(path = "/sc/getResponse/{uid}/{qid}")
	@ResponseBody()
	public Response getResponse(@PathVariable(required = true, name = "qid") Integer qid,
			@PathVariable(required = true, name = "uid") Long uid) {
		System.out.println("READ");
//		Response response = ril.addResponse();
		Response resp = resrep.findByQuestionIdAndUserId(qid, uid);
		return resp;
	}

	@PutMapping(path = "/sc/setResponse", consumes = { "application/json" })
	@ResponseBody()
	public Response setOrUpdateResponse(@RequestBody Response updatedResponse) {

		resrep.save(updatedResponse);
		return updatedResponse;

	}
}