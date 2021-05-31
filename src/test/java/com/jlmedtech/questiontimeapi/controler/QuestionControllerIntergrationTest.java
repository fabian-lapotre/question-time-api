package com.jlmedtech.questiontimeapi.controler;

import com.jlmedtech.questiontimeapi.dto.model.QuestionDTO;
import com.jlmedtech.questiontimeapi.service.IQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerIntergrationTest {

	@MockBean
	IQuestionService questionService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void askForQuestion_thenGiveQuestions() throws Exception {

		List<QuestionDTO> questions;
		questions = new ArrayList<>();
		questions.add(new QuestionDTO("First question"));
		questions.add(new QuestionDTO("this is a test"));
		questions.add(new QuestionDTO("An other question"));
		questions.add(new QuestionDTO("last question"));

		when(questionService.getQuestions()).thenReturn(questions);

		this.mockMvc.perform(get("/api/v1/question"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("First question")))
				.andExpect(content().string(containsString("this is a test")))
				.andExpect(content().string(containsString("An other question")))
				.andExpect(content().string(containsString("last question")));
	}

	@Test
	public void postQuestion_thenVerifyQuestionIsSave() throws Exception {

		QuestionDTO myNewQuestion = new QuestionDTO("this is a test");
		when(questionService.addQuestion(myNewQuestion)).thenReturn(myNewQuestion);
		this.mockMvc.perform(
				post("/api/v1/question")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"question\": \"question that is a test\"}"))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
