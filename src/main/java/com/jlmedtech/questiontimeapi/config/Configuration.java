package com.jlmedtech.questiontimeapi.config;

import com.jlmedtech.questiontimeapi.model.QuestionModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackageClasses = QuestionModel.class)
public class Configuration {

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter(){
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    public ProtobufJsonFormatHttpMessageConverter protobufJsonFormatHttpMessageConverter() {
        return new ProtobufJsonFormatHttpMessageConverter();
    }

}
