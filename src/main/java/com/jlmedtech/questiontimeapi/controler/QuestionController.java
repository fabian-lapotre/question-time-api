package com.jlmedtech.questiontimeapi.controler;

import com.jlmedtech.questiontimeapi.dto.model.QuestionDTO;

import com.jlmedtech.questiontimeapi.model.QuestionModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "${controllers.base.path}/question")
public class QuestionController {

	private List<QuestionModel> realQuestions;

	QuestionController(){
		realQuestions = new ArrayList<>();
		realQuestions.add(new QuestionModel(0, "First question", null));
		realQuestions.add(new QuestionModel(1, "this is a test", null));
		realQuestions.add(new QuestionModel(2, "An other question", null));
		realQuestions.add(new QuestionModel(3, "last question", null));
	}

	@GetMapping(name = "get all questions")
	public List<QuestionDTO> getQuestions() {

		// TODO: create a service to get questions
		List<QuestionDTO> questions = new ArrayList<>();
		realQuestions.stream().forEach(
				questionModel -> {
					questions.add(new QuestionDTO(questionModel.getQuestion()));
				}
		);

		return questions;
	}

	@PostMapping(name = "add a question")
	public void addQuestion(@RequestBody QuestionDTO newQuestion) {

		//TODO: create a service to add a question
		QuestionModel newQuestionModel = new QuestionModel(4, newQuestion.question, "");
		realQuestions.add(newQuestionModel);

	}

}
