package com.jlmedtech.questiontimeapi.controler;

import com.jlmedtech.questiontimeapi.dto.QuestionDTO;
import com.jlmedtech.questiontimeapi.dto.mapper.QuestionMapper;
import com.jlmedtech.questiontimeapi.model.QuestionModel;
import com.jlmedtech.questiontimeapi.service.IQuestionService;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "${controllers.base.path}/question")
public class QuestionController {

    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);

    private IQuestionService questionService;

    private QuestionMapper questionMapper = Mappers.getMapper(QuestionMapper.class);

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(name = "get all questions", produces = "application/x-protobuf")
    public QuestionDTO.Questions getQuestionsAsProtoBuf() {

        QuestionDTO.Questions questions = this.getQuestions();

        log.debug("[controlleur-get-protobuf ${controllers.base.path}/question ]: sending questions in proto format: ", questions);
        return questions;
    }

    @GetMapping(name = "get all questions",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionDTO.Questions getQuestionsAsJson() {
        QuestionDTO.Questions questions = this.getQuestions();
        log.debug("sending questions in json format: ");
        return questions;
    }

    private QuestionDTO.Questions getQuestions() {
        QuestionDTO.Questions.Builder questionDTOBuilder = QuestionDTO.Questions.newBuilder();
        List<QuestionModel> questionsModel = questionService.getQuestions();
        List<QuestionDTO.Question> questions = questionsModel.stream().map(questionModel -> questionMapper.questionModelToQuestionDTO(questionModel)).collect(Collectors.toList());
        return QuestionDTO.Questions.newBuilder().addAllQuestions(questions).build();
    }


    @GetMapping(value = "{id}", name = "get a question")
    public QuestionDTO.Question getQuestion(@PathVariable Integer id) {
        return questionMapper.questionModelToQuestionDTO(questionService.getQuestion(id));
    }

    @PostMapping(name = "add a question")
    public ResponseEntity<QuestionDTO.Question> addQuestion(@RequestBody QuestionDTO.Question newQuestion) {
        return ResponseEntity.ok(questionMapper.questionModelToQuestionDTO(questionService.addQuestion(questionMapper.questionDTOToQuestionModel(newQuestion))));
    }

/*    @DeleteMapping(name="delete question")
    public ResponseEntity deletQuestion{

        return ResponseEntity.ok("this is ok");
    }*/

}
