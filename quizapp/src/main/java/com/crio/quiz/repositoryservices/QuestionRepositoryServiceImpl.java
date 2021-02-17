/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.quiz.repositoryservices;

import com.crio.quiz.dto.Options;
import com.crio.quiz.dto.Question;
import com.crio.quiz.models.QuestionEntity;
import com.crio.quiz.repository.QuestionRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@Primary
public class QuestionRepositoryServiceImpl implements QuestionRepositoryService {

  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private MongoTemplate mongoTemplate;

  @Autowired
  private Provider<ModelMapper> modelMapperProvider;

  @Override
  public List<Question> findAllQuestions() {
    List<Question> questions = new ArrayList<>();
    List<QuestionEntity> allQuestionEntitiesList = questionRepository.findAll();
    System.out.println(allQuestionEntitiesList.get(0).toString());
    ModelMapper modelMapper = modelMapperProvider.get();
    for (QuestionEntity questionEntity : allQuestionEntitiesList) {
      questions.add(modelMapper.map(questionEntity, Question.class));
      String optionsOfLastAddedQuestion = questionEntity.getOptions();
      ObjectMapper objMap = new ObjectMapper();
      HashMap<Integer, String> opts;
      try {
        if (optionsOfLastAddedQuestion != null) {
          TypeReference<HashMap<Integer,String>> typeRef 
              = new TypeReference<HashMap<Integer,String>>() {};
          opts = objMap.readValue(optionsOfLastAddedQuestion, typeRef);
          
          // System.out.println("Your options are : " + opts.toString());
          questions.get(questions.size() - 1).setOptions(opts);
          // System.out.println("You've created" + questions.get(questions.size() - 1).toString());
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    // System.out.println(questions.get(0).toString());
    return questions;
  }

  @Override
  public Question findByQuestionId(String questionId) {
    QuestionEntity questionEntity = questionRepository.findByQuestionId(questionId);
    ModelMapper modelMapper = modelMapperProvider.get();
    Question question = null;
    try {
      question = modelMapper.map(questionEntity, Question.class);
      String optionsOfLastAddedQuestion = questionEntity.getOptions();
      ObjectMapper objMap = new ObjectMapper();
      HashMap<Integer, String> opts;
      TypeReference<HashMap<Integer,String>> typeRef 
          = new TypeReference<HashMap<Integer,String>>() {};
      opts = objMap.readValue(optionsOfLastAddedQuestion, typeRef);
      
      // System.out.println("Your options are : " + opts.toString());
      question.setOptions(opts);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return question;
  }
}

