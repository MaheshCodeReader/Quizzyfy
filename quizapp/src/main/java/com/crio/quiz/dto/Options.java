package com.crio.quiz.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Options {
  @JsonProperty(value = "1")
  private String optOne;
  @JsonProperty(value = "2")
  private String optTwo;
  @JsonProperty(value = "3")
  private String optThree;
  @JsonProperty(value = "4")
  private String optFour;
}