/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.quiz.repositoryservices;

import com.crio.quiz.dto.Question;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepositoryService {

  List<Question> findAllQuestions();

  Question findByQuestionId(String questionId);



}


