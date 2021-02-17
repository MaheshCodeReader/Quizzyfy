package com.crio.quiz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionInResponse {
  private String questionId;
  private String title;
  private String description;
  private String type;
  @JsonProperty(value = "options")
  private HashMap<Integer, String> options;
  private List<String> userAnswer;
  private List<String> correct;
  private String explanation;
  private Boolean answerCorrect;
}
