package com.campushiring.pojo;

import java.util.HashSet;
import java.util.Set;

public class QuestionsOptionsDTO {

	private int question_id;

	private String statement;

	private String type;

	private String difficulty;

	private Set<OptionsDTO> options = new HashSet<OptionsDTO>();

	public int getQuestion_id() {
		return question_id;
	}

	public String getStatement() {
		return statement;
	}

	public Set<OptionsDTO> getOptions() {
		return options;
	}

	public String getType() {
		return type;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public void setOptions(Set<OptionsDTO> options) {
		this.options = options;
	}

}
