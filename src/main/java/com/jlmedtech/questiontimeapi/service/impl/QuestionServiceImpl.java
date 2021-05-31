package com.jlmedtech.questiontimeapi.service.impl;

import com.jlmedtech.questiontimeapi.dto.model.QuestionDTO;
import com.jlmedtech.questiontimeapi.model.QuestionModel;
import com.jlmedtech.questiontimeapi.service.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

	private List<QuestionModel> realQuestions;

	QuestionServiceImpl() {
		realQuestions = new ArrayList<>();
		realQuestions.add(new QuestionModel(0, "First question", null));
		realQuestions.add(new QuestionModel(1, "this is a test", null));
		realQuestions.add(new QuestionModel(2, "An other question", null));
		realQuestions.add(new QuestionModel(3, "last question", null));
	}

	@Override public List<QuestionDTO> getQuestions() {

		List<QuestionDTO> questions = new ArrayList<>();
		realQuestions.stream().forEach(
				questionModel -> {
					questions.add(new QuestionDTO(questionModel.getQuestion()));
				}
		);
		return questions;
	}

	@Override public QuestionDTO addQuestion(QuestionDTO question) {
		QuestionModel newQuestionModel = new QuestionModel(4, question.question, "");
		realQuestions.add(newQuestionModel);
		return question;
	}
}
