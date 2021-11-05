package com.jlmedtech.questiontimeapi.model;

import java.util.List;

public class QuestionModel {

	private final long id;

	private String question;

	private List<String> responses;

	public QuestionModel(long id, String question, List<String> responses ) {
		this.id = id;
		this.question = question;
		this.responses = responses;
	}

	public long getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getResponses() {
		return responses;
	}

	public void setResponses(List<String> responses) {
		this.responses = responses;
	}

	@Override public String toString() {
		return "QuestionModel{" +
				"id=" + id +
				", question='" + question + '\'' +
				", response='" + responses + '\'' +
				'}';
	}
}
