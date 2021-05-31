package com.jlmedtech.questiontimeapi.controler;

import com.jlmedtech.questiontimeapi.dto.model.QuestionDTO;
import com.jlmedtech.questiontimeapi.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${controllers.base.path}/question")
public class QuestionController {

	@Autowired
	private IQuestionService questionService;

	@GetMapping(name = "get all questions")
	public List<QuestionDTO> getQuestions() {

		return questionService.getQuestions();

	}

	@PostMapping(name = "add a question")
	public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionDTO newQuestion) {

		return ResponseEntity.ok(questionService.addQuestion(newQuestion));
	}

}
