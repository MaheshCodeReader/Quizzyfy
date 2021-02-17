package com.crio.quiz.controller;

import com.crio.quiz.dto.AllUserResponsesSubmitRequest;
import com.crio.quiz.dto.Question;
import com.crio.quiz.dto.QuestionInResponse;
import com.crio.quiz.dto.SubmitQuestionResponse;
import com.crio.quiz.dto.Summary;
import com.crio.quiz.dto.UserResponseOneQuestion;
import com.crio.quiz.exchange.GetQuestionsResponse;
import com.crio.quiz.services.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class QuizController {

  public static final String QUIZ_API = "/quiz/1";

  @Autowired
  private QuestionService questionService;

  @GetMapping("/")
  public String demoMapping() {

    log.info("demoMapping called");
    return "Welcome to root.";
  }

  @GetMapping("/usage")
  public String getUsageDirections() {
    
    return "Module Id 1 is default, and other module Ids are not supported.";
  }

  // public String getRequest(@RequestParam String moduleId) throws JsonProcessingException {
  @GetMapping(QUIZ_API)
  public String getRequest() throws JsonProcessingException {
    GetQuestionsResponse getQuestionsResponse = questionService.getAllQuestions();
    
    ObjectMapper objMap = new ObjectMapper();
    String response = objMap
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(getQuestionsResponse);
    // return "response from /quiz" + moduleId;
    return response;
  }


  // public String postRequest(@RequestParam String moduleId) {
  @PostMapping(QUIZ_API)
  public String postRequest(@RequestBody AllUserResponsesSubmitRequest request) {
    if (request == null) {
      return null;
    } 
    // System.out.println("post request HIT");
    // System.out.println(request.toString());
    // GetQuestionsResponse getQuestionsResponse = null;

    List<QuestionInResponse> questionsInResponse = new ArrayList<>();
    for (UserResponseOneQuestion response : request.getResponses()) {
      Question questionOriginal = questionService.getQuestionByQuestionId(response.getQuestionId());
      QuestionInResponse questionInResponse = new QuestionInResponse();
      questionInResponse.setQuestionId(questionOriginal.getQuestionId());
      questionInResponse.setTitle(questionOriginal.getTitle());
      questionInResponse.setDescription(questionOriginal.getDescription());
      questionInResponse.setType(questionOriginal.getType());
      questionInResponse.setOptions(questionOriginal.getOptions());
      questionInResponse.setCorrect(questionOriginal.getCorrectAnswer());
      questionInResponse.setUserAnswer(response.getUserResponse());
      questionInResponse.setExplanation(null);
      questionInResponse.setAnswerCorrect(
          isAnswerCorrect(
              questionInResponse.getUserAnswer(), questionInResponse.getCorrect()));

      questionsInResponse.add(questionInResponse);
    }

    Summary summary = new Summary();
    Long total = Long.valueOf(questionsInResponse.size());
    Long score = calculateScore(questionsInResponse);
    summary.setScore(score);
    summary.setTotal(total);

    SubmitQuestionResponse result = new SubmitQuestionResponse();
    result.setQuestions(questionsInResponse);
    result.setSummary(summary);

    ObjectMapper objMap = new ObjectMapper();
    String response = "";
    try {
      response = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    // return "response from /quiz" + moduleId;
    return response;
  }

  private Long calculateScore(List<QuestionInResponse> questionsInResponse) {
    Long count = 0L;
    for (QuestionInResponse q : questionsInResponse) {
      if (q.getAnswerCorrect()) {
        count++;
      }
    }
    return count;
  }

  private Boolean isAnswerCorrect(List<String> userResponse, List<String> correctAnswers) {
    if (userResponse.size() != correctAnswers.size()) {
      return false;
    } else {
      Boolean result = true;
      for (String s : userResponse) {
        if (!correctAnswers.contains(s)) {
          result = false;
          break;
        }
      }
      return result;
    }

  }
}