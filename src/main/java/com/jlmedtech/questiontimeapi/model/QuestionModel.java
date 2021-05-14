package com.jlmedtech.questiontimeapi.model;

public class QuestionModel {

	private final long id;
	private String question;
	private String response;

	public QuestionModel(long id, String question, String response ) {
		this.id = id;
		this.question = question;
		this.response = response;
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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override public String toString() {
		return "QuestionModel{" +
				"id=" + id +
				", question='" + question + '\'' +
				", response='" + response + '\'' +
				'}';
	}
}
