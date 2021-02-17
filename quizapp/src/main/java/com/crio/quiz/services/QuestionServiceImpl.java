package com.crio.quiz.services;

import com.crio.quiz.dto.Question;
import com.crio.quiz.exchange.GetQuestionsResponse;
import com.crio.quiz.repositoryservices.QuestionRepositoryService;

import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
  @Autowired
  private final QuestionRepositoryService questionRepositoryService;

  @Override
  public GetQuestionsResponse getAllQuestions() {
    List<Question> results = null;
    try {
      results = questionRepositoryService.findAllQuestions();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new GetQuestionsResponse(results);
  }

  public Question getQuestionByQuestionId(String questionId) {
    if (questionId == null) {
      return null;
    }
    Question result = questionRepositoryService.findByQuestionId(questionId);
    return result;   
  }
}