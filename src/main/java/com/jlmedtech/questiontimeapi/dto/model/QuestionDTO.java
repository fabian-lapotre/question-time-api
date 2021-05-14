package com.jlmedtech.questiontimeapi.dto.model;

public class QuestionDTO {

	public String question;

	public QuestionDTO(){

	}

	public QuestionDTO(String question) {
		this.question = question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	@Override public String toString() {
		return "QuestionDTO{" +
				", question='" + question + '\'' +
				'}';
	}
}
