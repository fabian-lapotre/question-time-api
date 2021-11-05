package com.jlmedtech.questiontimeapi.service.impl;

import com.jlmedtech.questiontimeapi.model.QuestionModel;
import com.jlmedtech.questiontimeapi.repository.QuestionsRepository;
import com.jlmedtech.questiontimeapi.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private static final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);

    private QuestionsRepository questionsRepository;

    public QuestionServiceImpl(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public List<QuestionModel> getQuestions() {
        List<QuestionModel> questions = questionsRepository.get();
        log.debug("[service]: sending questions: ", questions);
        return questions;
    }

    @Override
    public QuestionModel getQuestion(Integer id) {
        return questionsRepository.get(id);
    }

    @Override
    public QuestionModel addQuestion(QuestionModel question) {
        questionsRepository.add(question);
        return question;
    }
}
