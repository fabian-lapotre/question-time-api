package com.jlmedtech.questiontimeapi.service;

import com.jlmedtech.questiontimeapi.dto.model.QuestionDTO;

import java.util.List;

public interface IQuestionService {

	List<QuestionDTO> getQuestions();

	QuestionDTO addQuestion(QuestionDTO question);

}
