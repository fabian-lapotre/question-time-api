package com.jlmedtech.questiontimeapi.service;

import com.jlmedtech.questiontimeapi.model.QuestionModel;
import com.jlmedtech.questiontimeapi.repository.QuestionsRepository;
import com.jlmedtech.questiontimeapi.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Tag("questions")
@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    private QuestionsRepository questionsRepository;

    private QuestionService serviceUnderTest;

    @BeforeEach
    void init(){
        serviceUnderTest = new QuestionServiceImpl(questionsRepository);
    }

    @AfterEach
    void deleteService(){
        serviceUnderTest = null;
    }

    @Test
    @DisplayName("Assert that when you ask questions, you receive questions")
    void getQuestions() {
        //Give
        when(questionsRepository.get()).thenReturn(Arrays.asList(
                new QuestionModel(1,"this is a test", Arrays.asList("first answer","second")),
                new QuestionModel(2,"Second question", Arrays.asList("first answer","second")),
                new QuestionModel(3,"Third question", Arrays.asList("first answer","second")),
                new QuestionModel(4,"Last question of the test", Arrays.asList("first answer","second"))
        ));

        //When
        List<QuestionModel> questions = serviceUnderTest.getQuestions();

        //Then
        assertThat(questions).extracting(QuestionModel::getId,QuestionModel::getQuestion,QuestionModel::getResponses)
                .containsExactly(tuple(1L,"this is a test",Arrays.asList("first answer","second")),
                        tuple(2L,"Second question",Arrays.asList("first answer","second")),
                        tuple(3L,"Third question",Arrays.asList("first answer","second")),
                        tuple(4L,"Last question of the test",Arrays.asList("first answer","second")));
    }

    @Nested
    @Tag("GetQuestion")
    @DisplayName("Should be able to get question that are store inside DB")
    class GetQuestion {

        @Test
        @DisplayName("Return the question when the question is in the dataset")
        void giveId_whenAskQuestion_returnQuestion() {
            //Give
            when(questionsRepository.get(2)).thenReturn(new QuestionModel(2,"",null));

            //When
            QuestionModel question = serviceUnderTest.getQuestion(2);

            //Then
            assertThat(question).extracting(QuestionModel::getId).isEqualTo(2L);
        }

        @Test
        @DisplayName("Throw error when the question is not in the dataset")
        void giveFakeId_whenAskQuestion_throwError(){
            //Give
            when(questionsRepository.get(10)).thenReturn(null);

            //When
           QuestionModel question = serviceUnderTest.getQuestion(10);

            //Then
            assertThat(question).isNull();
        }

    }


    @Test
    @DisplayName("Give a QuestionModel to service and see if add function of repository is call")
    void addQuestion() {
        //Give
        when(questionsRepository.add(any(QuestionModel.class))).thenReturn(new QuestionModel(1,"",null));

        //When
        QuestionModel question = serviceUnderTest.addQuestion(new QuestionModel(1,"",null));

        //Then
        assertThat(question).extracting(QuestionModel::getId,QuestionModel::getQuestion,QuestionModel::getResponses)
                .containsExactly(1L,"",null);
    }
}