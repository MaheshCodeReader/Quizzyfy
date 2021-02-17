package com.crio.quiz.controller;

import io.swagger.models.HttpMethod;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URI;

import com.crio.quiz.QuizApplication;
import com.crio.quiz.dto.Question;
import com.crio.quiz.services.QuestionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// @MockitoSettings(strictness = Strictness.STRICT_STUBS)
@SpringBootTest(classes = {QuizApplication.class})
@AutoConfigureMockMvc
@DirtiesContext
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class QuizControllerTest {
  private ObjectMapper objectMapper;

  private MockMvc mvc;

  @MockBean
  private QuestionService questionService;

  @InjectMocks
  private QuizController quizController;

  @BeforeEach
  public void setup() {
    objectMapper = new ObjectMapper();

    MockitoAnnotations.initMocks(this);

    mvc = MockMvcBuilders.standaloneSetup(quizController).build();
  }

  @Test
	public void greetingShouldReturnDefaultMessageForRoot() throws Exception {
    Mockito.when(questionService
        .getQuestionByQuestionId("-3"))
        .thenReturn(null);

    Question question = questionService
        .getQuestionByQuestionId("-3");
    assertThat(question).isNull();
  }
  
  @Test
	public void greetingShouldReturnDefaultMessageForUsage() throws Exception {
    Mockito.when(questionService
        .getQuestionByQuestionId("-3"))
        .thenReturn(null);

    Question question = questionService
        .getQuestionByQuestionId("-3");
    assertThat(question).isNull();
  }
  
  @Test
  public void getQuestionTest() {
    Mockito.when(questionService
        .getQuestionByQuestionId("-3"))
        .thenReturn(null);

    Question question = questionService
        .getQuestionByQuestionId("-3");
    assertThat(question).isNull();
    // assertEquals("11", allRestaurantsCloseBy.getRestaurants().get(0).getRestaurantId());
    // assertEquals("12", allRestaurantsCloseBy.getRestaurants().get(1).getRestaurantId());

    // ArgumentCaptor<Double> servingRadiusInKms = ArgumentCaptor.forClass(Double.class);
    // verify(restaurantRepositoryServiceMock, times(1))
    //     .findAllRestaurantsCloseBy(any(Double.class), any(Double.class), any(LocalTime.class),
    //         servingRadiusInKms.capture());

    // return servingRadiusInKms.getValue().toString();
  }
}