package com.campushiring.pojo;

public class QuestionsDTO {

	private int question_id;

	private String statement;

	private String type;

	private String difficulty;

	public int getQuestion_id() {
		return question_id;
	}

	public String getStatement() {
		return statement;
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

	public String getType() {
		return type;
	}

	public String getDifficulty() {
		return difficulty;
	}
}
