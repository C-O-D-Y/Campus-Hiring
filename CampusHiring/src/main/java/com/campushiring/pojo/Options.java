package com.campushiring.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Options")
public class Options implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPTION_ID")
	private int option_id;
	@Column(name = "OPTION")
	private String option;
	@Column(name = "IS_TRUE")
	private String is_correct;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_QuestionsId")
	private Questions questions;

//	@OneToOne(mappedBy = "fkoptionId", cascade = CascadeType.ALL)
//	Response response = new Response();

	public Options() {

	}

	public Options(Options options, Questions que) {
		this.is_correct = options.is_correct;
		this.option = options.option;
		this.questions = que;
	}

//	public Response getResponse() {
//		return response;
//	}
//
//	public void setResponse(Response response) {
//		this.response = response;
//	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}

	public int getOption_id() {
		return option_id;
	}

	public String getIs_correct() {
		return is_correct;
	}

	public void setIs_correct(String is_correct) {
		this.is_correct = is_correct;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
}
