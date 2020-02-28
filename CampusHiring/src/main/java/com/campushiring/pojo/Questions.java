package com.campushiring.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Questions")

public class Questions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Questions() {
		super();
	}

	@Id
	@Column(name = "QUESTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_id;
	@Column(name = "STATEMENT")
	private String statement;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "DIFFICULTY_LEVEL")
	private String difficulty;

	@OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)
	Set<Options> options = new HashSet<Options>();

//	@OneToOne(mappedBy = "fkquestions", cascade = CascadeType.ALL)
//	Response response = new Response();

	public Questions(String statement, String type, String difficulty) {
		this.statement = statement;
		this.difficulty = difficulty;
		this.type = type;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}

//	public Response getResponse() {
//		return response;
//	}
//
//	public void setResponse(Response response) {
//		this.response = response;
//	}
}
