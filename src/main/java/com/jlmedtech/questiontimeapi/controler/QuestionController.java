package com.jlmedtech.questiontimeapi.controler;

import com.jlmedtech.questiontimeapi.dto.model.QuestionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class QuestionController {

	private static final List<QuestionDTO> questions = new ArrayList<>(Arrays.asList(
			new QuestionDTO(0,"this is the first question"),
			new QuestionDTO(1,"this is a test"),
			new QuestionDTO(2,"An other question"),
			new QuestionDTO(3,"last question")
	));

	@GetMapping("/questions")
	public List<QuestionDTO> getQuestions(){
		return questions;
	}

}
