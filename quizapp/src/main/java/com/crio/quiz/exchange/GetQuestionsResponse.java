package com.crio.quiz.exchange;

import com.crio.quiz.dto.Question;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class GetQuestionsResponse {
  private List<Question> questions;
}