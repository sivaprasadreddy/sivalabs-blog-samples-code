package com.sivalabs.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class OpenAIChatApplicationTests {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    void chat() {
        MvcTestResult testResult = mockMvcTester.post().uri("/ai/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "question": "Why Java is so popular in enterprise software development?"
                        }
                        """)
                .exchange();

        assertThat(testResult)
                .hasStatusOk()
                .bodyJson()
                .convertTo(ChatController.Answer.class)
                .satisfies(answer -> {
                    assertThat(answer.answer()).isNotBlank();
                    System.out.println("Response:\n"+answer.answer());
                });
    }

    @Test
    void suggestTitles() {
        MvcTestResult testResult = mockMvcTester
                .post()
                .uri("/ai/suggest-titles")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "topic": "Spring Boot Tips and Tricks",
                            "count": 3
                        }
                        """)
                .exchange();

        assertThat(testResult)
                .hasStatusOk()
                .bodyJson()
                .convertTo(ChatController.Answer.class)
                .satisfies(answer -> {
                    assertThat(answer.answer()).isNotBlank();
                    System.out.println("Response:\n"+answer.answer());
                });
    }

}
