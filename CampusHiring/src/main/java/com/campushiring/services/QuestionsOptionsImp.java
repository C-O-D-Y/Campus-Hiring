package com.campushiring.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campushiring.entity.Options;
import com.campushiring.entity.Questions;
import com.campushiring.pojo.Results;
import com.campushiring.repositories.OptionsRepo;
import com.campushiring.repositories.QuestionsRepo;

@Service
public class QuestionsOptionsImp {

	@Autowired
	QuestionsRepo questionsRepo;

	@Autowired
	OptionsRepo optionsRepo;

	@Transactional
	public void addQuestions(Questions questions) {

//		Questions questions = new CreateOperations().readJsonFile(
//				"C:\\Users\\saurabh.chauhan\\Spring Workspace\\CampusHiring\\src\\main\\java\\com\\campushiring\\json\\Question.json");
		Questions question = new Questions(questions.getStatement(), questions.getType(), questions.getDifficulty());
		// Creating Options
		Set<Options> options = new HashSet<Options>();
		Iterator<Options> itr = questions.getOptions().iterator();
		while (itr.hasNext()) {
			Options addOp = itr.next();
			options.add(new Options(addOp, question));

		}
		question.setOptions(options);

		// Save Questions and Options via Questions Entity
		Set<Questions> setQuestions = new HashSet<Questions>();
		setQuestions.add(question);

		questionsRepo.save(question);
	}

	@Transactional
	public Questions getQuestions(int questionId) throws SQLException {
		Questions question = questionsRepo.findById(questionId).orElse(new Questions());
		return question;
	}

	@Transactional
	public List<Options> getOptions(int fkQuestionId) {
		List<Options> options = optionsRepo.findByForeignKey(fkQuestionId);
		if (options == null) {
			return new ArrayList<Options>();
		}

		return options;
	}

	@Transactional
	public List<Options> getResult(long user_Id) {
		List<Options> options = optionsRepo.findByUserId(user_Id);
		return options;
	}

	@Transactional
	public List<Results> getAllResult(String test_Id) {
		List<Results> options = optionsRepo.findByTestId(test_Id);
		return options;
	}
}
