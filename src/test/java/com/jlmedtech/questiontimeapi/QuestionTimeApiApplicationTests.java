package com.jlmedtech.questiontimeapi;

import com.jlmedtech.questiontimeapi.controler.QuestionController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuestionTimeApiApplicationTests {

	@Autowired
	private QuestionController questionController;

	@Test
	void contextLoads() {
		assertThat(questionController).isNotNull();
	}

}
