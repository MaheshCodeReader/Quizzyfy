package com.crio.quiz.services;

import com.crio.quiz.dto.Question;
import com.crio.quiz.exchange.GetQuestionsResponse;
import org.springframework.stereotype.Service;



@Service
public interface QuestionService {

  GetQuestionsResponse getAllQuestions();

  Question getQuestionByQuestionId(String questionId);
}
