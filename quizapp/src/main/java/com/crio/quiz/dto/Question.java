package com.crio.quiz.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Question {
  // @JsonIgnore
  // private String id;
  private String questionId;
  private String title;
  private String description;
  private String type;
  @JsonProperty(value = "options")
  private HashMap<Integer, String> options;
  private List<String> correctAnswer;
  

}

