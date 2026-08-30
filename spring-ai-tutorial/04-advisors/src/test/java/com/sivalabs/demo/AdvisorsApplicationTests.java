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
class AdvisorsApplicationTests {

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
    void chatWithSensitiveWordsShouldNotBeSentToLLM() {
        MvcTestResult testResult = mockMvcTester.post().uri("/ai/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "question": "Why javascript ecosystem moves at a fucking crazy speed?"
                        }
                        """)
                .exchange();

        assertThat(testResult)
                .hasStatusOk()
                .bodyJson()
                .convertTo(ChatController.Answer.class)
                .satisfies(answer -> {
                    assertThat(answer.answer()).contains("I'm unable to respond to that due to sensitive content");
                    System.out.println("Response:\n"+answer.answer());
                });
    }
}
