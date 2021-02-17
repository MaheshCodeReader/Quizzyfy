package com.crio.quiz.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.net.URI;

import com.crio.quiz.QuizApplication;
import com.crio.quiz.services.GreetingsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;


// @MockitoSettings(strictness = Strictness.STRICT_STUBS)
@SpringBootTest(classes = {QuizApplication.class})
@AutoConfigureMockMvc
@DirtiesContext
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class GreetingsControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private GreetingsService greetingsService;

  // @Test
  // void sayHello() throws Exception {
  //   //given
  //   Mockito.doReturn(new ResponseDto("Hello Java"))
  //       .when(greetingsService).getMessage("001");

  //   // when
  //   URI uri = UriComponentsBuilder
  //       .fromPath("/say-hello")
  //       .queryParam("messageId", "001")
  //       .build().toUri();

  //   MockHttpServletResponse response = mvc.perform(
  //       get(uri.toString()).accept(APPLICATION_JSON_VALUE)
  //   ).andReturn().getResponse();

  //   //then
  //   String responseStr = response.getContentAsString();
  //   ObjectMapper mapper = new ObjectMapper();
  //   ResponseDto responseDto = mapper.readValue(responseStr, ResponseDto.class);
  //   ResponseDto ref = new ResponseDto("Hello Java");

  //   assertEquals(responseDto, ref);
  //   Mockito.verify(greetingsService, Mockito.times(1)).getMessage("001");
  // }
}
