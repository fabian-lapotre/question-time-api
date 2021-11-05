package com.jlmedtech.questiontimeapi.service;

import com.jlmedtech.questiontimeapi.dto.QuestionDTO;
import com.jlmedtech.questiontimeapi.model.QuestionModel;

import java.util.List;

public interface QuestionService {

	List<QuestionModel> getQuestions();

	QuestionModel getQuestion(Integer id);

	QuestionModel addQuestion(QuestionModel question);

}
