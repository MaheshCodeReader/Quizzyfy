package com.crio.quiz.models;

import com.crio.quiz.dto.Options;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
@NoArgsConstructor
public class QuestionEntity {
  @Id
  private String id;

  @NotNull
  private String questionId;
  @NotNull
  private String title;
  @NotNull
  private String description;
  @NotNull
  private String type;
  @NotNull
  private List<String> correctAnswer = new ArrayList<>();

  private String options;
}