package com.sivalabs.demo;

import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
@AutoConfigureMockMvc
class ChatMemoryApplicationTests {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    void shouldMaintainChatMemoryAcrossRequests() {
        MvcTestResult introductionResult = chat("My name is Siva", null);

        assertThat(introductionResult).hasStatusOk();
        Cookie conversationCookie = introductionResult.getResponse().getCookie("X-CONV-ID");
        assertThat(conversationCookie).isNotNull();

        MvcTestResult followUpResult = chat("What is my name?", conversationCookie);

        assertThat(followUpResult)
                .hasStatusOk()
                .bodyJson()
                .convertTo(ChatController.Answer.class)
                .satisfies(answer -> assertThat(answer.answer()).containsIgnoringCase("Siva"));
    }

    private MvcTestResult chat(String question, Cookie conversationCookie) {
        var request = mockMvcTester.post()
                .uri("/ai/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "question": "%s"
                        }
                        """.formatted(question));

        if (conversationCookie != null) {
            request.cookie(conversationCookie);
        }

        return request.exchange();
    }

}
