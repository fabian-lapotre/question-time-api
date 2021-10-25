package com.jlmedtech.questiontimeapi.service.impl;

import com.jlmedtech.questiontimeapi.model.QuestionModel;
import com.jlmedtech.questiontimeapi.service.IQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

    private static final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);

    private List<QuestionModel> realQuestions;

    QuestionServiceImpl() {
        realQuestions = new ArrayList<>();
        realQuestions.add(new QuestionModel(0,"first question",null));
        realQuestions.add(new QuestionModel(1,"second question",null));
        realQuestions.add(new QuestionModel(2,"an other question",null));
        realQuestions.add(new QuestionModel(3,"last question",null));
    }

    @Override
    public List<QuestionModel> getQuestions() {
        log.debug("[service]: sending questions: ", realQuestions);
        return realQuestions;
    }

    @Override
    public QuestionModel getQuestion(Integer id) {
        return realQuestions.get(id);
    }

    @Override
    public QuestionModel addQuestion(QuestionModel question) {
        Integer newItemId = realQuestions.size();
        realQuestions.add(question);
        return question;
    }
}
