package com.crio.quiz.repository;

import com.crio.quiz.models.QuestionEntity;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface QuestionRepository extends MongoRepository<QuestionEntity, String> {
  // GreetingsEntity findByExtId(String extId);
  QuestionEntity findByQuestionId(String questionId);
}
