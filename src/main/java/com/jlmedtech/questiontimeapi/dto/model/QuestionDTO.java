package com.jlmedtech.questiontimeapi.dto.model;

public class QuestionDTO {

	public final long id;
	public String question;

	public QuestionDTO(long id, String question) {
		this.id = id;
		this.question = question ;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	@Override public String toString() {
		return "QuestionDTO{" +
				"id=" + id +
				", question='" + question + '\'' +
				'}';
	}
}
