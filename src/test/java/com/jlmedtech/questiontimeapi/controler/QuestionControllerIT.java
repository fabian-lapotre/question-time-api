package com.jlmedtech.questiontimeapi.controler;

import com.jlmedtech.questiontimeapi.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerIT {

	@MockBean
	QuestionService questionService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void askForQuestion_thenGiveQuestions() throws Exception {

	}

	@Test
	public void postQuestion_thenVerifyQuestionIsSave() throws Exception {


	}

}
