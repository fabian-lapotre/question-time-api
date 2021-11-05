package com.jlmedtech.questiontimeapi.dto.mapper;

import com.jlmedtech.questiontimeapi.dto.QuestionDTO;
import com.jlmedtech.questiontimeapi.model.QuestionModel;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(source = "question", target = "questionString")
    @Mapping(source = "responses", target = "answersList")
    QuestionDTO.Question questionModelToQuestionDTO(QuestionModel question);

    @Mapping(source = "questionString", target = "question")
    @Mapping(source = "answersList", target = "responses")
    QuestionModel questionDTOToQuestionModel(QuestionDTO.Question question);

}
