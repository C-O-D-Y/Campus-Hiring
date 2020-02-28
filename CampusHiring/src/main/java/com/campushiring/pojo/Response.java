package com.campushiring.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESPONSE")
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	public Response() {
		super();
	}

	@Id
	@Column(name = "RESPONSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int responseId;

	@Column(name = "USER_ID")
	private long userId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getSelectedOptionId() {
		return selectedOptionId;
	}

	public void setSelectedOptionId(int selectedOptionId) {
		this.selectedOptionId = selectedOptionId;
	}

	
	@Column(name = "QUESTION_ID")
	private int questionId;

	@Column(name = "SELECTED_OPTION_ID")
	private int selectedOptionId;

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public Response(int responseId, long userId, int questionId, int selectedOptionId) {
		super();
		this.responseId = responseId;
		this.userId = userId;
		this.questionId = questionId;
		this.selectedOptionId = selectedOptionId;
	}

//	@OneToOne(cascade = CascadeType.ALL, targetEntity = Questions.class)
//	@JoinColumn(name = "FK_QuestionsId")
//	private Integer fkquestions;
//
//	@OneToOne(cascade = CascadeType.ALL, targetEntity = Options.class)
//	@JoinColumn(name = "FK_optionId")
//	private Integer fkoptionId;
//
//	@OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
//	@JoinColumn(name = "FK_UserId")
//	private Integer fkuserId;
}
